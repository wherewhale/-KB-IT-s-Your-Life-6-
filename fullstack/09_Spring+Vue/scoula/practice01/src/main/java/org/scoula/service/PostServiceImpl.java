package org.scoula.service;

import lombok.RequiredArgsConstructor;
import org.scoula.domain.PostVO;
import org.scoula.mapper.PostMapper;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    final PostMapper mapper;

    @Override
    public PostVO get(Long id) {
        mapper.get()
    }

    @Override
    public void create(String title, String content, Long teamId) {

    }
}
