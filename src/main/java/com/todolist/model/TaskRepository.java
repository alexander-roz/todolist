package com.todolist.model;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends KeyValueRepository<Task, Integer> {
    Task findTasksById(int id);
}