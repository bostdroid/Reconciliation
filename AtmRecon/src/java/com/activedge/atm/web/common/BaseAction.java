/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.message.data.MessageData;
import com.activedge.atm.user.data.UserData;
import com.activedge.atm.workflow.data.WorkflowData;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bost
 * Class to manage all action related functionality
 * 30-11-2016
 */
public class BaseAction extends ActionSupport {
    
    HttpServletRequest servletRequest;
    /**
     * the mode for create
     */
    protected final String CREATE_MODE = "C";
    /**
     * the mode for create
     */
    protected final String UPDATE_MODE = "U";
        /**
     * the mode for create
     */
    protected final String REMOVE_MODE = "R";
        /**
     * the mode for create
     */
    protected final String VIEW_MODE = "V";
    
    
                    /**
     * user entity data
     */
    private String editMode = VIEW_MODE;
    
        /**
     * user entity data
     */
    public UserData user;
    
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
    
    public String getEditMode()
    {
        return editMode;
    }
    
    
    public void setEditMode(String value)
    {
        editMode = value;
    }
    /**
     * the small list
     */
    private List statusList ;

    /**
     * @return the statusList
     */
    public List getStatusList() {
        return statusList;
    }

    /**
     * @param statusList the statusList to set
     */
    public void setStatusList(List statusList) {
        this.statusList = statusList;
    }
  
    
    
    protected List findStatusList()
    {
        if (statusList == null)
        {
            statusList = new ArrayList();
        }
        if (statusList.isEmpty())
        {
            statusList = new ArrayList();
            StaticListData data  = new StaticListData();
            data.setSmallCode("Active");
            data.setSmallDescription("Active");
            statusList.add(data);
            data  = new StaticListData();
            data.setSmallCode("Expired");
            data.setSmallDescription("Expired");
            statusList.add(data);
            data  = new StaticListData();
            data.setSmallCode("Retired");
            data.setSmallDescription("Retired");
            statusList.add(data);
            data  = new StaticListData();
            data.setSmallCode("Maintained");
            data.setSmallDescription("Maintained");
            statusList.add(data);
            data  = new StaticListData();
            data.setSmallCode("In-Stock");
            data.setSmallDescription("In-Stock");
            statusList.add(data);
            data  = new StaticListData();
            data.setSmallCode("Inactive");
            data.setSmallDescription("Inactive");
            statusList.add(data);

       
        }
        return statusList;
    }
  
 /**
  * the api to get the next id of a particular table
  * @param tableName - table name
  * @return long the next Id
  */
 protected String padLeft(Object category, long pNumber)
    {
        String sNumber = "" + pNumber;
        while (sNumber.length() < 10)
        {
            sNumber = "0" + sNumber;
        }
        return category + sNumber;
    }
    
}
