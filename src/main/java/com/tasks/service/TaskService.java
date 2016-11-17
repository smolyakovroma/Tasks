package com.tasks.service;

import com.tasks.dao.TaskRepository;
import com.tasks.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskService {


    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        List<Task> tasks = new ArrayList<>();

        for (Task task : taskRepository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public void delete(long id){
        taskRepository.delete(id);
    }

    public Task findTask(long id){
        return taskRepository.findOne(id);
    }
}
