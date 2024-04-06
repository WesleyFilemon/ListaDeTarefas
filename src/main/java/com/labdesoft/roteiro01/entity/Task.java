package com.labdesoft.roteiro01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import java.time.LocalDate; // Importe a classe LocalDate se ainda não estiver importada

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(name = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    private String description;

    private Boolean completed;

    // Adicione um atributo de data
    private LocalDate date;

    // Construtor vazio
    public Task() {}

    // Construtor com descrição, status de conclusão e data
    public Task(String description, Boolean completed, LocalDate date) {
        this.description = description;
        this.completed = completed;
        this.date = date;
    }

    // Método getter para a data
    public LocalDate getDate() {
        return date;
    }

    // Método setter para a data
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", completed=" + completed + "]";
    }
}
