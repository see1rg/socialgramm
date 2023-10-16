package com.see1rg.socialgramm.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseErrorValidation {

    public ResponseEntity<Object> appValidationService(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();

            if (!CollectionUtils.isEmpty(bindingResult.getAllErrors())) {
                for (ObjectError error : bindingResult.getAllErrors()) {
                    errorsMap.put(error.getCode(), error.getDefaultMessage());
                }
            }

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}

