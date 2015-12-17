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

/**
 *
 * @author buddhika
 */
@Entity
public class Increment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    Person person;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date increment_date;
    String salary_scale;
    String salary_category;
    double current_salary;
    double increment_value;
    double salary_after_increment;
    double last_increment_value;
    
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getIncrement_date() {
        return increment_date;
    }

    public void setIncrement_date(Date increment_date) {
        this.increment_date = increment_date;
    }

    public String getSalary_scale() {
        return salary_scale;
    }

    public void setSalary_scale(String salary_scale) {
        this.salary_scale = salary_scale;
    }

    public String getSalary_category() {
        return salary_category;
    }

    public void setSalary_category(String salary_category) {
        this.salary_category = salary_category;
    }

    public double getCurrent_salary() {
        return current_salary;
    }

    public void setCurrent_salary(double current_salary) {
        this.current_salary = current_salary;
    }

    public double getIncrement_value() {
        return increment_value;
    }

    public void setIncrement_value(double increment_value) {
        this.increment_value = increment_value;
    }

    public double getSalary_after_increment() {
        return salary_after_increment;
    }

    public void setSalary_after_increment(double salary_after_increment) {
        this.salary_after_increment = salary_after_increment;
    }

    public double getLast_increment_value() {
        return last_increment_value;
    }

    public void setLast_increment_value(double last_increment_value) {
        this.last_increment_value = last_increment_value;
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
        if (!(object instanceof Increment)) {
            return false;
        }
        Increment other = (Increment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.hr.entity.Increment[ id=" + id + " ]";
    }
    
}
