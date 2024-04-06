package com.labdesoft.roteiro01.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @SuppressWarnings("null")
    @GetMapping("/past")
@Operation(summary = "Lista as tarefas passadas")
public ResponseEntity<List<Task>> getPastTasks() {
    try {
        List<Task> pastTasks = taskService.getAllTasks().stream()
                .filter(task -> task.getDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        if (pastTasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pastTasks, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@SuppressWarnings("null")
@GetMapping("/today")
@Operation(summary = "Lista as tarefas do dia")
public ResponseEntity<List<Task>> getTodayTasks() {
    try {
        List<Task> todayTasks = taskService.getAllTasks().stream()
                .filter(task -> task.getDate().isEqual(LocalDate.now()))
                .collect(Collectors.toList());

        if (todayTasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(todayTasks, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@SuppressWarnings("null")
@GetMapping("/future")
@Operation(summary = "Lista as tarefas futuras")
public ResponseEntity<List<Task>> getFutureTasks() {
    try {
        List<Task> futureTasks = taskService.getAllTasks().stream()
                .filter(task -> task.getDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());

        if (futureTasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(futureTasks, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    @DeleteMapping("/{id}")
@Operation(summary = "Exclui uma tarefa pelo ID")
public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
    try {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@SuppressWarnings("null")
@PostMapping
@Operation(summary = "Cria uma nova tarefa")
public ResponseEntity<Task> createTask(@RequestBody Task task) {
    try {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@SuppressWarnings("null")
@PutMapping("/{id}")
@Operation(summary = "Atualiza uma tarefa existente pelo ID")
public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
    try {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}
