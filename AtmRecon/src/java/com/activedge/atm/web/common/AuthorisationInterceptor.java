/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TechDEv
 */
public class AuthorisationInterceptor implements Interceptor{

    @Override
    public void destroy() {
        System.out.println(" calling destroy of AuthorisationInterceptor ");
    }

    @Override
    public void init() {
        System.out.println(" calling init of AuthorisationInterceptor ");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map session = ai.getInvocationContext().getSession();
                           session.remove("usernotauthorized");
                   session.remove("userfunction");
                 Map activitiesMap = (Map) session.get("activiauthorizedties");
                 System.out.println( "you are in auto- ");  
                if (activitiesMap == null || activitiesMap.isEmpty())
                {
                    System.out.println(1);
                  // throw new Exception("No role activities detected");
                    activitiesMap = new HashMap();
                    activitiesMap.put("initUser", "initUser");
                    activitiesMap.put("findAllUsers", "findAllUsers");
                    activitiesMap.put("createNewUser", "createNewUser");
                    activitiesMap.put("createUser", "createUser");
                    activitiesMap.put("updateUser", "updateUser");
                    activitiesMap.put("viewUser", "viewUser");
                    activitiesMap.put("initJournalViewer", "initJournalViewer");
                    activitiesMap.put("initFile", "initFile");
                    activitiesMap.put("initReport", "initReport");
                    activitiesMap.put("initAnalytics", "initAnalytics");
                    activitiesMap.put("initRole", "initRole");
                    activitiesMap.put("createNewRole", "createRole");
                    activitiesMap.put("createRole", "initRole");
                    activitiesMap.put("updateRole", "updateRole");
                    activitiesMap.put("deleteRole", "deleteRole");
                    activitiesMap.put("findAllRoles", "findAllRoles");
                    activitiesMap.put("findRolesByCriteria", "findRolesByCriteria");
                    activitiesMap.put("viewRole", "viewRole");
                    activitiesMap.put("initRolesByCriteria", "initRolesByCriteria");
                    activitiesMap.put("initRoleTask", "initRoleTask");
                    activitiesMap.put("initTask", "initTask");
                    activitiesMap.put("createNewTask", "createNewTask");
                    activitiesMap.put("createTask", "createTask");
                    activitiesMap.put("updateTask", "updateTask");
                    activitiesMap.put("deleteTask", "deleteTask");
                    activitiesMap.put("initReport", "initReport");
                            System.out.println(2);
                }
                  //  return Action.LOGIN;
             System.out.println( (String) ai.getProxy().getActionName());
             System.out.println( (String) ai.getProxy().getMethod());                
                String actionPath = (String) ai.getProxy().getActionName();
                if (!activitiesMap.containsKey(actionPath))
                {
                    System.out.println( "you are not authorized"); 
                    System.out.println( "you are not authorized action path"+ actionPath); 
                    
                   ((ValidationAware) ai.getAction()).addActionError("You are not authorized to access the page " + actionPath);
                   session.put("usernotauthorized", "true");
                   session.put("userfunction", actionPath);
                    
                   return "login";
                }
                

                
                return ai.invoke();
    }
    
}
