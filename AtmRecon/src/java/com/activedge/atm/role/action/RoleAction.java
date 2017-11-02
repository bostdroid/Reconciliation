/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.role.action;

import com.activedge.atm.role.data.RoleData;
import com.activedge.atm.role.persistence.RoleDAO;
import com.activedge.atm.roletask.data.RoleTaskData;
import com.activedge.atm.roletask.persistence.RoleTaskDAO;
import com.activedge.atm.task.persistence.TaskDAO;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoleAction extends BaseAction{
    private RoleData role = new RoleData();
    private String editMode = VIEW_MODE;
    private List roles;
    private List roleAvailableTasks;
    private String[] assignedTask;

    /**
     * @return the role
     */
    public RoleData getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(RoleData role) {
        this.role = role;
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
    public String execute(){
        return SUCCESS;
    }
    
    /**
     * creates Branch Data
     * @return
     * @throws Exception 
     */
    public String createRoleTask() throws Exception {
        RoleTaskDAO dao = new RoleTaskDAO();
        System.out.println("@Rolw"  + getRole().getRoleID());
        if (getAssignedTask()!= null)
         System.out.println("@Rol length"  + getAssignedTask().length);
        long roleId = this.getRole().getRoleID();
        dao.deleteRoleTaskByRoleId(roleId);
        RoleData data = dao.createRoleTask(getRole(),  getAssignedTask());
        RoleDAO dao1 = new RoleDAO();
        List taskList = dao1.findAllRoles();
        setRole(data);
        setRoles(taskList);
       
        return SUCCESS;
    }
    
        /**
         * This fetches the available tasks for a particular role 
         * execute method
         */
    public String initCreateRoleTask() throws SQLException{
        long roleId = this.getRole().getRoleID();
        String code = this.getRole().getCode();
        System.out.println(roleId + "  " + code);
        System.out.println(editMode + "  " + code);
        setRole(new RoleData());
        TaskDAO actdao = new TaskDAO();
        RoleTaskDAO dao = new RoleTaskDAO();
        List roleTask = dao.findAllRoleTasks(roleId);
        System.out.println(" roleTask size " + roleTask.size());
        setRoles(roleTask); 
        List alltasks = actdao.findAllTasks(roleId);
        setRoleAvailableTasks(alltasks); 
        System.out.println(" findAllTasks size " + alltasks.size());
        this.getRole().setCode(code);
        this.getRole().setRoleID(roleId);
        return SUCCESS;
    }
    /**
     * creates Role Data
     * @return
     * @throws Exception 
     */
    public String createRole() throws Exception {
        RoleDAO dao = new RoleDAO();
        RoleData data = dao.createRole(getRole());
        List roleList = dao.findAllRoles();
        setRole(data);
        setRoles(roleList);

        return SUCCESS;
    }

    
public String initCreateRole() throws SQLException{
        long roleId = this.getRole().getRoleID();
        String code = this.getRole().getCode();
        System.out.println(roleId + "  " + code);
        setRole(new RoleData());
//        TaskDAO actdao = new TaskDAO();
        RoleDAO dao = new RoleDAO();
        List role = dao.findAllRolesByID(roleId);
        setRoles(role); 
        this.getRole().setCode(code);
        this.getRole().setRoleID(roleId);
        return SUCCESS;
    }
    /**
     * updates Role Data
     * @return
     * @throws Exception 
     */
    public String updateRole() throws Exception {
        RoleDAO dao = new RoleDAO();
        RoleData data = dao.updateRole(getRole());
        List roleList = dao.findAllRoles();
        setRole(data);
        setRoles(roleList);

        return SUCCESS;
    }
    /**
     * deletes Role Data
     * @return
     * @throws Exception 
     */
    public String deleteRole() throws Exception {
        RoleDAO dao = new RoleDAO();
        RoleData data = dao.deleteRole(getRole());
        List roleList = dao.findAllRoles();
        setRole(data);
        setRoles(roleList);

        return SUCCESS;
    }
    /**
     * views Role Data
     * @return
     * @throws Exception 
     */
    public String viewRole() throws Exception {
        RoleDAO dao = new RoleDAO();
        RoleData data = dao.viewRole(getRole());
        List roleList = dao.findAllRoles();
        setRole(data);
        setRoles(roleList);

        return SUCCESS;
    }
    /**
     * finds AllRoles Data
     * @return
     * @throws Exception 
     */
    public String findAllRoles() throws Exception {
        RoleDAO dao = new RoleDAO();
        List roleList = dao.findAllRoles();
        setRoles(roleList);

        return SUCCESS;
    }
    /**
     * finds RolesByCriteria Data
     * @return
     * @throws Exception 
     */
    public String findRolesByCriteria() throws Exception {
        RoleDAO dao = new RoleDAO();
        System.out.println("calling me....." + role.getCode());
        List roleList = dao.findRolesbyCriteria(getRole());
        setRoles(roleList);         
        
        return SUCCESS;
    }

    /**
     * @return the roleAvailableTasks
     */
    public List getRoleAvailableTasks() {
        return roleAvailableTasks;
    }

    /**
     * @param roleAvailableTasks the roleAvailableTasks to set
     */
    public void setRoleAvailableTasks(List roleAvailableTasks) {
        this.roleAvailableTasks = roleAvailableTasks;
    }

    /**
     * @return the assignedTask
     */
    public String[] getAssignedTask() {
        return assignedTask;
    }

    /**
     * @param assignedTask the assignedTask to set
     */
    public void setAssignedTask(String[] assignedTask) {
        this.assignedTask = assignedTask;
    }
}
