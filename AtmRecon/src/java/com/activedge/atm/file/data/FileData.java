/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.file.data;

import java.io.Serializable;
import java.sql.Date;


/**
 * the role data object
 * @author ekalu
 */
public class FileData implements Serializable
{
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     *  Select Line
     */    
     String selectLineId;
    /**
     *  Line
     */    
     long lineId;
    /**
     *  Name
     */
    String name = "";
        /**
     * the file detail 
     */
    private String detail = "";
    /**
     * role Id
     */
    long fileSize ;  

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    /**
     * password
     */
    String createUserId = "";
    /**
     * Status
     */
    String status = "";
    /**
     * startTime
     */
    Date createDate = null;    
    /**
     * startTime
     */
    private String strCreateDate = null;


    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
      

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
        /**
     * user
     */
    String user = "";    


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String userId) {
        this.createUserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getLineId() {
        return lineId;
    }

    public void setLineId(long lineId) {
        this.lineId = lineId;
    }

    public String getSelectLineId() {
        return selectLineId;
    }

    public void setSelectLineId(String selectLineId) {
        this.selectLineId = selectLineId;
    }

    /**
     * @return the strCreateDate
     */
    public String getStrCreateDate() {
        return strCreateDate;
    }

    /**
     * @param strCreateDate the strCreateDate to set
     */
    public void setStrCreateDate(String strCreateDate) {
        this.strCreateDate = strCreateDate;
    }
private String terminalID;
private String journalDate;

    /**
     * @return the terminalID
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    /**
     * @return the date
     */
    public String getJournalDate() {
        return journalDate;
    }

    /**
     * @param journalDate the date to set
     */
    public void setJournalDate(String journalDate) {
        this.journalDate = journalDate;
    }

  
}
