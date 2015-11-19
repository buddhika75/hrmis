package lk.gov.health.hr.controllers;

import lk.gov.health.hr.entity.PersonLeave;
import lk.gov.health.hr.controllers.util.JsfUtil;
import lk.gov.health.hr.controllers.util.JsfUtil.PersistAction;
import lk.gov.health.hr.facelets.PersonLeaveFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import lk.gov.health.hr.entity.Institution;
import lk.gov.health.hr.entity.Person;
import lk.gov.health.hr.java.Functions;

@ManagedBean(name = "personLeaveController")
@SessionScoped
public class PersonLeaveController implements Serializable {

    @EJB
    private lk.gov.health.hr.facelets.PersonLeaveFacade ejbFacade;
    private List<PersonLeave> items = null;
    private PersonLeave selected;

    Person person;
    Institution institution;
    Date fromDate;
    Date toDate;

    public void listPersonLeaves() {
        String j;
        j = "select pl "
                + " from PersonLeave pl "
                + " where pl.retired=false "
                + " and pl.person=:p "
                + " and ((pl.fromDate < :fd and pl.toDate > :fd) or (pl.fromDate < :fd and pl.toDate > :td)) "
                + " order by pl.fromDate";
        Map m = new HashMap();
        m.put("p", person);
        m.put("fd", fromDate);
        m.put("td", toDate);
        items = ejbFacade.findBySQL(j, m);
    }

    public Date getFromDate() {
        if (fromDate == null) {
            fromDate = Functions.firstDateOfYear();
        }
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        if (toDate == null) {
            toDate = Functions.lastDateOfYear();
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public PersonLeaveController() {
    }

    public PersonLeave getSelected() {
        return selected;
    }

    public void setSelected(PersonLeave selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PersonLeaveFacade getFacade() {
        return ejbFacade;
    }

    public PersonLeave prepareCreate() {
        selected = new PersonLeave();
        selected.setPerson(person);
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PersonLeaveCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PersonLeaveUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PersonLeaveDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PersonLeave> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<PersonLeave> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PersonLeave> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @FacesConverter(forClass = PersonLeave.class)
    public static class PersonLeaveControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonLeaveController controller = (PersonLeaveController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personLeaveController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PersonLeave) {
                PersonLeave o = (PersonLeave) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PersonLeave.class.getName()});
                return null;
            }
        }

    }

}
