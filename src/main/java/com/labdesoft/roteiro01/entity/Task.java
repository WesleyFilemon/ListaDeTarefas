package com.labdesoft.roteiro01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = Task.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 255, nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String description;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "prazo", nullable = false)
    private int prazo;

    @Column(name = "livre", nullable = false)
    private Boolean livre;

    @Column(name = "nivel", length = 255, nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String nivel;
}
