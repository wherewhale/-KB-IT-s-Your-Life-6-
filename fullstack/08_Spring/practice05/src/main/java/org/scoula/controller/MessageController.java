package org.scoula.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.dto.MessageDTO;
import org.scoula.service.MessageService;
import org.scoula.service.MessageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageController {
    private final MessageService service;

    @PostMapping("/send")
    public ResponseEntity<String> create(@ApiParam(value = "게시글 객체", required = true) @RequestBody MessageDTO message) throws Exception {
        String result = service.sendMessage(message.getSender(), message.getContent());
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body(result);
    }
}
