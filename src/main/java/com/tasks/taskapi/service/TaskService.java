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

    public Task getTaskById(int id) {
        return taskRepository.selectTaskById(id);
    }

    public Task insertTask(Task task) {   
        task.setId(taskRepository.insertTask(task));
        return task; 
    }

    public void editTask(Task task) {
        taskRepository.editTask(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

}
