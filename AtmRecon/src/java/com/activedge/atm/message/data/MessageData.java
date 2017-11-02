/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.message.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author Efe Akpofure
 */
public class MessageData extends BaseData{

    

    
 /**
 * To store From User ID
 */
    private String fromUserId;
 /**
 * To store message To User ID
 */
    private String toUserId;
 /**
 * To store Message
 */
    private String message;
    
    /**
 * To store message Status
 */
    private String status;
    
 /**
 * To store message Subject
 */
    private String subject;
    /**
 * To store user name
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
     
       
 
    
}
