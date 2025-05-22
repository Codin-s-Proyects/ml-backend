package com.dtecta_pyme_backend.interfaces.rest.resources.history;

import java.time.LocalDate;

public record HistoryResource(Long id, String name, String report, LocalDate date) {
}
