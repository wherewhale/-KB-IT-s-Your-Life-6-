package org.scoula.service;

import lombok.extern.log4j.Log4j2;
import org.scoula.exception.PhishingDetectedException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageServiceImpl implements MessageService{

    @Override
    public String sendMessage(String sender, String content) throws Exception {
        String[] keywords = { "계좌번호", "보안카드", "대출" };

        for (String keyword : keywords) {
            if (content.contains(keyword)) {
                throw new PhishingDetectedException("의심스러운 단어 발견: " + keyword);
            }
        }

        log.info("메시지 전송됨 : " + content);
        return "메시지 전송 완료";
    }
}
