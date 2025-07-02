package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDTO {
    String username; // 사용자 ID
    String oldPassword; // 이전 비밀번호
    String newPassword; // 새 비밀번호
    //비밀번호 확인은 클라이언트에서 확인하는 정보이며, 서버에서는 관리하지 않는다.
}
