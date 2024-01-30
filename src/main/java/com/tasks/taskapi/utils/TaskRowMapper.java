package com.tasks.taskapi.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.tasks.taskapi.model.Priority;
import com.tasks.taskapi.model.State;
import com.tasks.taskapi.model.Task;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int RowNum) throws SQLException {
        return Task.builder()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .priority(Priority.valueOf(rs.getString(3)))
                .state(State.valueOf(rs.getString(4)))
                .build();
    }
}
