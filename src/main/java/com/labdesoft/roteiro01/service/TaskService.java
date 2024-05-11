package com.labdesoft.roteiro01.service;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.repository.TaskRepository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    private final TaskRepository tasksRepository;

    public TaskService(TaskRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Page<Task> listAll(Pageable pageable) {
        return tasksRepository.findAll(pageable);
    }

    public Optional<Task> getTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    public Task createTask(Task task) {
        return tasksRepository.save(task);
    }

    public Task updateTask(Task task) {
        return tasksRepository.save(task);
    }

    public boolean deleteTask(Long id) {
        Optional<Task> existingTask = tasksRepository.findById(id);
        if (existingTask.isPresent()) {
            tasksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
