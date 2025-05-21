package com.dtecta_pyme_backend.security.domain.services;

import com.dtecta_pyme_backend.security.domain.model.aggregates.User;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.RecoverPasswordResource;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.SignInResource;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.SignUpResource;

import java.util.Optional;

public interface UserService {
    Optional<User> signIn(SignInResource resource);
    Optional<User> signUp(SignUpResource resource);
    Optional<User> recoverPassword(RecoverPasswordResource email);
}
