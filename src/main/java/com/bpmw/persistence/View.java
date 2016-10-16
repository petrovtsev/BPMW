package com.bpmw.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "views")
@NamedQuery(name = "View.findAll", query = "select v from View v")
public class View {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @NotNull(message = "Field can bot be empty. Enter the name of the view")
    @Size(min = 3, message = "Name view length can not be less than three characters.")
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @OneToOne
    @JoinColumn(name = "ID_REQUEST")
    private UserRequest userRequest;

    public View(String name, User user, UserRequest userRequest) {
        this.name = name;
        this.user = user;
        this.userRequest = userRequest;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }
}
