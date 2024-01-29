package com.tasks.taskapi.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tasks.taskapi.model.Task;
import com.tasks.taskapi.utils.TaskRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    private String SELECT_ALL_SQL = "SELECT * FROM Tasks";
    private String INSERT_SQL = "INSERT INTO Tasks (Name, Priority, State) Values ('%s', '%s', '%s');";
    private String INSERT_TASK_SQL = "INSERT INTO Tasks (Name, Priority, State) Values (?,?,?);";


    public int insertTask(Task task) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
            .prepareStatement(INSERT_TASK_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, task.getName());
            ps.setString(2, task.getPriority().name());
            ps.setString(3, task.getState().name());
            return ps;
        }, keyHolder);

        return (int) keyHolder.getKey();
    
    }

    public List<Task> getAllTasks() {
        
        return jdbcTemplate.query(SELECT_ALL_SQL, new TaskRowMapper()); 
   }

    public Task insertTask2(Task task) {
        String FORMATTED_EDIT_SQL = String.format(INSERT_SQL, task.getName(), task.getPriority().name(), task.getState().name());
        System.out.println(FORMATTED_EDIT_SQL);
        jdbcTemplate.execute(FORMATTED_EDIT_SQL);
        return task;
    }




}
