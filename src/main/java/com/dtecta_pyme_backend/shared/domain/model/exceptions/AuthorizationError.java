package com.dtecta_pyme_backend.shared.domain.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizationError extends ApiError {
    private String requiredRole;

    public AuthorizationError(int httpStatus, String message, String requiredRole) {
        super(httpStatus, message);
        this.requiredRole = requiredRole;
    }
}

