package com.bpmw.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {

    @Id
    @Column(name = "USERID")
    @NotNull(message = "Field can bot be empty. Enter your login.")
    @Size(min = 3, max = 40, message = "Login length can not be less than three characters.")
    private String login;

    @Column(name = "PASSWORD")
    @NotNull(message = "Field can bot be empty. Enter password.")
    @Size(min = 3, message = "The length of the password can not be less than three characters.")
    private String password;

    @Column(name = "FIRST_NAME")
    @NotNull(message = "Field can bot be empty. Enter your first name.")
    @Size(min = 2, max = 45, message = "The length of the first name can not be less than two characters.")
    private String firstName;

    @Column(name = "LAST_NAME")
    @Size(min = 2, max = 45, message = "The length of the last name can not be less than two characters.")
    @NotNull(message = "Field can bot be empty. Enter your last name.")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Field can bot be empty. Enter your date of birth.")
    @Past(message = "Not true the said date of birth.")
    @Column(name = "DATE_BIRTH")
    private Date dateBirth;

    @Column(name = "CITY")
    @Size(min = 2, max = 45, message = "The length of the name city can not be less than two characters.")
    @NotNull(message = "Field can bot be empty. Enter your city.")
    private String city;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private TaskGroup taskGroup;

    @Size(max = 11, message = "Invalid phone number format")
    @Column (name = "PHONE")
    private String phone;

    @Column (name = "MAIL")
    @NotNull(message = "Field can bot be empty. Enter your email.")
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$",
            message = "Invalid email format")
    private String mail;

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, Date dateBirth, String city, TaskGroup taskGroup, String phone, String mail) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.city = city;
        this.taskGroup = taskGroup;
        this.phone = phone;
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}