/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.workflow.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author Activedge1
 */
public class WorkflowData extends BaseData{ 

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fromUserID
     */
    public String getFromUserID() {
        return fromUserID;
    }

    /**
     * @param fromUserID the fromUserID to set
     */
    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    /**
     * @return the toUserID
     */
    public String getToUserID() {
        return toUserID;
    }

    /**
     * @param toUserID the toUserID to set
     */
    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return the moduleID
     */
    public String getModuleID() {
        return moduleID;
    }

    /**
     * @param moduleID the moduleID to set
     */
    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    /**
     * @return the nextActivity
     */
    public String getNextActivity() {
        return nextActivity;
    }

    /**
     * @param nextActivity the nextActivity to set
     */
    public void setNextActivity(String nextActivity) {
        this.nextActivity = nextActivity;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the workflowStatus
     */
    public String getWorkflowStatus() {
        return workflowStatus;
    }

    /**
     * @param workflowStatus the workflowStatus to set
     */
    public void setWorkflowStatus(String workflowStatus) {
        this.workflowStatus = workflowStatus;
    }
    private String fromUserID;
    private String toUserID;
    private String module;
    private String moduleID;
    private String nextActivity;
    private String remark;
    private String workflowStatus;
    
    private String name;
}
