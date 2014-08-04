package com.atom.magma.business.utilisateurs;

import com.atom.magma.business.auth.entity.Groupe;
import com.atom.magma.business.auth.entity.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UtilisateursBoundary {
    
    
    @PersistenceContext(name = "magmaPU")
    EntityManager em;
    
    
    public void ajouterUtilisateur(String nom,String password,int groupe){
        
        Utilisateur u = new Utilisateur();   
        u.setUtilisateur(nom);
        u.setPassword(password);
        u.getGroupe().add( em.find(Groupe.class, (long)groupe));
        em.persist(u);
        
    }
    
    public List chargerGroupes(){
        
        em.flush();
        Query query = em.createQuery("select g from Groupe g");
        return query.getResultList();
        
    }
    
    public void supprimerUtilisateur(long idUtilisateur){
    
        Utilisateur u = em.find(Utilisateur.class, idUtilisateur);
        em.remove(u);
        em.flush();
    }
    
    public void modifierUtilisateur(){
        
    }
    
    public List afficherUtilisateurs(){
        
        em.flush();
        Query query = em.createQuery("select u from Utilisateur u");
        return query.getResultList();
        
        
    }
    
    
}
