/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.roletask.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author TechDev
 */
public class RoleTaskData extends BaseData {
    
    private long roleID;
    private String taskCode;
    private String code;
    private String description;    
    private String dList;
    private String myList;
    
    
    /**
     * @return the roleID
     */
    public long getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    /**
     * @return the activityCode
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * @param taskCode the activityCode to set
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the dList
     */
    public String getdList() {
        return dList;
    }

    /**
     * @param dList the dList to set
     */
    public void setdList(String dList) {
        this.dList = dList;
    }

    /**
     * @return the myList
     */
    public String getMyList() {
        return myList;
    }

    /**
     * @param myList the myList to set
     */
    public void setMyList(String myList) {
        this.myList = myList;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @param description the description to set
     */
    public String getListDescription() {
        return this.taskCode + " - " + description;
    }
}
