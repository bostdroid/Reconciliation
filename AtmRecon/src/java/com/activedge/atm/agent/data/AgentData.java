/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.agent.data;

import com.activedge.atm.web.common.BaseData;
/**
 *
 * @author Backup
 */
public class AgentData extends BaseData {

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the terminal_id
     */
    public String getTerminal_id() {
        return terminal_id;
    }

    /**
     * @param terminal_id the terminal_id to set
     */
    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    /**
     * @return the terminal_name
     */
    public String getTerminal_name() {
        return terminal_name;
    }

    /**
     * @param terminal_name the terminal_name to set
     */
    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * @return the terminal_addr
     */
    public String getTerminal_addr() {
        return terminal_addr;
    }

    /**
     * @param terminal_addr the terminal_addr to set
     */
    public void setTerminal_addr(String terminal_addr) {
        this.terminal_addr = terminal_addr;
    }

    /**
     * @return the branch_id
     */
    public String getBranch_id() {
        return branch_id;
    }

    /**
     * @param branch_id the branch_id to set
     */
    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
    private long id;
    private String terminal_id; 
    private String terminal_name;
    private String location;
    private String brand;
    private String status;
    private String terminal_addr;
    private String branch_id;
    private String branch;

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    
    
}
