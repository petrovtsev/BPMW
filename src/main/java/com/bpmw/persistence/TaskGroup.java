package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "TASKS_GROUPS")
@NamedQuery(name = "Group.findAll", query = "select g from TaskGroup g")
public class TaskGroup {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public TaskGroup(String name) {
        this.name = name;
    }

    public TaskGroup() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
