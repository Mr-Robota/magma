package com.atom.magma.beans;

import com.atom.magma.business.auth.AuthBoundary;
import com.atom.magma.business.auth.entity.Groupe;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Named;


@Named
@SessionScoped
public class AuthBeans implements Serializable {
    
    @EJB
    AuthBoundary ab;

    private String utilisateur = "admin";
    private String password = "admin";
    private boolean garderSession;
    private String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean verifierAutorisation(String nomModule,String action)
    { 
        return ab.verifierAutorisation(nomModule,action);
    }

    public boolean isGarderSession() {
        return garderSession;
    }

    public void setGarderSession(boolean garderSession) {
        this.garderSession = garderSession;
    }
    
    

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    
    
    public AuthBeans() {
    }
    
    public String validerConnexion(){
       
        if( ab.validerConnexion(this.getUtilisateur(),this.getPassword()) )
        {
           this.setMessage("");
           return "/vues/dashboard/tableauDeBord.xhtml";         
        }
        
        this.setMessage("Utilisateur introuvable");
        return "welcome.xhtml";
    
    }
    
    
    /* Récupération des groupes */
    public List<Groupe> getGroupes(){
        return ab.getGroupes();
    }
    
    /* Récupération du slug */
    public int getSlug(){
        
        Groupe gr = (Groupe)ab.getGroupes().get(0);
        return gr.getSlug();
    }
    
}
