package com.dtecta_pyme_backend.shared.domain.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundError extends ApiError {
    public NotFoundError(int httpStatus, String message) {
        super(httpStatus, message);
    }
}

