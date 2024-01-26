package com.tasks.taskapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.NonNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Task {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @NonNull
    private String name;

    @JsonProperty("priority")
    @NonNull
    private Priority priority;

    @JsonProperty("state")
    @NonNull
    private State state;


}
