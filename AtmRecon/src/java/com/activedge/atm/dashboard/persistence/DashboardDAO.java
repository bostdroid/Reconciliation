/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.dashboard.persistence;

import com.activedge.atm.dashboard.Data.DashboardData;
import com.activedge.atm.journalviewer.data.JournalViewerData;
import com.activedge.atm.reportportal.data.ReportPortalData;
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
 * @author TechDev
 */
public class DashboardDAO extends BaseDAO{
    
public List findAllTransactions() throws SQLException {

        List viewers = new ArrayList();
     String sql = "select * from EJ_DB ";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//                System.out.println("total journals "+viewers.size());
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all journals error msg " + ex.getMessage());
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
     return viewers;
    }  

    
public List findTransactionsByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "SELECT * FROM EJ_DB ";
             
  
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPan());
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStan());
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getRrn());
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDate());
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

public List findDispenseByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "SELECT * FROM EJ_DB WHERE TERMINALID=(SELECT max(TERMINALID) FROM EJ_DB )";
     
            
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPan());
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStan());
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getRrn());
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDate());
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

   /**
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllDispenseByCriteria() throws SQLException{
        List viewers = new ArrayList();
     String sql = "SELECT * FROM EJ_DB WHERE TERMINALID=(SELECT max(TERMINALID) FROM EJ_DB )";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//                System.out.println("All journals "+viewers.size());
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all journals error msg " + ex.getMessage());
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
     return viewers;
    } 

   /**
     * finds All DashboardViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllDashboardViewers() throws SQLException{
        List viewers = new ArrayList();
     String sql = "select TERMINALID, sum(AMOUNT) AS AMOUNT, COUNT(1) as tran_count  FROM EJ_DB where CASH_DISP_STATUS = 'WITHDRAW' \n" +
"GROUP BY TERMINALID";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
///
                viewer.setAmount(rs.getString("TRAN_COUNT"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//              viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
//                System.out.println("All journals "+viewers.size());
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all journals error msg " + ex.getMessage());
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
     return viewers;
    } 

   /**
     * finds All DispenseError Data
     * @return
     * @throws Exception 
     */
    
public List findDispenseErrorByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'NODISPENSE'";
//                 String sql = "select * from PTRX where STATUS = 'OL'";
            
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPan());
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStan());
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getRrn());
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDate());
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

   /**
     * finds All DispenseError Data
     * @return
     * @throws Exception 
     */
    
public List findSuccessByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'WITHDRAW'";
            
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPan());
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStan());
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getRrn());
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDate());
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

   /**
     * finds All Failed Data
     * @return
     * @throws Exception 
     */
    
public List findFailedByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'FAILED'";
            
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPan());
   }
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStatus());
   }
   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getStan());
   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getRrn());
   } 
   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDate());
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

   /**
     * finds All Chart Data
     * @return
     * @throws Exception 
     */
    
public List findChartByCriteria(DashboardData searchCriteria) throws SQLException{
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
//     String sql = "select TERMINALID, COUNT(*) FROM EJ_DB GROUP BY TERMINALID";
//     String sql = "select TERMINALID, AMOUNT, COUNT(*) FROM EJ_DB GROUP BY TERMINALID, AMOUNT";
       String sql = "select TERMINALID, AMOUNT FROM EJ_DB";    
        
   String sSQLWhere = "";
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINALID = ? ");
   }
//   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
//   }
//   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " CASH_DISPL_STATUS = ? ");
//   }
//   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
//   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
   } 
//   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
//   } 
//   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " QUERYDATE = ? ");
//   } 
//   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " EJ_TIME = ? ");
//   } 
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminalID()!= null &&  searchCriteria.getTerminalID().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminalID());
   }
//   if (searchCriteria.getPan()!= null &&  searchCriteria.getPan().trim().length() > 0)
//   {
//       stmt.setString(i++, searchCriteria.getPan());
//   }
//   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
//   {
//       stmt.setString(i++, searchCriteria.getStatus());
//   }
//   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
//   {
//       stmt.setString(i++, searchCriteria.getStan());
//   }
   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAmount());
   } 
//   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getRrn());
//   } 
//   if (searchCriteria.getDate()!= null &&  searchCriteria.getDate().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getDate());
//   } 
//   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getTime());
//   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                DashboardData viewer = new DashboardData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("QUERYDATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
//              viewer.setSqlDate(rs.getDate("EJ_DATE"));
                
//                if (viewer.getSqlDate()!= null){
//                    viewer.setDate(Util.getStringFromDate(viewer.getSqlDate()));
//                }  
               reports.add(viewer);
            }
                System.out.println("total transactions "+reports.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all transactions error msg " + ex.getMessage());
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
     return reports;
    }

 /**
     * finds All DispenseViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllDispenseViewers() throws SQLException{
        List viewers = new ArrayList();
     String sql = "SELECT TOP 5 TERMINAL, COUNT(1) AS TRAN_COUNT FROM PTRX GROUP BY TERMINAL ORDER BY TRAN_COUNT DESC ";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                ReportPortalData viewer = new ReportPortalData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminal(rs.getString("TERMINAL"));
///
                viewer.setDisplay(rs.getString("TRAN_COUNT"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//              viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
//                System.out.println("All journals "+viewers.size());
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all journals error msg " + ex.getMessage());
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
     return viewers;
    } 


public List findAllTranTypes() throws SQLException {

        List viewers = new ArrayList();
//     String sql = "select TERMINALID, TRAN_TYPE from EJ_DB order by TERMINALID ";
        String sql = "SELECT TRAN_TYPE, COUNT(1) AS TRAN_COUNT, TERMINALID FROM EJ_DB GROUP BY TRAN_TYPE, TERMINALID";
     

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                DashboardData viewer = new DashboardData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                
                viewer.setTime(rs.getString("TRAN_TYPE"));
                viewer.setDate(rs.getString("TRAN_COUNT"));
                
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }
            System.out.println("total journals "+viewers.size());

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all journals error msg " + ex.getMessage());
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
     return viewers;
    }

}

