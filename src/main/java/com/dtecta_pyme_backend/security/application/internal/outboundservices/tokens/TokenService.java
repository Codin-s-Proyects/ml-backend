package com.dtecta_pyme_backend.security.application.internal.outboundservices.tokens;

public interface TokenService {
    String generateToken(String username);
    String generateRefreshToken(String username);

    String getUsernameFromToken(String token);

    boolean validateToken(String token);
}
