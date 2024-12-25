package com.waveghost.uwhub.api.error_handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.waveghost.uwhub.api.dtos.errors.BaseErrorResponse;
import com.waveghost.uwhub.api.dtos.errors.ErrorResponse;
import com.waveghost.uwhub.api.dtos.errors.ErrorsResponse;
import com.waveghost.uwhub.utils.exceptions.BadRequestException;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse idNotFound(IdNotFoundException exception){
        return ErrorResponse.builder()
        .error(exception.getMessage())
        .status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value())
        .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse ErrorsResponse(MethodArgumentNotValidException exception) {
        List<String> Errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> Errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder().errors(Errors).status(HttpStatus.BAD_REQUEST.name())
            .code(HttpStatus.BAD_REQUEST.value()).build();
    }

    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse notOwner(BadRequestException exception){
        return ErrorResponse.builder()
        .error(exception.getMessage())
        .status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value())
        .build();
    }

}
