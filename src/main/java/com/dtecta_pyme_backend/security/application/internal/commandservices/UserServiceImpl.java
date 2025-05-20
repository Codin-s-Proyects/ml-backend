package com.dtecta_pyme_backend.security.application.internal.commandservices;

import com.dtecta_pyme_backend.security.application.internal.outboundservices.hashing.HashingService;
import com.dtecta_pyme_backend.security.domain.model.aggregates.User;
import com.dtecta_pyme_backend.security.domain.services.UserService;
import com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories.UserRepository;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.SignInResource;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.SignUpResource;
import com.dtecta_pyme_backend.shared.domain.exceptions.AuthenticatedException;
import com.dtecta_pyme_backend.shared.domain.exceptions.BadRequestException;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import com.dtecta_pyme_backend.shared.domain.exceptions.ServerErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, HashingService hashingService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
    }


    @Override
    public Optional<User> signIn(SignInResource resource) {
        var user = userRepository.findByUsername(resource.username());

        if (user == null)
            throw new NotFoundException("Not found user with that username");


        if (!hashingService.matches(resource.password(), user.getPassword()))
            throw new AuthenticatedException("Passwords do not match");

        return Optional.of(user);
    }

    @Override
    public Optional<User> signUp(SignUpResource resource) {
        if (userRepository.existsByEmail(resource.email()))
            throw new BadRequestException("Already exist a user with this email");

        if (userRepository.existsByUsername(resource.username()))
            throw new BadRequestException("Already exist a user with this username");

        var role = roleRepository.findByName(resource.role())
                .orElseThrow(() -> new NotFoundException("Not found a role with this name"));

        try {
            var user = new User(resource, role, hashingService.encode(resource.password()));
            return Optional.of(userRepository.save(user));
        } catch (Exception e) {
            throw new ServerErrorException();
        }
    }
}
