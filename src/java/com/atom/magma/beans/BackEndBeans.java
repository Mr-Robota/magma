package com.atom.magma.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BackEndBeans {
    
    
    
    public String login(){
        
        return "vues/login/login.xhtml";
        
    }
    
    
}
