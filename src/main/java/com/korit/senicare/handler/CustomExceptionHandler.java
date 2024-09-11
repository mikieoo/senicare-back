package com.korit.senicare.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.korit.senicare.dto.response.ResponseDto;

// 예외 대처를 위한 REST API
// 특정한 예외를 선택해서 어떻게 대처하겠다. 할때 이 어노테이션을 지정해줌

@RestControllerAdvice
public class CustomExceptionHandler {
    
    // HttpMessageNotReadableException : Request Body가 없어서 읽지를 못할때 발생하는 오류
    // MethodArgumentNotValidException : 유효성 검사 실패
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseDto> validExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.validationFail();
    }

}
