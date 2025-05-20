package com.dtecta_pyme_backend.security.interfaces.rest.resources;

import java.time.LocalDate;

public record SignUpResource(String username, String name, String lastName, LocalDate birthdate, String email, String phoneNumber, String password, String role) {
}
