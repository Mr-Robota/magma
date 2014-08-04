package com.atom.magma.business.auth;


import com.atom.magma.business.auth.entity.Groupe;
import com.atom.magma.business.auth.entity.Utilisateur;
import com.atom.magma.business.auth.entity.ModuleAuth;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class AuthBoundary {



    @PersistenceContext(name = "magmaPU")
    EntityManager em;
    
    private Utilisateur utilisateur;
  
    public AuthBoundary() {
    }
    
    /* Recherche du Client dans la base de données */
    public boolean validerConnexion(String user,String pass){
        
        em.flush();
        Query query = em.createQuery("select u from Utilisateur u WHERE u.utilisateur = :value And u.password = :pass");
        query.setParameter("value", user);
        query.setParameter("pass" , pass);
        
        try {          
           this.utilisateur = (Utilisateur)query.getSingleResult();
          
           return true;          
        } catch (Exception e) {    
            System.out.println("Aucun résultat dans la base de données");
            return false;    
        }        
    }
    
    
    /* Vérification des autorisations selon le groupe de l'utilisateur */
    public boolean verifierAutorisation(String nomRessource,String action)
    { 
        
        for(Groupe groupe:this.utilisateur.getGroupe())
        {
            for(ModuleAuth auth:groupe.getModuleAuth())
            {
                
                System.out.println("Nom ressource => "+auth.getNomRessource());
                System.out.println("Nom Action => "+auth.getNomAction());
                if ( auth.getNomAction().equalsIgnoreCase(action) && auth.getNomRessource().equalsIgnoreCase(nomRessource) )
                {
                      return true;      
                }
                //System.out.println( "Auth =>"+auth.getResourceName() );
            }
            
        }
        
        return false;
        
    }
    
    /* Récupérer le Groupe de l'utilisateur */ 
    public List getGroupes(){
        return this.utilisateur.getGroupe();
    }
    
    
}
