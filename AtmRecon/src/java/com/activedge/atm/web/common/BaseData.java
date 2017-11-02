/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package com.activedge.atm.web.common;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author emmanuel kalu
 * this class is the base data for all  entity data objects
 * 28 Nov 2016
 */
public class BaseData implements Serializable
{
    /**
     * the id of the entity object
     */
    long id = -1;
    /**
     * the createDate of the entity object
     */
    String strCreateDate;  
/**
 *  gets the string create date from the UI
 * @return String create date
 */
    public String getStrCreateDate() {
        return strCreateDate;
    }
/**
 * setting the string create date
 * @param strCreateDate - String create date from the UI
 */
    public void setStrCreateDate(String strCreateDate) {
        this.strCreateDate = strCreateDate;
    }
    /**
     * the createDate of the entity object
     */
    Date createDate;  
    /**
     * the create User Id of the entity object
     */
    String createUserId; 
    /**
     * the status of the entity object
     */
    String status;  
    /**
     * the version id of the entity object
     */
    private long versionId = -1;    

    /**
     * used to get the entity ID
     * @return long the ID of the entity
     */
    public long getId() {
        return id;
    }
    /**
     * sets the Id of the entity
     * @param value - the id of the entity
     */
    public void setId(long value) {
        this.id = value;
    }
    /**
     * 
     * @return Date the create Date of the entity
     */
    public Date getCreateDate() {
        return createDate;
    }
/**
 *  this sets the create Date of the entity
 * @param value - create Date 
 */
    public void setCreateDate(Date value) {
        this.createDate = value;
    }
    /**
     * 
     * @return long the ID of the entity
     */
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    /**
     * 
     * @return String the ID of the entity
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the versionId
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * @param versionId the versionId to set
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    
}
