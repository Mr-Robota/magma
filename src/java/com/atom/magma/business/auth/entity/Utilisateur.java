package com.atom.magma.business.auth.entity;

import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "utilisateur")
    private String utilisateur;
    
    @Column(name = "password")
    private String password;
    
    @ManyToMany(mappedBy = "client")
    private List<Groupe> groupe;
    
    public Utilisateur() {
        
       this.groupe = new ArrayList<>();
    }

    public List<Groupe> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<Groupe> groupe) {
        this.groupe = groupe;
    }
    
    

    public Utilisateur(String utilisateur, String password) {
        this.utilisateur = utilisateur;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
    @Override
    public String toString(){
        
         return this.utilisateur + " / " + this.password ; 
    }
    
    
}
