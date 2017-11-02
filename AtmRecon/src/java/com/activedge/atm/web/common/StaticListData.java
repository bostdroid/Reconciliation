/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

/**
 * The data object for all small lists
 * @author DELL
 * @since 21-feb -2017
 */
public class StaticListData extends BaseData {
    /**
     * small list code
     */
    
    private String smallCode;
        /**
     * small list description
     */
    
    private String smallDescription;

    /**
     * @return the smallCode
     */
    public String getSmallCode() {
        return smallCode;
    }

    /**
     * @param smallCode the smallCode to set
     */
    public void setSmallCode(String smallCode) {
        this.smallCode = smallCode;
    }

    /**
     * @return the smallDescription
     */
    public String getSmallDescription() {
        return smallDescription;
    }

    /**
     * @param smallDescription the smallDescription to set
     */
    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }
    
}
