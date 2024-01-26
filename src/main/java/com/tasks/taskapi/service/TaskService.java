package com.tasks.taskapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tasks.taskapi.model.Task;
import com.tasks.taskapi.repository.TaskRepository;



@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() { return taskRepository.getAllTasks(); }
    
}
