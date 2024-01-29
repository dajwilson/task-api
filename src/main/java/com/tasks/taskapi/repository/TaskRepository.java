package com.tasks.taskapi.repository;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tasks.taskapi.model.Task;
import com.tasks.taskapi.utils.TaskRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    private String SELECT_ALL_SQL = "SELECT * FROM Tasks";
    private String INSERT_SQL = "INSERT INTO Tasks (Name, Priority, State) Values (%s, %s, %s);";

    public List<Task> getAllTasks() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new TaskRowMapper()); 
   }

    public Task insertTask(Task task) {
        jdbcTemplate.execute(String.format(INSERT_SQL, task.getName(), task.getPriority().name(), task.getState().name()));
        return task;
    }




}
