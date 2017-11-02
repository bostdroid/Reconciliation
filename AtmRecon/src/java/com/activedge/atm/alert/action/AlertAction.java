/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.alert.action;

import com.activedge.atm.alert.persistence.AlertDAO;
import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;
/**
 *
 * @author Efe Akpofure
 */
public class AlertAction extends BaseAction{

    /**
     * alert entity data
     */
    private AlertData alert;
    
    /**
     * list of alerts entity data
     */
    private List alerts;
    
    
    /**
     * @return the alerts
     */
    public List getAlerts() {
        return alerts;
    }

    /**
     * @param alerts the alerts to set
     */
    public void setAlerts(List alerts) {
        this.alerts = alerts;
    }
    
    

    /**
     * @return the alert
     */
    public AlertData getAlert() {
        return alert;
    }

    /**
     * @param alert the alert to set
     */
    public void setAlert(AlertData alert) {
        this.alert = alert;
    }
    
     public String execute() {
        
        return "success";
    }
        
    public String access() {
        
        return "success";
    }
        
        
        
        
    /**
     * creates Alert Data
     * @return
     * @throws Exception 
     */
    public String createAlert() throws Exception {
        AlertDAO dao = new AlertDAO();
        AlertData data = dao.createAlert(getAlert());
        List alertList = dao.findAllAlerts();
        setAlert(data);
        setAlerts(alertList);
        
        return SUCCESS;
    }
    
    
    /**
     * creates Alert Data
     * @return
     * @throws Exception 
     */
    public String updateAlert() throws Exception {
        AlertDAO dao = new AlertDAO();
        AlertData data = dao.updateAlert(getAlert());
        List alertsList = dao.findAllAlerts();
        setAlert(data);
        setAlerts(alertsList);        
        
        return "success";
    }  
    
    /**
     * creates Alert Data
     * @return
     * @throws Exception 
     */
    public String deleteAlert() throws Exception {
        AlertDAO dao = new AlertDAO();
        AlertData data = dao.deleteAlert(getAlert());
        List alertsList = dao.findAllAlerts();
        setAlert(data);
        setAlerts(alertsList);        
        
        return "success";
    } 
    
    /**
     * creates Alert Data
     * @return
     * @throws Exception 
     */
    public String viewAlert() throws Exception {
        AlertDAO dao = new AlertDAO();
        AlertData data = dao.viewAlert(getAlert());
        List alertList = dao.findAllAlerts();
        setAlert(data);
        setAlerts(alertList); 

        return SUCCESS;
    }   
    
    /**
     * returns all Alert Data
     * @return
     * @throws Exception 
     */
    public String findAllAlerts() throws Exception {
        AlertDAO dao = new AlertDAO();
        List alertList = dao.findAllAlerts();
        setAlerts(alertList);         
        
        return SUCCESS;
    } 
    
    /**
     * searches Alert Data
     * @return
     * @throws Exception 
     */
    public String findAlertsByCriteria() throws Exception {
        AlertDAO dao = new AlertDAO();
        List alertList = dao.findAlertsByCriteria(getAlert()); 
        setAlerts(alertList);         
        
        return SUCCESS;
    } 
    
}
