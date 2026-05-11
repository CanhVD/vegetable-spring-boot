package com.example.vegetable_shop.controller;
import com.example.vegetable_shop.exception.BindingResultException;
import com.example.vegetable_shop.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

@Slf4j
public class BaseRestController {

    protected <T> ResponseEntity<BaseResponse<T>> execute(Supplier<T> supplier) {
        try {
            T result = supplier.get();
            return successResponse(result);
        } catch (Exception ex) {
            return errorResponse(ex);
        }
    }

    protected <T> ResponseEntity<BaseResponse<T>> successResponse(T data) {
        return new ResponseEntity<>(
                BaseResponse.<T>builder().code(0).msg("Success").data(data).build(),
                HttpStatus.OK
        );
    }

    protected <T> ResponseEntity<BaseResponse<T>> errorResponse(Exception exception) {
        BaseResponse<T> response = BaseResponse.<T>builder().code(1).msg(exception.getMessage()).build();

        if (exception instanceof RuntimeException) {
            response = BaseResponse.<T>builder().code(1).msg(exception.getMessage()).build();
        }

        if (exception instanceof BindingResultException) {
            response = BaseResponse.<T>builder().code(2).msg(exception.getMessage()).build();
        }

        log.error("Exception cause = {}", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
