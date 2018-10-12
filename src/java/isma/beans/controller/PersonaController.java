/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isma.beans.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import isma.beans.BeanPersona;
import isma.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Isma
 */
public class PersonaController extends ActionSupport {

    private Persona person = new Persona();
    private List<Persona> listPerson = new ArrayList<>();
    private BeanPersona beanPersona = new BeanPersona();
    
    @Override
    public String execute() throws Exception {
        // System.out.println("nombre "+person.getName());
        // System.out.println("nombre "+person.getLname());
        if (person != null) {
            beanPersona.addPersona(person);

            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }

    public String listPersonas() {
        listPerson = beanPersona.getPersona();
        if (listPerson.size() > 0) {
            return "SUCCESS";
        }else        
        return "ERROR";
    }

    public String editPersona() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

       person.setIdPersona(Integer.parseInt(request.getParameter("idPersona")));
        

        return "SUCCESS";
    }

    public String deletePersona() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
       int id = Integer.parseInt(request.getParameter("idPersona"));
       person.setIdPersona(id);
       beanPersona.deletePersona(person);
        return "SUCCESS";
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public List<Persona> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<Persona> listPerson) {
        this.listPerson = listPerson;
    }

}
