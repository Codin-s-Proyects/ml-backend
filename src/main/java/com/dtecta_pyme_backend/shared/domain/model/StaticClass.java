package com.dtecta_pyme_backend.shared.domain.model;


import com.dtecta_pyme_backend.shared.domain.exceptions.BadRequestException;

public class StaticClass {
    public static final int PAGE_INDEX_OFFSET = 1;
    public static void validatePaginationValues(int page, int size) {
        if (page <= 0)
            throw new BadRequestException("The page number must be greater than zero");

        if (size <= 0)
            throw new BadRequestException("The size must be greater than 0");
    }
}
