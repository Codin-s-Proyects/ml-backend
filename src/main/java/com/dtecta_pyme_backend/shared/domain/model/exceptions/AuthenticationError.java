package com.dtecta_pyme_backend.shared.domain.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationError extends ApiError {

    public AuthenticationError(int httpStatus, String message) {
        super(httpStatus, message);
    }
}


