package com.dtecta_pyme_backend.security.domain.model.entities;

import com.dtecta_pyme_backend.security.interfaces.rest.resources.CreateRoleResource;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "roles")
@Getter
public class Role {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    public Role(){
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(CreateRoleResource resource) {
        name=resource.name();
    }

}
