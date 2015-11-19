/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.hr.facelets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.hr.entity.PersonLeave;

/**
 *
 * @author buddhika
 */
@Stateless
public class PersonLeaveFacade extends AbstractFacade<PersonLeave> {
    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonLeaveFacade() {
        super(PersonLeave.class);
    }
    
    
}
