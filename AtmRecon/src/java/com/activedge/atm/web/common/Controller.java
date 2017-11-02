/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.web.common;

import com.activedge.atm.dashboard.persistence.DashboardDAO;
import com.activedge.atm.dashboard.Data.DashboardData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class Controller {
    
    Controller instance = null;
    
            public static List findTransactionsByCriteria(DashboardData searchCriteria) throws SQLException {
            
            DashboardDAO dao = new DashboardDAO();
            return dao.findTransactionsByCriteria(searchCriteria);
        }
            
            public static List findDispenseByCriteria(DashboardData searchCriteria) throws SQLException {
            
            DashboardDAO dao = new DashboardDAO();
            return dao.findDispenseByCriteria(searchCriteria);
        }
            
            public static List findDispenseErrorByCriteria(DashboardData searchCriteria) throws SQLException {
            
            DashboardDAO dao = new DashboardDAO();
            return dao.findDispenseErrorByCriteria(searchCriteria);
        }

            
            public static List findSuccessByCriteria(DashboardData searchCriteria) throws SQLException {
            
            DashboardDAO dao = new DashboardDAO();
            return dao.findSuccessByCriteria(searchCriteria);
        }
            
            
                    
            public static List findFailedByCriteria(DashboardData searchCriteria) throws SQLException {
            
            DashboardDAO dao = new DashboardDAO();
            return dao.findFailedByCriteria(searchCriteria);
        }
}
