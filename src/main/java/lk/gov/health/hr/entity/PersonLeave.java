/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.hr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lk.gov.health.hr.enums.LeaveType;
import lk.gov.health.hr.java.Functions;

/**
 *
 * @author buddhika
 */
@Entity
public class PersonLeave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    Person person;
    LeaveType type;
    boolean foreign_leave;
    double remaining_leaves;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fromDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date toDate;
    double leaveQuentity;

    //Create
    @ManyToOne
    WebUser creater;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date createdAt;
    //Retire
    boolean retired;
    @ManyToOne
    WebUser retirer;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date retiredAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        if (fromDate == null) {
            fromDate = new Date();
        }
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        if (toDate == null) {
            toDate = new Date();
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getLeaveQuentity() {
        if (leaveQuentity == 0) {
            leaveQuentity = 1;
        }
        return leaveQuentity;
    }

    public void setLeaveQuentity(double leaveQuentity) {
        this.leaveQuentity = leaveQuentity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LeaveType getType() {
        return type;
    }

    public void setType(LeaveType type) {
        this.type = type;
    }

    public boolean isForeign_leave() {
        return foreign_leave;
    }

    public void setForeign_leave(boolean foreign_leave) {
        this.foreign_leave = foreign_leave;
    }

    public double getRemaining_leaves() {
        return remaining_leaves;
    }

    public void setRemaining_leaves(double remaining_leaves) {
        this.remaining_leaves = remaining_leaves;
    }

    public WebUser getCreater() {
        return creater;
    }

    public void setCreater(WebUser creater) {
        this.creater = creater;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public WebUser getRetirer() {
        return retirer;
    }

    public void setRetirer(WebUser retirer) {
        this.retirer = retirer;
    }

    public Date getRetiredAt() {
        return retiredAt;
    }

    public void setRetiredAt(Date retiredAt) {
        this.retiredAt = retiredAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonLeave)) {
            return false;
        }
        PersonLeave other = (PersonLeave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.hr.entity.Leave[ id=" + id + " ]";
    }

}
