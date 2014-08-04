package com.atom.magma.filters;

import com.atom.magma.beans.AuthBeans;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.jms.Session;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("CREATION DU FILTRE");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("INTERCEPTION DU FILTRE");
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);
        
        System.out.println(Arrays.toString(session.getValueNames()));
        
        //AuthBeans ab = (AuthBeans)session.getAttribute("authbean");
        //System.out.println(ab);
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("DESTRUCTION DU FILTRE");
    }
    
}
