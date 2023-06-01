package com.todolist.controllers;

import com.todolist.model.Task;
import com.todolist.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController
{
    private final TaskService taskService;

    public ApiController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/tasks/")
    public ResponseEntity<Integer> addTask(@RequestBody Task task)
    {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id)
    {
        return ResponseEntity.ok(taskService.getTaskByID(id));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> removeTask(Task task){
        return ResponseEntity.ok(taskService.deleteTask(task));
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity<?> deleteAllTasks(){
        return ResponseEntity.ok(taskService.deleteAllTasks());
    }

}
