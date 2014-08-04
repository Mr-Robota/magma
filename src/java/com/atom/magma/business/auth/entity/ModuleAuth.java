package com.atom.magma.business.auth.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ModuleAuths")
public class ModuleAuth implements Serializable {
    
    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @Column(name = "nomRessource")
    private String nomRessource;
    
    @Column(name = "nomAction")
    private String nomAction;
    
    @OneToOne
    private typeRessource typeRes;
    
    @ManyToMany
    private List<Groupe> groupe;

    public typeRessource getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(typeRessource typeRes) {
        this.typeRes = typeRes;
    }
   
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomRessource() {
        return nomRessource;
    }

    public void setNomRessource(String nomRessource) {
        this.nomRessource = nomRessource;
    }



    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public List<Groupe> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<Groupe> groupe) {
        this.groupe = groupe;
    }



    public ModuleAuth() {
    }

    
    
    
}
