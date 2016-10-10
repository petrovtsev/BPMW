package com.bpmw.persistence;

import javax.persistence.*;

@Entity
@Table(name = "views")
@NamedQuery(name = "View.findAll", query = "select v from View v")
public class View {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REQUEST")
    private String request;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    public View(String name, String request, User user) {
        this.name = name;
        this.request = request;
        this.user = user;
    }

    public View() {
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
