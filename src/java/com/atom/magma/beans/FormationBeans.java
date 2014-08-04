package com.atom.magma.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class FormationBeans {
    
   private String motCleFormation; 
    
    
   public String chercherFormation(){
       
       return "vues/formation/rechercheFormation.xhtml";
       
   }

    public String getMotCleFormation() {
        return motCleFormation;
    }

    public void setMotCleFormation(String motCleFormation) {
        this.motCleFormation = motCleFormation;
    }
   
   
    
    
    
    
}
