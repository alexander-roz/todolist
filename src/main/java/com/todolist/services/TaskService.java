package com.todolist.services;

import com.todolist.dto.RequestTask;
import com.todolist.model.Task;

import java.util.List;

public interface TaskService {
    Integer addTask(Task task);
    RequestTask deleteTask(Task task);
    RequestTask deleteAllTasks();
    List<Task> findAllTasks();
    Task getTaskByID(int id);
}
