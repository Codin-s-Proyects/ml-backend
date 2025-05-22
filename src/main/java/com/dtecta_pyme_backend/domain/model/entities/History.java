package com.dtecta_pyme_backend.domain.model.entities;

import com.dtecta_pyme_backend.interfaces.rest.resources.history.CreateHistoryResource;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "histories")
@Getter
public class History {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "report", nullable = false)
    private String report;

    @Getter
    @Column(name = "date", nullable = false, length = 8)
    private LocalDate date;

    public History() {}

    public History(CreateHistoryResource resource) {
        this.name = resource.name();
        this.report = resource.report();
        this.date = LocalDate.now();
    }


}
