package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostVO {
//    - `Long id` : 게시글 고유 번호 (PK)
//- `String title` : 게시글 제목
//- `String content` : 게시글 내용
//- `Long teamId` : 작성자의 팀 ID
    private Long id;
    private String title;
    private String content;
    private Long teamId;

    public static PostVO of(Long id, String title, String content, Long teamId) {
        return builder()
                .id(id)
                .title(title)
                .content(content)
                .teamId(teamId)
                .build();
    }
}
