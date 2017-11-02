/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.alert.persistence;

import com.activedge.atm.alert.data.AlertData;
import com.activedge.atm.util.Util;
import com.activedge.atm.web.common.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Efe Akpofure
 * the data access persistence layer for the Alert entity
 * @since 01 Dec 2016
 */
public class AlertDAO extends BaseDAO {
    

    
    
    /**
     * creates Alert Data
     * @param  alert - the alert data to create
     * @return  Alert Data - created Alert Data
     * @throws SQLException - if a database error occurs 
     */
    public AlertData createAlert(AlertData alert) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_alert values (?,?,?,?,?,?,?)";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         //alert.setSqlToUserId(Util.getDateFromString(alert.getToUserId()));
         conn = getConnection();
         id = this.findNextPtid("ATM_ALERT");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, alert.getFromUserId());
            stmt.setString(3, alert.getToUserId());
            stmt.setString(4, alert.getSubject());
            stmt.setString(5, alert.getMessage());
           // stmt.setDate(5, alert.getSqlToUserId());
           // stmt.setLong(6, alert.getVersionId());
            
            stmt.setString(6, alert.getStatus());
            stmt.setDate(7, alert.getCreateDate());
            alert.setId(id);

            stmt.execute();
            stmt.close();
            

            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating alert " + alert.getFromUserId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alert;
    }
        
     //
    
    
    /**
     * updates Alert Data
     * @param alert - the update alert
     * @return AlertData the updated alert
     * @throws SQLException  - error if any
     */
    public AlertData updateAlert(AlertData alert) throws SQLException {
        


     String sql = "update ATM_ALERT set   from_user_id  = ?, to_user_id =?, subject = ?, message = ?, status = ? ,"
               +  "create_date = ? where id = ? ";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         //alert.setSqlToUserId(Util.getDateFromString(alert.getToUserId()));
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, alert.getFromUserId());
            stmt.setString(2, alert.getToUserId());
            stmt.setString(3, alert.getSubject());
            stmt.setString(4, alert.getMessage());
           // stmt.setDate(4, alert.getSqlToUserId());
            stmt.setString(5, alert.getStatus());
            stmt.setDate(6, alert.getCreateDate());
            stmt.setLong(7, alert.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating alert " + alert.getFromUserId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alert;
    }  
    
    /**
     * delete a  Alert Data
     * @return
     * @throws Exception 
     */
    public AlertData deleteAlert(AlertData alert) throws Exception {
        
        
     String sql = "delete from atm_alert where id = ? ";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, alert.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_alert " + alert.getFromUserId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alert;
    } 
    
    /**
     * creates Alert Data
     * @return
     * @throws Exception 
     */
    public AlertData viewAlert(AlertData palert) throws Exception {
        
        AlertData alert = new AlertData();
     //String sql = "select * from  atm_alert LEFT JOIN atm_user ON atm_alert.from_user_id=atm_user.id where id = ?   ";
    String sql = "select a.*, b.login_id from atm_alert a, atm_user b where a.from_user_id = b.id and a.id = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, palert.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                alert.setId(rs.getLong("id"));
                alert.setName(rs.getString("login_id"));
                alert.setFromUserId(rs.getString("from_user_id"));
                alert.setToUserId(rs.getString("to_user_id"));
                alert.setSubject(rs.getString("subject"));
                alert.setMessage(rs.getString("message"));
                //alert.setSqlToUserId(rs.getDate("to_user_id"));
                alert.setCreateDate(rs.getDate("create_date"));
              //  alert.setVersionId(rs.getInt("version"));
                
               alert.setStatus(rs.getString("status"));
            }
            
                
                 
               



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating alert " + alert.getFromUserId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alert;
    }   
    
    /**
     * creates Alert Data
     * @return
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public List findAllAlerts() throws SQLException {
        List alerts = new ArrayList();
         
     //String sql = "select * from  atm_alert LEFT JOIN atm_user ON atm_alert.from_user_id=atm_user.id";
     String sql = "select a.*, b.login_id from atm_alert a, atm_user b where a.from_user_id = b.id ";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                AlertData alert = new AlertData();
                alert.setId(rs.getLong("id"));
                alert.setName(rs.getString("login_id"));
                alert.setFromUserId(rs.getString("from_user_id"));
                alert.setToUserId(rs.getString("to_user_id"));
                alert.setSubject(rs.getString("subject"));
                alert.setMessage(rs.getString("message"));
               // alert.setSqlToUserId(rs.getDate("to_user_id"));
                alert.setCreateDate(rs.getDate("create_date"));
              //  alert.setVersionId(rs.getInt("version"));
                
               alert.setStatus(rs.getString("status")); 
               alerts.add(alert);
               
              // if (alert.getSqlToUserId() != null)
               //     alert.setToUserId(Util.getStringFromDate(alert.getSqlToUserId()));
              // alerts.add(alert);
            }

                                                
            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all alerts error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alerts;
    }  
    
    
   
    
    
    public List findAlertsByCriteria(AlertData searchCriteria) throws SQLException {
        List alerts = new ArrayList();
         
     //String sql = "select * from  atm_alert LEFT JOIN atm_user ON atm_alert.from_user_id=atm_user.id";
   String sql = "select a.*, b.login_id from atm_alert a, atm_user b where a.from_user_id = b.id ";
   String sSQLWhere = "";
   if (searchCriteria.getFromUserId() != null &&  searchCriteria.getFromUserId().trim().length() > 0)
   {   
            sSQLWhere = addWhereClause(sSQLWhere, " from_user_id = ? ");
   }
   if (searchCriteria.getToUserId() != null &&  searchCriteria.getToUserId().trim().length() > 0)
   {
      // sSQLWhere += " alert_no = ? ";
       sSQLWhere = addWhereClause(sSQLWhere, " to_user_id = ? ");
   }
   if (searchCriteria.getSubject() != null &&  searchCriteria.getSubject().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " subject = ? ");
      // sSQLWhere += " name = ? ";
   } 
   if (searchCriteria.getMessage() != null &&  searchCriteria.getMessage().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " message = ? ");
      // sSQLWhere += " name = ? ";
   }    
   if (searchCriteria.getStatus() != null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " status = ? ");
      // sSQLWhere += " name = ? ";
   }
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " and a. " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getFromUserId() != null &&  searchCriteria.getFromUserId().trim().length() > 0)
   {
      // sSQLWhere += " alert_no = ? ";
       stmt.setString(i++, searchCriteria.getFromUserId());
   }
   if (searchCriteria.getToUserId() != null &&  searchCriteria.getToUserId().trim().length() > 0)
   {
      // sSQLWhere += " alert_no = ? ";
       stmt.setString(i++, searchCriteria.getToUserId());
   }
   if (searchCriteria.getSubject() != null &&  searchCriteria.getSubject().trim().length() > 0)
   {
    //   sSQLWhere = addWhereClause(sSQLWhere, " name = ? ");
        stmt.setString(i++, searchCriteria.getSubject());
      // sSQLWhere += " name = ? ";
   } 
   if (searchCriteria.getMessage() != null &&  searchCriteria.getMessage().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getMessage());

   }    
   if (searchCriteria.getStatus() != null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());

   } 
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                AlertData alert = new AlertData();
                alert.setId(rs.getLong("id"));
                alert.setName(rs.getString("login_id"));
                alert.setFromUserId(rs.getString("from_user_id"));
                alert.setToUserId(rs.getString("to_user_id"));
                alert.setSubject(rs.getString("subject"));
                alert.setMessage(rs.getString("message"));
                alert.setStatus(rs.getString("status"));
                alert.setCreateDate(rs.getDate("create_date"));
                alerts.add(alert);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all alerts error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return alerts;
    }  

    
}
