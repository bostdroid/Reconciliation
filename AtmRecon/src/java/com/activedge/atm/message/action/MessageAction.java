/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.message.action;

import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.message.persistence.MessageDAO;
import com.activedge.atm.message.data.MessageData;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import com.activedge.atm.user.action.UserAction;
import com.activedge.atm.user.data.UserData;
import com.activedge.atm.web.common.AppBusinessDelegate;
import com.activedge.atm.workflow.data.WorkflowData;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ValidationAware;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Efe Akpofure
 */
public class MessageAction extends BaseAction implements ValidationAware {

    /**
     * message entity data
     */
    private MessageData message;

    /**
     * list of messages entity data
     */
    private List messages;

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
     * @return the message
     */
    public MessageData getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(MessageData message) {
        this.message = message;
    }

    /**
     * list of workflows assigned to the user
     */
    private List workflows;   
    
    /**
     * size of the workflow
     */
    private int workflowSize; 
    
    
    
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
     * Create a new message setting the user Id from session
     *
     * @return String the action path for success
     */
    public String createNewMessage() {
        Map session = ActionContext.getContext().getSession();
        String loginUserId = (String) session.get("loginUserId");
        MessageData message = new MessageData();
        message.setFromUserId(loginUserId);
        setMessage(message);
        return "success";
    }



    public String execute() {

        System.out.println("Did i get here");
        Map session = ActionContext.getContext().getSession();
        String logged = (String) session.get("loggedin");
        System.out.println("Did i get here");
        if (logged != null && logged.trim().equalsIgnoreCase("true")) {
            System.out.println("Did i get here 1");
            String sId = (String) session.get("loginid");
            if (sId != null) {
                System.out.println("Did i get here 2");
           //     user.setId(Long.valueOf(sId));
                message.setToUserId(sId);
            }


        }
        else
        {
             message.setToUserId("9999");
            System.out.println("Did i get here 3");

        }
        return "success";
    }

    public String access() throws SQLException {
                if (message == null)
        {
            this.setMessage(new MessageData());
        }
        System.out.println("Did i get here");
        Map session = ActionContext.getContext().getSession();
        String logged = (String) session.get("loggedin");
        System.out.println("Did i get here");
        if (logged != null && logged.trim().equalsIgnoreCase("true")) {
            System.out.println("Did i get here 1");
            String sId = (String) session.get("loginid");
            if (sId != null) {
                System.out.println("Did i get here 2" + sId);
           //     user.setId(Long.valueOf(sId));
                message.setToUserId(sId);
                user = new UserData();
                user.setId(Long.valueOf(sId));
            }
retrieveCommunicationsInfo(user);
return SUCCESS;
        }
        else
        {
             message.setToUserId("9999");
            System.out.println("Did i get here 3");

        }
        return "success";
    }

    /**
     * creates Message Data
     *
     * @return
     * @throws Exception
     */
    public String createMessage() throws Exception {
        MessageDAO dao = new MessageDAO();
        MessageData data = dao.createMessage(getMessage());
        List messageList = dao.findAllMessages();
        setMessage(data);
        setMessages(messageList);

        return SUCCESS;
    }

    /**
     * creates Message Data
     *
     * @return
     * @throws Exception
     */
    public String updateMessage() throws Exception {
        MessageDAO dao = new MessageDAO();
        MessageData data = dao.updateMessage(getMessage());
        List messagesList = dao.findAllMessages();
        setMessage(data);
        setMessages(messagesList);

        return "success";
    }

    /**
     * creates Message Data
     *
     * @return
     * @throws Exception
     */
    public String deleteMessage() throws Exception {
        MessageDAO dao = new MessageDAO();
        MessageData data = dao.deleteMessage(getMessage());
        List messagesList = dao.findAllMessages();
        setMessage(data);
        setMessages(messagesList);

        return "success";
    }

    /**
     * creates Message Data
     *
     * @return
     * @throws Exception
     */
    public String viewMessage() throws Exception {
        MessageDAO dao = new MessageDAO();
        MessageData data = dao.viewMessage(getMessage());
        List messageList = dao.findAllMessages();
        setMessage(data);
        setMessages(messageList);

        return SUCCESS;
    }

    /**
     * returns all Message Data
     *
     * @return
     * @throws Exception
     */
    public String findAllMessages() throws Exception {
        MessageDAO dao = new MessageDAO();
        List messageList = dao.findAllMessages();
        setMessages(messageList);
        findMessagesByCriteria();
        return SUCCESS;
    }

    public void retrieveCommunicationsInfo(UserData user1) throws SQLException {
        AlertData altdata = new AlertData();
        altdata.setToUserId("" + user1.getId());
        List alertList = AppBusinessDelegate.findAlertByCriteria(altdata);
        setAlerts(alertList);

        MessageData msgdata = new MessageData();
        msgdata.setToUserId("" + user1.getId());
        List messageList = AppBusinessDelegate.findMessagesByCriteria(msgdata);
        setMessages(messageList);

        WorkflowData workdata = new WorkflowData();
        workdata.setToUserID("" + user1.getId());
        List workflowList = AppBusinessDelegate.findWorkflowsByCriteria(workdata);
        setWorkflows(workflowList);
    }

    /**
     * searches Message Data
     *
     * @return
     * @throws Exception
     */
    public String findMessagesByCriteria() throws Exception {
        MessageDAO dao = new MessageDAO();
        List messageList = dao.findMessagesByCriteria(getMessage());
        setMessages(messageList);

        return SUCCESS;
    }

}
