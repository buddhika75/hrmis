/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.hr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lk.gov.health.hr.enums.CivilStatus;
import lk.gov.health.hr.enums.Gender;

/**
 *
 * @author buddhika
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String name;
    String given_names;
    String family_names;
    String nic;
    String name_With_initials;
    String permanent_address;
    String temporary_address;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_birth;
    @Enumerated(EnumType.STRING)
    CivilStatus civil_status;
    String telephone;
    String mobile;
    String fax;
    String email;

    @ManyToOne
    Item position;
    boolean super_grade;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_appointment_to_super_grade;
    boolean special_grade;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_appointment_to_special_grade;
    boolean grade_I;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_appointment_to_grade_I;
    boolean grade_II;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_appointment_to_grade_II;
    boolean grade_III;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_appointment_to_grade_III;
    @ManyToOne
    Institution institution;
    @ManyToOne
    Institution department;
    boolean permanent_appointment;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of__permanent_appointment;
    boolean temporary_appointment;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_temporary_appointment;
    boolean casual_appointment;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_casual_appointment;
    String wnop_number;
    boolean ebar_I_passed;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date ebar_I_passed_date;
    boolean ebar_II_passed;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date ebar_II_passed_date;
    boolean ebar_III_passed;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date ebar_III_passed_date;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_current_institution;
    @ManyToOne
    Institution previous_Institution;
    int month_of_increment;
    int date_of_increment;
    String salary_category;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_retire;
    boolean transferred;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date_of_trasnfer;
    @ManyToOne
    Institution transfer_institution;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName_With_initials() {
        return name_With_initials;
    }

    public void setName_With_initials(String name_With_initials) {
        this.name_With_initials = name_With_initials;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getTemporary_address() {
        return temporary_address;
    }

    public void setTemporary_address(String temporary_address) {
        this.temporary_address = temporary_address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public CivilStatus getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(CivilStatus civil_status) {
        this.civil_status = civil_status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Item getPosition() {
        return position;
    }

    public void setPosition(Item position) {
        this.position = position;
    }

    public boolean isSuper_grade() {
        return super_grade;
    }

    public void setSuper_grade(boolean super_grade) {
        this.super_grade = super_grade;
    }

    public Date getDate_of_appointment_to_super_grade() {
        return date_of_appointment_to_super_grade;
    }

    public void setDate_of_appointment_to_super_grade(Date date_of_appointment_to_super_grade) {
        this.date_of_appointment_to_super_grade = date_of_appointment_to_super_grade;
    }

    public boolean isSpecial_grade() {
        return special_grade;
    }

    public void setSpecial_grade(boolean special_grade) {
        this.special_grade = special_grade;
    }

    public Date getDate_of_appointment_to_special_grade() {
        return date_of_appointment_to_special_grade;
    }

    public void setDate_of_appointment_to_special_grade(Date date_of_appointment_to_special_grade) {
        this.date_of_appointment_to_special_grade = date_of_appointment_to_special_grade;
    }

    public boolean isGrade_I() {
        return grade_I;
    }

    public void setGrade_I(boolean grade_I) {
        this.grade_I = grade_I;
    }

    public Date getDate_of_appointment_to_grade_I() {
        return date_of_appointment_to_grade_I;
    }

    public void setDate_of_appointment_to_grade_I(Date date_of_appointment_to_grade_I) {
        this.date_of_appointment_to_grade_I = date_of_appointment_to_grade_I;
    }

    public boolean isGrade_II() {
        return grade_II;
    }

    public void setGrade_II(boolean grade_II) {
        this.grade_II = grade_II;
    }

    public Date getDate_of_appointment_to_grade_II() {
        return date_of_appointment_to_grade_II;
    }

    public void setDate_of_appointment_to_grade_II(Date date_of_appointment_to_grade_II) {
        this.date_of_appointment_to_grade_II = date_of_appointment_to_grade_II;
    }

    public boolean isGrade_III() {
        return grade_III;
    }

    public void setGrade_III(boolean grade_III) {
        this.grade_III = grade_III;
    }

    public Date getDate_of_appointment_to_grade_III() {
        return date_of_appointment_to_grade_III;
    }

    public void setDate_of_appointment_to_grade_III(Date date_of_appointment_to_grade_III) {
        this.date_of_appointment_to_grade_III = date_of_appointment_to_grade_III;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Institution getDepartment() {
        return department;
    }

    public void setDepartment(Institution department) {
        this.department = department;
    }

    public boolean isPermanent_appointment() {
        return permanent_appointment;
    }

    public void setPermanent_appointment(boolean permanent_appointment) {
        this.permanent_appointment = permanent_appointment;
    }

    public Date getDate_of__permanent_appointment() {
        return date_of__permanent_appointment;
    }

    public void setDate_of__permanent_appointment(Date date_of__permanent_appointment) {
        this.date_of__permanent_appointment = date_of__permanent_appointment;
    }

    public boolean isTemporary_appointment() {
        return temporary_appointment;
    }

    public void setTemporary_appointment(boolean temporary_appointment) {
        this.temporary_appointment = temporary_appointment;
    }

    public Date getDate_of_temporary_appointment() {
        return date_of_temporary_appointment;
    }

    public void setDate_of_temporary_appointment(Date date_of_temporary_appointment) {
        this.date_of_temporary_appointment = date_of_temporary_appointment;
    }

    public boolean isCasual_appointment() {
        return casual_appointment;
    }

    public void setCasual_appointment(boolean casual_appointment) {
        this.casual_appointment = casual_appointment;
    }

    public Date getDate_of_casual_appointment() {
        return date_of_casual_appointment;
    }

    public void setDate_of_casual_appointment(Date date_of_casual_appointment) {
        this.date_of_casual_appointment = date_of_casual_appointment;
    }

    public String getWnop_number() {
        return wnop_number;
    }

    public void setWnop_number(String wnop_number) {
        this.wnop_number = wnop_number;
    }

    public boolean isEbar_I_passed() {
        return ebar_I_passed;
    }

    public void setEbar_I_passed(boolean ebar_I_passed) {
        this.ebar_I_passed = ebar_I_passed;
    }

    public Date getEbar_I_passed_date() {
        return ebar_I_passed_date;
    }

    public void setEbar_I_passed_date(Date ebar_I_passed_date) {
        this.ebar_I_passed_date = ebar_I_passed_date;
    }

    public boolean isEbar_II_passed() {
        return ebar_II_passed;
    }

    public void setEbar_II_passed(boolean ebar_II_passed) {
        this.ebar_II_passed = ebar_II_passed;
    }

    public Date getEbar_II_passed_date() {
        return ebar_II_passed_date;
    }

    public void setEbar_II_passed_date(Date ebar_II_passed_date) {
        this.ebar_II_passed_date = ebar_II_passed_date;
    }

    public boolean isEbar_III_passed() {
        return ebar_III_passed;
    }

    public void setEbar_III_passed(boolean ebar_III_passed) {
        this.ebar_III_passed = ebar_III_passed;
    }

    public Date getEbar_III_passed_date() {
        return ebar_III_passed_date;
    }

    public void setEbar_III_passed_date(Date ebar_III_passed_date) {
        this.ebar_III_passed_date = ebar_III_passed_date;
    }

    public Date getDate_of_current_institution() {
        return date_of_current_institution;
    }

    public void setDate_of_current_institution(Date date_of_current_institution) {
        this.date_of_current_institution = date_of_current_institution;
    }

    public Institution getPrevious_Institution() {
        return previous_Institution;
    }

    public void setPrevious_Institution(Institution previous_Institution) {
        this.previous_Institution = previous_Institution;
    }

    public int getMonth_of_increment() {
        return month_of_increment;
    }

    public void setMonth_of_increment(int month_of_increment) {
        this.month_of_increment = month_of_increment;
    }

    public int getDate_of_increment() {
        return date_of_increment;
    }

    public void setDate_of_increment(int date_of_increment) {
        this.date_of_increment = date_of_increment;
    }

    public String getSalary_category() {
        return salary_category;
    }

    public void setSalary_category(String salary_category) {
        this.salary_category = salary_category;
    }

    public Date getDate_of_retire() {
        return date_of_retire;
    }

    public void setDate_of_retire(Date date_of_retire) {
        this.date_of_retire = date_of_retire;
    }

    public boolean isTransferred() {
        return transferred;
    }

    public void setTransferred(boolean transferred) {
        this.transferred = transferred;
    }

    public Date getDate_of_trasnfer() {
        return date_of_trasnfer;
    }

    public void setDate_of_trasnfer(Date date_of_trasnfer) {
        this.date_of_trasnfer = date_of_trasnfer;
    }

    public Institution getTransfer_institution() {
        return transfer_institution;
    }

    public void setTransfer_institution(Institution transfer_institution) {
        this.transfer_institution = transfer_institution;
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

    public String getGiven_names() {
        return given_names;
    }

    public void setGiven_names(String given_names) {
        this.given_names = given_names;
    }

    public String getFamily_names() {
        return family_names;
    }

    public void setFamily_names(String family_names) {
        this.family_names = family_names;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
