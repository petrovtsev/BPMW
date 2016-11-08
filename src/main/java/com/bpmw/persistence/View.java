package com.bpmw.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "views")
@NamedQuery(name = "View.findAll", query = "select v from View v")
public class View {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @NotNull(message = "Field can bot be empty. Enter the name of the view")
    @Size(min = 3, max = 30, message = "Name view length can not be less than three characters.")
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @Column(name = "DATE_START")
    @Temporal(TemporalType.DATE)
    @Past
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_END")
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "PRIORITY_TASK")
    private PriorityTask priorityTask;

    @ManyToOne
    @JoinColumn(name = "STATUS_TASK")
    private StatusTask statusTask;

    public View() {
    }

    public View(String name, User user, Date dateStart, Date dateEnd, PriorityTask priorityTask, StatusTask statusTask) {
        this.name = name;
        this.user = user;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.priorityTask = priorityTask;
        this.statusTask = statusTask;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public PriorityTask getPriorityTask() {
        return priorityTask;
    }

    public void setPriorityTask(PriorityTask priorityTask) {
        this.priorityTask = priorityTask;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }
}
