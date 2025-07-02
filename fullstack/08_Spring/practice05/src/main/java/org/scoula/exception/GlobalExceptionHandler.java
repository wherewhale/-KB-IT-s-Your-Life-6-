package org.scoula.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PhishingDetectedException.class)
    public ResponseEntity<String> handlePhishingException(PhishingDetectedException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain; charset=UTF-8");

        return ResponseEntity
                .badRequest()
                .headers(headers)
                .body("🚨 피싱 의심 메시지: " + ex.getMessage());
    }

    // (선택) 다른 일반 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain; charset=UTF-8");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .headers(headers)
                .body("서버 오류 발생: " + ex.getMessage());
    }
}
