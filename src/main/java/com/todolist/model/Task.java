package com.todolist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@EqualsAndHashCode
@RedisHash("task")
public class Task {
    @Id
    private Integer id;

    private String taskName;
}