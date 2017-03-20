package eja.hellojsf.backing;

import eja.hellojsf.data.Facade;
import eja.hellojsf.model.Customer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
public class Index {

    @Inject
    Facade facade;

    private String name;

    @PostConstruct
    void init() {
        name = null;
    }

    public List<Customer> getAll() {
        return facade.all();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String addCustomer() {
        if (name.length() >= 3) {
            facade.addCustomer(new Customer(name));
            return "index?faces-redirect";
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(name, new FacesMessage("name", "Too short"));
        return "index";
    }

}
