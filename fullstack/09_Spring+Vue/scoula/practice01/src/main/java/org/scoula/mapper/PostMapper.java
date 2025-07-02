package org.scoula.mapper;

import org.scoula.domain.PostVO;

public class PostMapper {
    //1. **게시글 단건 조회**
    //        - `id`를 받아 게시글 1개를 조회하는 쿼리를 작성합니다.
    //        - 조회 결과가 없으면 `null`을 반환합니다.
    //2. **게시글 등록**
    //        - `title`, `content`, `team_id` 값을 DB에 저장합니다.
    //        - 저장 후 생성된 `id` 값을 VO 객체에 자동으로 반영되도록 설정합니다.
    public PostVO get(Long id);

    public void create(String title, String content, Long team_id);
}
