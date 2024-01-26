package com.tasks.taskapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tasks.taskapi.model.Task;
import com.tasks.taskapi.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Task>> getAllTasks() {
       List<Task> tasks =  taskService.getAllTasks();
       return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    

    
}
