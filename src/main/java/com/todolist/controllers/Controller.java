package com.todolist.controllers;

import com.todolist.TodolistApplication;
import com.todolist.model.Task;
import com.todolist.services.TaskService;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller extends SpringBootServletInitializer
{
	private final TaskService taskService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(TodolistApplication.class);
	}

	public Controller(TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/")
	public String index(Model model)
	{
		ArrayList<Task> tasks = new ArrayList<>(taskService.findAllTasks());
		model.addAttribute("tasks", tasks);
		model.addAttribute("tasksCount", tasks.size());
		return "index";
	}

}
