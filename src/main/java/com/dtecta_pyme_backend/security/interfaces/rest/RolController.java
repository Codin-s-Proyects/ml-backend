package com.dtecta_pyme_backend.security.interfaces.rest;

import com.dtecta_pyme_backend.security.domain.services.RoleService;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.CreateRoleResource;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.RoleResource;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/rol", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rol", description = "Rol Endpoints")
public class RolController {
    private final RoleService roleService;

    public RolController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<RoleResource> createRol(@RequestBody CreateRoleResource createRoleResource) {
        var role = roleService.create(createRoleResource);

        if (role == null) {
            throw new NotFoundException("Not found role");
        }
        var roleResource = new RoleResource(role.getId(), role.getName());
        return new ResponseEntity<>(roleResource, HttpStatus.CREATED);
    }
}
