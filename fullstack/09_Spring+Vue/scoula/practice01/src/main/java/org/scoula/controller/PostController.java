package org.scoula.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.domain.PostVO;
import org.scoula.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable("id") Long postId) {
        //만약 여기서 get 과정에 문제가 생기면? -> 500 코드 주거나 뭐 모시기
        //id가 없음?
        postService.get(postId);

        //성공이라면? PostVO 형태
        return ResponseEntity.ok().body();
    }

}
