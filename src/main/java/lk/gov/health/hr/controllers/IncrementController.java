package lk.gov.health.hr.controllers;

import lk.gov.health.hr.entity.Increment;
import lk.gov.health.hr.controllers.util.JsfUtil;
import lk.gov.health.hr.controllers.util.JsfUtil.PersistAction;
import lk.gov.health.hr.facelets.IncrementFacade;

import java.io.Serializable;
import java.util.Calendar;
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

@ManagedBean(name = "incrementController")
@SessionScoped
public class IncrementController implements Serializable {

    @EJB
    private lk.gov.health.hr.facelets.IncrementFacade ejbFacade;
    private List<Increment> items = null;
    private List<Increment> selectedersonIncrements = null;
    private Increment selected;

    public IncrementController() {
    }

    public void selectedPersonChanged() {
        fillSelectedPersonIncrements();
        updateSelectedDetails();
    }

    public void updateSelectedDetails() {
        if (selected == null) {
            return;
        } else {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, selected.getPerson().getMonth_of_increment());
            c.set(Calendar.DATE, selected.getPerson().getDate_of_increment());
            selected.setSalary_category(selected.getPerson().getSalary_category());
            selected.setIncrement_date(c.getTime());
        }
        if (selectedersonIncrements == null || selectedersonIncrements.isEmpty()) {
            return;
        }
        Increment lastIncrement = selectedersonIncrements.get(0);

        selected.setLast_increment_value(lastIncrement.getIncrement_value());
        selected.setCurrent_salary(lastIncrement.getSalary_after_increment());
        selected.setIncrement_value(lastIncrement.getIncrement_value());
        selected.setSalary_after_increment(selected.getCurrent_salary() + selected.getIncrement_value());

        selected.setSalary_scale(lastIncrement.getSalary_scale());

    }

    public void fillSelectedPersonIncrements() {
        String j;
        Map m = new HashMap();
        j = "select i "
                + " from Increment i"
                + " where i.retired=false "
                + " and i.person=:pe "
                + " order by i.id desc";
        m.put("pe", selected.getPerson());
        selectedersonIncrements = ejbFacade.findBySQL(j, m);
    }

    public List<Increment> getSelectedersonIncrements() {
        return selectedersonIncrements;
    }

    public void setSelectedersonIncrements(List<Increment> selectedersonIncrements) {
        this.selectedersonIncrements = selectedersonIncrements;
    }

    public IncrementFacade getEjbFacade() {
        return ejbFacade;
    }

    public Increment getSelected() {
        return selected;
    }

    public void setSelected(Increment selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private IncrementFacade getFacade() {
        return ejbFacade;
    }

    public Increment prepareCreate() {
        selected = new Increment();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleIncrement").getString("IncrementCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleIncrement").getString("IncrementUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleIncrement").getString("IncrementDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Increment> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleIncrement").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleIncrement").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Increment> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Increment> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Increment.class)
    public static class IncrementControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IncrementController controller = (IncrementController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "incrementController");
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
            if (object instanceof Increment) {
                Increment o = (Increment) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Increment.class.getName()});
                return null;
            }
        }

    }

}
