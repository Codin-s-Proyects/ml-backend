package com.dtecta_pyme_backend.domain.model.entities;

import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "accountants")
public class Accountant {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;


    public Accountant() {}

    public Accountant(CreateAccountantResource resource) {
        this.dni = resource.dni();
    }

    public Accountant updateAccountant(UpdateAccountantResource resource) {
        this.dni = resource.dni();

        return this;

    }
}
