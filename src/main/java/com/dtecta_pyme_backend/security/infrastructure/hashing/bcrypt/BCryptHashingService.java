package com.dtecta_pyme_backend.security.infrastructure.hashing.bcrypt;

import com.dtecta_pyme_backend.security.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
