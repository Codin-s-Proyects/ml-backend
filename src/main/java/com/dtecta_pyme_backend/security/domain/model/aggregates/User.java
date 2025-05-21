package com.dtecta_pyme_backend.security.domain.model.aggregates;

import com.dtecta_pyme_backend.security.domain.model.entities.Role;
import com.dtecta_pyme_backend.security.interfaces.rest.resources.SignUpResource;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;


@Entity
@Table(name = "\"users\"")
@Getter
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "lastname", nullable = false, length = 40)
    private String lastName;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    @Column(name = "phone_number", nullable = false, length = 40)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    public User() {
    }

    public User(Long id, String username, String name, String lastName, LocalDate birthdate, String email, String phoneNumber, String password, Role role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User(SignUpResource command, Role role, String password) {
        this.username = command.username();
        this.name = command.name();
        this.lastName = command.lastName();
        this.birthdate = command.birthdate();
        this.email = command.email();
        this.phoneNumber = command.phoneNumber();
        this.password = password;
        this.role = role;
    }

    public User updatePassword(String password) {
        this.password = password;
        return this;
    }

}