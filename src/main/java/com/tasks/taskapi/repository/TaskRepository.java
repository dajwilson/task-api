package com.tasks.taskapi.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.tree.RowMapper;

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
    private String INSERT_SQL = "INSERT INTO Tasks (Name, Priority, State) Values (?,?,?);";
    private String EDIT_SQL = "UPDATE Tasks SET Name = '%s', Priority = '%s', State = '%s' ";
    private String WHERE_SQL = "WHERE Id = '%d';";

    public List<Task> getAllTasks() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new TaskRowMapper()); 
   }

    public int insertTask(Task task) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                .prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, task.getName());
            ps.setString(2, task.getPriority().name());
            ps.setString(3, task.getState().name());
            return ps;
        }, keyHolder);

        return (int) keyHolder.getKey();
    }

    public void editTask(Task task) {
        String EDITED_EDIT_SQL = String.format(EDIT_SQL + WHERE_SQL, task.getName(), 
            task.getPriority().name(), task.getState().name(), task.getId() );
        jdbcTemplate.update(EDITED_EDIT_SQL);
    }
}