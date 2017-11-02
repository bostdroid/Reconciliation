/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.task.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author TechDev
 */
public class TaskData extends BaseData {
    
    private String code;
    private String description;
    private String module;
    private String listDescription;

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
     * @return the listDescription
     */
    public String getListDescription() {
        return code + " - " + description;
    }

    /**
     * @param listDescription the listDescription to set
     */
    public void setListDescription(String listDescription) {
        this.listDescription = listDescription;
    }
}
