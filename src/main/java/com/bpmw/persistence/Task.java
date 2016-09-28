package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "tasks")
@NamedQuery(name = "Task.findAll", query = "select t from Task t")
public class Task {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;


    public Task(Integer id, String name, String text, User user) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
