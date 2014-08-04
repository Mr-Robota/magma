package com.atom.magma.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CompteBeans implements Serializable {
    
    
    
    public String getId(int id)
    {
        return "Vous avez => "+id;
    }
    
}
