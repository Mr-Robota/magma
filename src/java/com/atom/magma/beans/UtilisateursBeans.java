package com.atom.magma.beans;

import com.atom.magma.business.auth.entity.Groupe;
import com.atom.magma.business.auth.entity.Utilisateur;
import com.atom.magma.business.utilisateurs.UtilisateursBoundary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class UtilisateursBeans implements Serializable  {

    @EJB
    UtilisateursBoundary ub;
    
    private String nom;
    private String password;
    private int groupeId;

    public int getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(int groupeId) {
        this.groupeId = groupeId;
    }
    
    private ArrayList<Groupe> groupes;

    public ArrayList<Groupe> getGroupes() {
        return this.groupes;
    }

    public void setGroupes(ArrayList<Groupe> groupes) {
        this.groupes = groupes;
    }
    
    
    /* Methode pour la liste déroulante de l'ajout d'utilisateur */
    public List chargerGroupes(){
        return ub.chargerGroupes();      
    }
    
  
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String ajouterUtilisateur(){
        ub.ajouterUtilisateur(this.nom,this.password,this.groupeId);
        return "gestionUtilisateurs";
    }
    
  
 
    
    public void supprimerUtilisateur(long idUtilisateur)
    {
        ub.supprimerUtilisateur(idUtilisateur);
        System.out.println("Demande suppression =>" + idUtilisateur);
    }  
    
   public List afficherUtilisateur(){ 
       return ub.afficherUtilisateurs();
   }    
    
    
}
