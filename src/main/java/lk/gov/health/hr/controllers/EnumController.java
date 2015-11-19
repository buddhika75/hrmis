/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.hr.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import lk.gov.health.hr.enums.CivilStatus;
import lk.gov.health.hr.enums.Gender;

/**
 *
 * @author pdhs-sp
 */
@ManagedBean
@ApplicationScoped
public class EnumController {

    /**
     * Creates a new instance of EnumController
     */
    public EnumController() {
    }
    
    public Gender[] getGenders(){
        return Gender.values();
    }
    
    public CivilStatus[] getCivilStatuses(){
        return CivilStatus.values();
    }
    
}