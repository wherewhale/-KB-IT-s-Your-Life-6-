package org.scoula.service;

import org.scoula.domain.PostVO;

public interface PostService {
    PostVO get(Long id);

    void create(String title, String content, Long teamId);
}
