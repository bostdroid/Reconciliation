/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.alert.persistence.AlertDAO;
import com.activedge.atm.message.data.MessageData;
import com.activedge.atm.message.persistence.MessageDAO;
import com.activedge.atm.workflow.data.WorkflowData;
import com.activedge.atm.workflow.persistence.WorkflowDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Efe Akpofure
 */
public class AppBusinessDelegate {
    
    AppBusinessDelegate instance = null;
    
    

    
        public static List findWorkflowsByCriteria(WorkflowData searchCriteria) throws SQLException {
            
            WorkflowDAO dao = new WorkflowDAO();
            return dao.findWorkflowsByCriteria(searchCriteria);
        }

        public static List findMessagesByCriteria(MessageData searchCriteria) throws SQLException {
            
            MessageDAO dao = new MessageDAO();
            return dao.findMessagesByCriteria(searchCriteria);
        }

         public static List findAlertByCriteria(AlertData searchCriteria) throws SQLException {
            
            AlertDAO dao = new AlertDAO();
            return dao.findAlertsByCriteria(searchCriteria);
        }
    
}
