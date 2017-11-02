/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.branch.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author TechDev
 */
public class BranchData extends BaseData{

    private int branchID;
    //String variable for branch Name
    private String branchName;
    //String variable for branch Address
    private String address;
    //String variable for branch Code
    private String branchCode;
    //String variable for branch terminal
    private String terminalGroupID;
    
    private String status;
    /**
     * @return the branchID
     */
    public int getBranchID() {
        return branchID;
    }

    /**
     * @param branchID the branchID to set
     */
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the branchCode
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * @return the terminalGroupID
     */
    public String getTerminalGroupID() {
        return terminalGroupID;
    }

    /**
     * @param terminalGroupID the terminalGroupID to set
     */
    public void setTerminalGroupID(String terminalGroupID) {
        this.terminalGroupID = terminalGroupID;
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
