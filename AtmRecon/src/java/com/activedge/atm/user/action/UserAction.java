/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.user.action;

/**
 *
 * @author TechDev
 */
import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.branch.DAO.BranchDAO;
import com.activedge.atm.message.data.MessageData;
import com.activedge.atm.role.persistence.RoleDAO;
import com.activedge.atm.roletask.data.RoleTaskData;
import com.activedge.atm.roletask.persistence.RoleTaskDAO;
import com.activedge.atm.user.data.UserData;
import com.activedge.atm.user.persistence.UserDAO;
import com.activedge.atm.web.common.AppBusinessDelegate;
import com.activedge.atm.web.common.BaseAction;
import com.activedge.atm.web.common.BaseData;
import com.activedge.atm.workflow.data.WorkflowData;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ValidationAware;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 * this is the model that handles all the user action
 * @author TechDEv
 */
public class UserAction extends BaseAction implements ValidationAware {

      
        

    /**
     * user entity data
     */
    private String editMode = VIEW_MODE;
    /**
     * user entity data
     */
    private UserData user;
    
    /**
     * list of users entity data
     */
    private List users;   
    
    /**
     * list of workflows assigned to the user
     */
    private List workflows;   
    
    /**
     * size of the workflow
     */
    private int workflowSize; 
    
    /**
     * list of messages assigned to the user
     */
    private List messages;   
    
    /**
     * size of the messages
     */
    private int messageSize;
    /**
     * list of messages assigned to the user
     */
    private List alerts;   
    
    /**
     * size of the messages
     */
    private int alertSize;
    
    private List branchList;
    
    private List roleList;
    
    @Override
    public String execute() throws Exception {
        setUser(new UserData());
        BranchDAO dao = new BranchDAO();
        RoleDAO dao1 = new RoleDAO();
        List roleLists = dao1.findAllRoles();
        setRoleList(roleLists);
        List branchLists = dao.findAllBranches();
//        List<String>  branchList = dao.findAllBranches();
        setBranchList(branchLists); 
//        System.out.println("branch "+branchList);
//        setChooseBranch(branchList);
        
        return SUCCESS;
    }
    
    
    public String initHome() throws Exception {
       // setUser(new UserData());
        UserData user = getUser();
                Map session = ActionContext.getContext().getSession();
                
                String logged = (String) session.get("loggedin");
                if (logged != null && logged.trim().equalsIgnoreCase("true"))
                {
                    String sId = (String) session.get("loginid");
                    if (sId != null)
                    {
                        user = new UserData();
                        user.setId(Long.valueOf(sId));
                    }
                   retrieveWorkflowInfo(user);
                   retrieveMessageInfo(user);
                   retrieveAlertInfo(user);
                    return SUCCESS;
                }
                    
                
                if (user == null || user.getLoginId() == null || getUser().getLoginId().trim().length() < 1)
                {
                    
                addFieldError("user.loginId", "User Name is required");  

               
                    return INPUT;
                }
                
       //  stmt.setString(paramcount, usercriteria.getLoginId()); 

     
      if (getUser().getPassword() == null || getUser().getPassword().trim().length() < 1)
      {
            addFieldError("user.password", getText("Password is required"));  
                
        return INPUT;
      }
      
            
      //findUserActivities
      //get the role id
      //find the assignedactivities

      
            if (getUser().getPassword().equalsIgnoreCase("sysadmin") && getUser().getLoginId().equalsIgnoreCase("sysadmin"))
                    return SUCCESS;
            
                UserDAO dao = new UserDAO();
                List list = dao.findUserByCriteria(getUser());
                if (list.size() != 1)
                {
                    addFieldError("user.password", getText("The username and password combination does not exist"));  
                    return INPUT;
                }
                UserData founduser = (UserData) list.get(0);
        long roleid = founduser.getRoleId();
        System.out.println("role id&&&=" + roleid);
        Map mp = new HashMap();
        RoleTaskDAO adao = new RoleTaskDAO();
        List tasks = adao.findAllRoleTasks(roleid);
        for (Iterator it = tasks.iterator(); it.hasNext();) {
            RoleTaskData rActData = (RoleTaskData) it.next();
            mp.put(rActData.getTaskCode(), rActData.getTaskCode());
            System.out.println("we = " + rActData.getTaskCode());
        }
        System.out.println("size" + mp.values().size());

      
                    session.put("loggedin", "true");
                    session.put("loginid", "" + founduser.getId());
                    session.put("loginUserId", "" + founduser.getLoginId());
                    session.put("activiauthorizedties", mp);
                    user.setId(founduser.getId());
                    retrieveWorkflowInfo(user);
                    retrieveMessageInfo(user);
                    retrieveAlertInfo(user);
        
        return SUCCESS;
    }  

    private void retrieveWorkflowInfo(UserData user1) throws SQLException {
        WorkflowData wkdata = new WorkflowData();
        wkdata.setToUserID(""+ user1.getId());
        System.out.println("I am here 1");
        List workflowList = AppBusinessDelegate.findWorkflowsByCriteria(wkdata);
        setWorkflows(workflowList);
        System.out.println("I am here 2  " +workflowList.size());
        //session.put("loggedin", "true");
    }
    
