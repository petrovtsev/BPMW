package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "groups")
@NamedQuery(name = "Group.findAll", query = "select g from Group g")
public class Group {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {
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
