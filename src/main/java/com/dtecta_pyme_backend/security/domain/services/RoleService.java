package com.dtecta_pyme_backend.security.domain.services;

import com.dtecta_pyme_backend.security.domain.model.entities.Role;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.CreateRoleResource;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleByName(String name);
    void seed();
    Role create(CreateRoleResource resource);
}
