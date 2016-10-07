package com.bpmw.persistence;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    private TaskGroup taskGroup;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_IN")
    private Date dateIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COMPLETION")
    private Date dateComplet;

    @ManyToOne
    @JoinColumn(name = "USER_COMPLET")
    private User userComplet;

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

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getDateIn() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(dateIn);
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateComplet() {
        if (dateComplet != null){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(dateComplet);
        }else return " ";
    }

    public void setDateComplet(Date dateComplet) {
        this.dateComplet = dateComplet;
    }

    public User getUserComplet() {
        return userComplet;
    }

    public void setUserComplet(User userComplet) {
        this.userComplet = userComplet;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
