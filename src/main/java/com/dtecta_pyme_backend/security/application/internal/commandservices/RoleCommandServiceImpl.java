package com.dtecta_pyme_backend.security.application.internal.commandservices;

import com.dtecta_pyme_backend.security.domain.model.entities.Role;
import com.dtecta_pyme_backend.security.domain.services.RoleService;
import com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.CreateRoleResource;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import com.dtecta_pyme_backend.shared.domain.exceptions.ServerErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class RoleCommandServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void seed() {
        var roles = Arrays.asList("ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_EMPLOYEE", "ROLE_CUSTOMER", "ROLE_GUEST");
        roles.forEach(rolName -> {
        if (roleRepository.existsByName(rolName))
            return;

        var role = new Role(rolName);
        roleRepository.save(role);
        });
    }

    @Override
    public Role create(CreateRoleResource resource) {
        if (roleRepository.existsByName(resource.name()))
            throw new NotFoundException("Not found role with name " + resource.name());

        try {
            var role = new Role(resource);
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new ServerErrorException();
        }
    }
}
