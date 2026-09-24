package com.example.moreCatFacts.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.moreCatFacts.exception.TPotException;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TPotException.class)
    public ResponseEntity<String> handleTPotException(TPotException ex) throws IOException {
        if (ex.isResponseFormatHtml()) {
            String imageUrl = "/images/418.jpg";
            String htmlResponse = "<html><body>"
                    + "<h1>Terrible Mistake !</h1>"
                    + "<p>" + ex.getMessage() + "</p>"
                    + "<img src='" + imageUrl + "' alt='Error Image'/>"
                    + "</body></html>";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(htmlResponse, headers, 418);
        } else {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
