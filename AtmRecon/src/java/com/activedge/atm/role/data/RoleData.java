/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.role.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author DELL
 */
public class RoleData extends BaseData {
   
    private Long roleID;
    private String code;
    private String description;
//    private String roleID;

    
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
     * @return the roleID
     */
    public Long getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }
}
