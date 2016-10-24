package com.bpmw.persistence;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TASKS")
@NamedQueries(value = {

        @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),

        @NamedQuery(name = "Task.findTaskUser", query = "SELECT t FROM Task t WHERE t.taskGroup.id = :idGroup"),

        @NamedQuery(name = "Task.findTaskUserQuery", query = "SELECT t FROM Task t " +
                "WHERE t.taskGroup.id = :idGroup AND (t.dateIn > :dateStart AND t.dateIn < :dateEnd)"),

        @NamedQuery(name = "Task.findStatisticData", query = "SELECT t.dateComplet, COUNT(t.userComplet) FROM Task t " +
                "WHERE t.userComplet.login = :login AND t.dateComplet > :dateComplete " +
                "GROUP BY t.dateComplet ORDER BY t.dateComplet"),

        @NamedQuery(name = "Task.findCountTaskUser", query = "SELECT COUNT(t.userComplet) FROM Task t " +
                "WHERE t.userComplet.login = :login")
})
public class Task {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @NotNull(message = "Field can bot be empty. Enter a name for the problem.")
    @Size(min = 3, message = "Name task length can not be less than three characters.")
    private String name;

    @Column(name = "TEXT")
    @NotNull(message = "Field can bot be empty. Enter a description of the problem.")
    @Size(min = 3, message = "Text task length can not be less than three characters.")
    private String textTask;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private TaskGroup taskGroup;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_IN")
    private Date dateIn;

    @Column(name = "EMAIL")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COMPLETION")
    private Date dateComplet;

    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "USER_COMPLET")
    private User userComplet;

    public Task() {
    }

    public Task(String name, String textTask, TaskGroup taskGroup, Date dateIn) {
        this.name = name;
        this.textTask = textTask;
        this.taskGroup = taskGroup;
        this.dateIn = dateIn;
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

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getDateIn() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(dateIn);
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateComplet() {
        if (dateComplet != null){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}