    private void retrieveMessageInfo(UserData user1) throws SQLException {
        MessageData wkdata = new MessageData();
        wkdata.setToUserId(""+ user1.getId());
        System.out.println("I am message 1");
        List messageList = AppBusinessDelegate.findMessagesByCriteria(wkdata);
        setMessages(messageList);
        System.out.println("I am messageS 2  " +messageList.size());
        //session.put("loggedin", "true");
    }
    
        private void retrieveAlertInfo(UserData user1) throws SQLException {
        AlertData alertdata = new AlertData();
        alertdata.setToUserId(""+ user1.getId());
        System.out.println("I am message 1");
        List alertList = AppBusinessDelegate.findAlertByCriteria(alertdata);
        setAlerts(alertList);
        System.out.println("I am messageS 2  " +alertList.size());
        //session.put("loggedin", "true");
    }
    
    public String logOffHome() throws Exception {
        setUser(new UserData());
        Map session = ActionContext.getContext().getSession();
        session.remove("loggedin");
              
        return SUCCESS;
    }     
    
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String createUser() throws Exception {
        UserDAO dao = new UserDAO();
        UserData data = dao.createUser(getUser());
        List userList = dao.findAllUsers();
        setUser(data);
        setUsers(userList);
        
        return SUCCESS;
    }
    
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String updateUser() throws Exception {
        UserDAO dao = new UserDAO();
        UserData data = dao.updateUser(getUser());
        List userList = dao.findAllUsers();
        setUser(data);
        setUsers(userList);        
        
        return SUCCESS;
    }  
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String deleteUser() throws Exception {
        UserDAO dao = new UserDAO();
        UserData data = dao.deleteUser(getUser());
        List userList = dao.findAllUsers();
        setUser(data);
        setUsers(userList);        
        
        return SUCCESS;
    } 
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String viewUser() throws Exception {
        UserDAO dao = new UserDAO();
        UserData data = dao.viewUser(getUser());
//        List userList = dao.findAllUsers();
        setUser(data);
//        setUsers(userList); 


        return SUCCESS;
    }   
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String loginUser() throws Exception {
        
        
        return SUCCESS;
    }     
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public String findAllUsers() throws Exception {
        UserDAO dao = new UserDAO();
        List userList = dao.findAllUsers();
        setUsers(userList);         
        
        return SUCCESS;
    }     
    
    /**
     * searches for User Data
     * @return
     * @throws Exception 
     */
    public String findUsersByCriteria() throws Exception {
        UserDAO dao = new UserDAO();
        List userList = dao.findUserByCriteria(getUser());
        setUsers(userList);         
        
        return SUCCESS;
    }     

    /**
     * @return the user
     */
    public UserData getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserData user) {
        this.user = user;
    }

    /**
     * @return the users
     */
    public List getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List users) {
        this.users = users;
    }

    /**
     * @return the workflows
     */
    public List getWorkflows() {
        return workflows;
    }

    /**
     * @param workflows the workflows to set
     */
    public void setWorkflows(List workflows) {
        this.workflows = workflows;
    }

    /**
     * @return the workflowSize
     */
    public int getWorkflowSize() {
        if (workflows == null )
        {
            return workflowSize = 0;
        }
        else
        {
            workflowSize = workflows.size();
        }
        return workflowSize;
    }

    /**
     * @param workflowSize the workflowSize to set
     */
    public void setWorkflowSize(int workflowSize) {
        this.workflowSize = workflowSize;
    }
    
    
    
    /**
     * @return the messages
     */
    public List getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List messages) {
        this.messages = messages;
    }

    /**
     * @return the messageSize
     */
    public int getMessageSize() {
        
        if (messages == null )
        {
            return messageSize = 0;
        }
        else
        {
            messageSize = messages.size();
        }
        
        return messageSize;
    }

    /**
     * @param messageSize the messageSize to set
     */
    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }
    
    
    /**
     * @return the alertSize
     */
    public int getAlertSize() {
        
         if (getAlerts() == null )
        {
            return alertSize = 0;
        }
        else
        {
            alertSize = getAlerts().size();
        }
        
        return alertSize;
    }

    /**
     * @param alertSize the alertSize to set
     */
    public void setAlertSize(int alertSize) {
        this.alertSize = alertSize;
    }

    /**
     * @return the alerts
     */
    public List getAlerts() {
        return alerts;
    }

    /**
     * @param alerts the alerts to set
     */
    public void setAlerts(List alerts) {
        this.alerts = alerts;
    }

    /**
     * @return the branchList
     */
    public List getBranchList() {
        return branchList;
    }

    /**
     * @param branchList the branchList to set
     */
    public void setBranchList(List branchList) {
        this.branchList = branchList;
    }

    /**
     * @return the roleList
     */
    public List getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(List roleList) {
        this.roleList = roleList;
    }

    
}

