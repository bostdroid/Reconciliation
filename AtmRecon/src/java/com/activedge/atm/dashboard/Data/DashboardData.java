/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.dashboard.Data;

import com.activedge.atm.web.common.BaseData;
/**
 *
 * @author TechDev
 */
public class DashboardData extends BaseData {
    
    
    private String terminalID;
    private String pan;
    private String accountNo;
    private String stan;
    private String amount;
    private String rrn;
    private String date;
    private String time;
    private java.sql.Date sqlDate;
    private String status;

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
     * @return the pan
     */
    public String getPan() {
        return pan;
    }

    /**
     * @param pan the pan to set
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the stan
     */
    public String getStan() {
        return stan;
    }

    /**
     * @param stan the stan to set
     */
    public void setStan(String stan) {
        this.stan = stan;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the rrn
     */
    public String getRrn() {
        return rrn;
    }

    /**
     * @param rrn the rrn to set
     */
    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the sqlDate
     */
    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    /**
     * @param sqlDate the sqlDate to set
     */
    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
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
}