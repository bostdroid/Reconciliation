/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author TechDEv
 */
public class AuthenticationInterceptor implements Interceptor{

    @Override
    public void destroy() {
        System.out.println(" calling destroy of AuthenticationInterceptor ");
    }

    @Override
    public void init() {
        System.out.println(" calling init of AuthenticationInterceptor ");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map session = ai.getInvocationContext().getSession();
                 String logged = (String) session.get("loggedin");
                if (logged == null || !logged.trim().equalsIgnoreCase("true"))
                    return Action.LOGIN;
             System.out.println( (String) ai.getProxy().getActionName());
             System.out.println( (String) ai.getProxy().getMethod());
                
                return ai.invoke();
    }
    
}
