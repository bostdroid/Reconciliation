/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.alert.data;

import com.activedge.atm.web.common.BaseData;
import java.sql.Date;

/**
 *
 * @author Efe Akpofure
 */
public class AlertData extends BaseData{

    
   
    
 /**
 * To store From User ID
 */
    private String fromUserId;
 /**
 * To store alert To User ID
 */
    private String toUserId;
 /**
 * To store alert Message
 */
    private String message;
    
    /**
 * To store alert Status
 */
    private String status;
    
 /**
 * To store alert Subject
 */
    private String subject;
    
 /**
 * To store alert date
 */   
    private Date createDate;
    
    /**
 * To store name
 */   
    private String name;
    
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
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * @return the fromUserId
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * @param fromUserId the fromUserId to set
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * @return the toUserId
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * @param toUserId the toUserId to set
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
     
       
     /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

 
    
}
