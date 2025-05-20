package com.dtecta_pyme_backend.security.infrastructure.tokens.jwt;

import com.dtecta_pyme_backend.security.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {
    String getBearerTokenFrom(HttpServletRequest token);

    String generateToken(Authentication authentication);
}
