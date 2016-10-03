package com.bpmw.persistence;

import javax.persistence.*;


@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP", referencedColumnName = "ID")
    private Group group;

    public User() {
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


    public void setGroup(Group group) {
        this.group = group;
    }
}
