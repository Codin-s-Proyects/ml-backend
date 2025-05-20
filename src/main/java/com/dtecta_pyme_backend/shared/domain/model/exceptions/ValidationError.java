package com.dtecta_pyme_backend.shared.domain.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError extends ApiError {

    private String resource;

    public ValidationError(int httpStatus, String message) {
        super(httpStatus, message);
    }
}

