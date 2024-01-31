package com.tasks.taskapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/insert")
    public ResponseEntity<Task> insertTask(Task task) {
        Task insertedTask = taskService.insertTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(insertedTask);
    }

    @PutMapping("/edit")
    public ResponseEntity<Task> editTask(Task task) {
        taskService.editTask(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Task> deleteTask(Task task) {
        taskService.deleteTask(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
