package com.labdesoft.roteiro01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Todos os detalhes sobre uma tarefa.")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Schema(name = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    private String description;

    private Boolean completed;
    private LocalDate data; 
    private int prazo;
    private Boolean livre;
    private String nivel;

    public Task(LocalDate data, int prazo, Boolean livre, String nivel) {
        this.data = data;
        this.prazo = prazo;
        this.livre = livre;
        this.nivel = nivel;
    }

    public Task(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", completed=" + completed + ", Data=" + data +
                ", Prazo=" + prazo + " dias" + ", Livre=" + livre + "]";
    }

    public void setData(LocalDate data) {
        LocalDate dataAtual = LocalDate.now();


        if (data.isBefore(dataAtual) || data.isEqual(dataAtual)) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("A data prevista de execução deve ser igual ou anterior à data atual.");
        }
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getPrazo() {
        return this.prazo;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public Boolean getLivre() {
        return this.livre;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }

    private long atrasoOuConcluida(Task task) {
        LocalDate dataAtual = LocalDate.now();
        return ChronoUnit.DAYS.between(task.getData(), dataAtual);
    }

    public void print(Task task) {
        System.out.println("Task ID: " + task.getId());
        System.out.println("Descrição: " + task.getDescription());
        long dias = atrasoOuConcluida(task);
        System.out.println("Data prevista: " + task.getData() + ", Dias de atraso ou concluída: " + dias);
        System.out.println("Prazo previsto: " + task.getPrazo() + ", Dias de atraso ou concluída: " + (task.getPrazo() - dias));
    }
}
