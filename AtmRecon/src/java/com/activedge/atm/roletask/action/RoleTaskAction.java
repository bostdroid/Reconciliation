/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.roletask.action;

import com.activedge.atm.roletask.data.RoleTaskData;
import com.activedge.atm.roletask.persistence.RoleTaskDAO;
import com.activedge.atm.task.persistence.TaskDAO;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Backup
 */
public class RoleTaskAction  extends BaseAction{

    private RoleTaskData roletask = new RoleTaskData(); 
    private String editMode = VIEW_MODE;
 
        private List roleTasks;
        
        private List roleAvailableTasks;
                
        private List roles;
        
        private String[] assignedTask;
    
        /**
         * This fetches the available tasks for a particular role 
         * execute method
         */
    public String initCreateRoleTask() throws SQLException{
        long roleId = this.getRoleTask().getRoleID();
        String code = this.getRoleTask().getCode();
        System.out.println(roleId + "  " + code);
        setRoleTask(new RoleTaskData());
        TaskDAO actdao = new TaskDAO();
        RoleTaskDAO dao = new RoleTaskDAO();
        List roleTask = dao.findAllRoleTasks(roleId);
        setRoleTasks(roleTask); 
        setRoleAvailableTasks(actdao.findAllTasks(roleId)); 
        this.getRoleTask().setCode(code);
        this.getRoleTask().setRoleID(roleId);
        return SUCCESS;
    }

    
        /**
         * execute method
         */
        public String execute() throws SQLException{
        setRoleTask(new RoleTaskData());
        TaskDAO actdao = new TaskDAO();
        RoleTaskDAO dao = new RoleTaskDAO();
        List roleTask = dao.findAllRoleTasks();
        setRoleTasks(roleTask); 
        setRoleAvailableTasks(actdao.findAllTasks(2)); 
        return SUCCESS;
    }
    /**
     * creates Branch Data
     * @return
     * @throws Exception 
     */
    public String createRoleTask() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        System.out.println("@Rolw"  + getRoleTask().getRoleID());
        if (getAssignedTask()!= null)
         System.out.println("@Rol length"  + getAssignedTask().length);
        long roleId = this.getRoleTask().getRoleID();
        dao.deleteRoleTaskByRoleId(roleId);
//        RoleTaskData data = dao.createRoleTask(getRoleTask(),  getAssignedTask());
        List taskList = dao.findAllRoleTasks();
//        setRoleTask(data);
        setRoleTasks(taskList);
       
        return SUCCESS;
    }
    /**
     * updates Task Data
     * @return
     * @throws Exception 
     */
    public String updateRoleTask() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        RoleTaskData data = dao.updateRoleTask(getRoleTask());
        List roleList = dao.findAllRoleTasks();
        setRoleTask(data);
        setRoleTasks(roleList);        
        
        return SUCCESS;
    }  
       
    
    /**
     * deletes Role Data
     * @return
     * @throws Exception 
     */
    public String deleteRoleTask() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        RoleTaskData data = dao.deleteRoleTask(getRoleTask());
        List taskList = dao.findAllRoleTasks();
        setRoleTask(data);
        setRoleTasks(taskList);        
        
        return SUCCESS;
    } 
    /**
     * views Branch Data
     * @return
     * @throws Exception 
     */
    public String viewRoleTask() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        RoleTaskData data = dao.viewRoleTask(getRoleTask());
        List taskList = dao.findAllRoleTasks();
        setRoleTask(data);
        setRoleTasks(taskList); 

        return SUCCESS;
    }   
    
    /**
     * finds AllBranches Data
     * @return
     * @throws Exception 
     */
    public String findAllRoleTasks() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        List taskList = dao.findAllRoleTasks();
        setRoleTasks(taskList);         
        
        return SUCCESS;
    }     

    /**
     * @return the roleactivity
     */
    public RoleTaskData getRoleTask() {
        return roletask;
    }

    /**
     * @param roletask the activity to set
     */
    public void setRoleTask(RoleTaskData roletask) {
        this.roletask = roletask;
    }

    /**
     * @return the editMode
     */
    public String getEditMode() {
        return editMode;
    }

    /**
     * @param editMode the editMode to set
     */
    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }

   

    /**
     * @return the roleActivitys
     */
    public List getRoleTasks() {
        return roleTasks;
    }

    /**
     * @param roleTasks the roleActivitys to set
     */
    public void setRoleTasks(List roleTasks) {
        this.roleTasks = roleTasks;
    }

    /**
     * @return the roles
     */
    public List getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List roles) {
        this.roles = roles;
    }

    /**
     * @return the roleAvailableActivitys
     */
    public List getRoleAvailableTasks() {
        return roleAvailableTasks;
    }

    /**
     * @param roleAvailableTasks the roleAvailableActivitys to set
     */
    public void setRoleAvailableTasks(List roleAvailableTasks) {
        this.roleAvailableTasks = roleAvailableTasks;
    }

    /**
     * @return the assignedActivity
     */
    public String[] getAssignedTask() {
        return assignedTask;
    }

    /**
     * @param assignedTask the assignedActivity to set
     */
    public void setAssignedTask(String[] assignedTask) {
        this.assignedTask = assignedTask;
    }
}
