package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "views")
@NamedQuery(name = "View.findAll", query = "select v from View v")
public class View {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "request")
    private String request;

    public View(Integer id, String name, String request) {
        this.id = id;
        this.name = name;
        this.request = request;
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
}
