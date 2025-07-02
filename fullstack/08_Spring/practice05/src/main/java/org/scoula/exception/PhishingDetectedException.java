package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Log4j2
public class PhishingDetectedException extends RuntimeException {
    public PhishingDetectedException(String message) {
        super(message);
    }
}

