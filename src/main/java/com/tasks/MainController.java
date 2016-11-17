package com.tasks;

import com.tasks.models.Task;
import com.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping(value = "/all")
    public String allTasks(HttpServletRequest request){
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new")
    public String newTask(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }
    @PostMapping(value="/save")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
        task.setDateCreated(new Date());
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/update")
    public String updateTask(@RequestParam long id, HttpServletRequest request){
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam long id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }
}
