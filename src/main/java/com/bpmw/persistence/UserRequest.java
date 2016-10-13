package com.bpmw.persistence;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "requests")
public class UserRequest {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_START")
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_END")
    private Date dateEnd;

    @Column(name = "STATUS_COMPLETE")
    private String statusComplete;

    public UserRequest(Date dateStart, Date dateEnd, String statusComplete) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.statusComplete = statusComplete;
    }

    public UserRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatusComplete() {
        return statusComplete;
    }

    public void setStatusComplete(String statusComplete) {
        this.statusComplete = statusComplete;
    }
}