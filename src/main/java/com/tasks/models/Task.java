package com.tasks.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private boolean finished;

    public Task(String name, String description, Date dateCreated, boolean finished) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.finished = finished;
    }


}
