package com.labdesoft.roteiro01.repository;

import com.labdesoft.roteiro01.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Método para salvar uma tarefa
    @SuppressWarnings("null")
    @Override
    <S extends Task> S save(S entity);

    // Método para encontrar uma tarefa por ID
    @SuppressWarnings("null")
    @Override
    Optional<Task> findById(Long id);

    // Método para encontrar todas as tarefas
    @SuppressWarnings("null")
    @Override
    List<Task> findAll();

    // Método para contar todas as tarefas
    @Override
    long count();

    // Método para excluir uma tarefa
    @Override
    void delete(@SuppressWarnings("null") Task entity);

    // Método para excluir uma tarefa por ID
    @Override
    void deleteById(@SuppressWarnings("null") Long id);
}
