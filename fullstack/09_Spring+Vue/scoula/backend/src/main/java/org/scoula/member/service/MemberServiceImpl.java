package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.exception.PasswordMissmatchException;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final PasswordEncoder passwordEncoder;
    final MemberMapper mapper;

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);
        return member != null;
    }

    @Override
    public MemberDTO get(String username) {
        MemberVO member = Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);
        return MemberDTO.of(member);
    }

    //아바타 업로드
    private void saveAvatar(MultipartFile avatar, String username) {
        log.info("avatar", avatar);
        if(avatar != null && !avatar.isEmpty()) {
            log.info("avatar 있음 : ", avatar);
            // 첫 번째 인자 : 부모 디렉토리
            // 두 번째 인자 : 파일
            File dest = new File("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/09_Spring+Vue/scoula/backend/src/main/resources", username + ".png");
            try {
                avatar.transferTo(dest);
            } catch (IOException e) {
                // 런타임 예외에 대해서만 Transactional 반응
                throw new RuntimeException(e);
            }
        }
    }

    @Transactional
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVO();
        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화
        mapper.insert(member);
        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth);
        saveAvatar(dto.getAvatar(), member.getUsername());
        return get(member.getUsername());
    }

    @Override
    public MemberDTO update(MemberUpdateDTO member) {
        MemberVO vo = mapper.get(member.getUsername());
        //mySQL에도 캐싱 기능이 있는데, 한 번이라도 메모리에 올라온 이력이 있는 경우에는 한 번에 처리됨
        if(!passwordEncoder.matches(member.getPassword(),vo.getPassword())) { // 비밀번호 일치 확인
            throw new PasswordMissmatchException();
        }
        mapper.update(member.toVO());
        saveAvatar(member.getAvatar(), member.getUsername());
        return get(member.getUsername());
    }

    @Override
    public void changePassword(ChangePasswordDTO changePassword) {
        MemberVO member = mapper.get(changePassword.getUsername());

        if(!passwordEncoder.matches(changePassword.getOldPassword(), member.getPassword())) {
            throw new PasswordMissmatchException();
        }

        changePassword.setNewPassword(passwordEncoder.encode(changePassword.getNewPassword()));

        mapper.updatePassword(changePassword);
    }
}
