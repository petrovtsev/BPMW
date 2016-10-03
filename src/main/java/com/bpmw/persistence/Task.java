package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "TASKS")
@NamedQuery(name = "Task.findAll", query = "select t from Task t")
public class Task {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public Task() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
