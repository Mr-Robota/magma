package com.atom.magma.business.auth.entity;

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
@Table(name="Groupes")
public class Groupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="labelMembre")
    private String labelMembre;
    
    @Column(name="slug")
    private int slug;
    
    @ManyToMany
    private List<Utilisateur> client;
    
    @ManyToMany(mappedBy = "groupe")
    private List<ModuleAuth> moduleAuth;

    public Groupe() {
        this.client = new ArrayList<>();
    }

    public List<Utilisateur> getClient() {
        return client;
    }

    public void setClient(List<Utilisateur> client) {
        this.client = client;
    }

    public List<ModuleAuth> getModuleAuth() {
        return moduleAuth;
    }

    public Groupe(long id, String labelMembre, int slug, List<Utilisateur> client, List<ModuleAuth> moduleAuth) {
        this.id = id;
        this.labelMembre = labelMembre;
        this.slug = slug;
        this.client = client;
        this.moduleAuth = moduleAuth;
    }

    
    
    public void setModuleAuth(List<ModuleAuth> moduleAuth) {
        this.moduleAuth = moduleAuth;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public String getLabelMembre() {
        return labelMembre;
    }

    public void setLabelMembre(String labelMembre) {
        this.labelMembre = labelMembre;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }
    
    
}
