/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isma.beans;

import isma.dao.DaoPersona;
import isma.model.Persona;
import java.util.List;

/**
 *
 * @author Isma
 */
public class BeanPersona extends DaoPersona{
    

    @Override
    public void addPersona(Persona persona) {
        super.addPersona(persona); 
    }
    
   public List<Persona> getPersona(){
    List<Persona> list = this.getPersonas();
    return list;
    }
    
   public void deletePersona(Persona persona){
       super.deletePersona(persona);
   }
   
}
