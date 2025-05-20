package com.dtecta_pyme_backend.security.infrastructure.authorization.sfs.services;

import com.dtecta_pyme_backend.security.infrastructure.authorization.sfs.model.UserDetailsImpl;
import com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories.UserRepository;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "defaultUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundException("Not found: " + username);
        }

        return UserDetailsImpl.build(user);
    }

}
