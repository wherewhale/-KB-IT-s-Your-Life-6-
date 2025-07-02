package org.scoula.security.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
    private String username;
    private String password;
    private String email;
    private Date regDate;
    private Date updateDate;
    //반드시 한 개 이상의 권한이 부여되어있어야 한다.
    private List<AuthVO> authList; // 권한 목록, join 처리 필요
}
