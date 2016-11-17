package com.tasks;

import com.tasks.dao.TaskRepository;
import com.tasks.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TasksApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		taskRepository.save(new Task("Task1","Description about task 1", new Date(), false));
		taskRepository.save(new Task("Task2","Description about task 2", new Date(), false));
		taskRepository.save(new Task("Task3","Description about task 3", new Date(), false));
	}
}
