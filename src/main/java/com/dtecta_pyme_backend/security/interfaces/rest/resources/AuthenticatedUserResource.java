package com.dtecta_pyme_backend.security.interfaces.rest.resources;

import java.util.UUID;

public record AuthenticatedUserResource(Long userId, String accessToken) {
}
