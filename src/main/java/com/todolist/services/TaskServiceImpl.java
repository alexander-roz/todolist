package com.todolist.services;

import com.todolist.dto.RequestTask;
import com.todolist.model.Task;
import com.todolist.model.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Integer addTask(Task task) {
        taskRepository.save(task);
        return task.getId();
    }

    @Override
    public RequestTask deleteTask(Task task) {
        if(taskRepository.existsById(task.getId())){
            taskRepository.delete(task);
            return new RequestTask(true);
        }
        else {
            return new RequestTask(false, "Task was not found");
        }
    }

    @Override
    public RequestTask deleteAllTasks() {
        taskRepository.deleteAll();
        if(taskRepository.findAll().size() == 0){
            return new RequestTask(true);
        }
        else{
            return new RequestTask(false, "tasks were not deleted");
        }
    }

    @Override
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskByID(int id){
        return taskRepository.findTasksById(id);
    }

}
