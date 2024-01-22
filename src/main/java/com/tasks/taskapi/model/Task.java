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
    private Integer priority;

    @JsonProperty("inprogress")
    @NonNull
    private Boolean inprogress;

    @JsonProperty("incomplete")
    @NonNull
    private Boolean incomplete;



}
