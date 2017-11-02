/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.journalviewer.DAO;

import com.activedge.atm.journalviewer.data.JournalViewerData;
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
public class JournalViewerDAO extends BaseDAO {
    
    
   /**
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllJournalViewers() throws SQLException{
        List viewers = new ArrayList();
     String sql = "select * from EJ_DB ";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));

            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }
                System.out.println("All journals "+viewers.size());

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


public List findJournalsByCriteria(JournalViewerData searchCriteria) throws SQLException {
        List viewers = new ArrayList();
         
     // String sql = "select a.*, b.name from am_acquisition a, am_asset b ";
     //String sql = "select a.* , b.name from  am_acquisition a, am_asset b  where a.asset_id = b.id";
     String sql = "SELECT * FROM EJ_DB ";
     System.out.println("EJ-Date "+searchCriteria.getDate());
     String querydate = searchCriteria.getDate();
     String newdate = "";
     if (querydate != null & querydate.length() > 9){
//     String day =querydate.substring(0, 2);
//      String mon =querydate.substring(3, 5);
//       String year =querydate.substring(6, 10);
       
/*       String year =querydate.substring(0, 4);
      String mon =querydate.substring(5, 7);
       String day =querydate.substring(8, 10);
         newdate = year+mon+day + "&000000";
*/      

        String day =querydate.substring(0, 2);
        String mon =querydate.substring(3, 5);
        String year =querydate.substring(8, 10);
        newdate = day+"/"+mon+"/"+year;

        System.out.println("EJ-Date "+newdate);
        
     }
  
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
      // sSQLWhere = addWhereClause(sSQLWhere, " EJ_DATE = ? ");
            sSQLWhere = addWhereClause(sSQLWhere, " EJ_DATE = ? ");
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
      //  stmt.setString(i++, searchCriteria.getDate());
         stmt.setString(i++, newdate);
   } 
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                viewer.setTerminalID(rs.getString("TERMINALID"));
                System.out.println("terminal "+viewer.getTerminalID());
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                if(viewer.getDate()!=null){
                    viewer.setDate(newdate.substring(0, 8));
                }
                viewer.setTime(rs.getString("EJ_TIME"));
 
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

   /**
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllSuccessfulTrans() throws SQLException{
        List viewers = new ArrayList();
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'WITHDRAW'";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));

            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }
                System.out.println("All journals "+viewers.size());

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


public List findAllDispenseErrors() throws SQLException {

        List viewers = new ArrayList();
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'NODISPENSE'";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
                System.out.println("total journals "+viewers.size());
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
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllFailedTrans() throws SQLException{
        List viewers = new ArrayList();
     String sql = "select * from EJ_DB where CASH_DISP_STATUS = 'FAILED'";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));

            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
            }
                System.out.println("All journals "+viewers.size());

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
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllBusiestTerminal() throws SQLException{
        List viewers = new ArrayList();
     String sql = "SELECT * FROM EJ_DB WHERE TERMINALID=(SELECT max(TERMINALID) FROM EJ_DB )";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
                viewer.setPan(rs.getString("PAN"));
                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
                viewer.setRrn(rs.getString("RRN"));
                viewer.setDate(rs.getString("EJ_DATE"));
                viewer.setTime(rs.getString("EJ_TIME"));
                System.out.println("All journals "+viewers.size());
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

public List findAllDashboardViewers() throws SQLException{
        List viewers = new ArrayList();
//     String sql = "SELECT DISTINCT TERMINALID FROM EJ_DB WHERE TERMINALID=(SELECT max(TERMINALID) FROM EJ_DB )";
        String sql = "select TERMINALID, AMOUNT, COUNT(*) FROM EJ_DB GROUP BY TERMINALID, AMOUNT";
//        String sql = " select * FROM EJ_DB ";

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                JournalViewerData viewer = new JournalViewerData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminalID(rs.getString("TERMINALID"));
//                viewer.setStatus(rs.getString("COUNT(TERMINALID)"));
//                viewer.setPan(rs.getString("PAN"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//                viewer.setStan(rs.getString("STAN"));
                viewer.setAmount(rs.getString("AMOUNT"));
////              viewer.setRrn(rs.getString("RRN"));
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
     * creates Comment Data
     * @param  comment - the alert data to create
     * @return  Alert Data - created Alert Data
     * @throws SQLException - if a database error occurs 
     */
//    public JournalViewerData createComment(JournalViewerData comment) throws SQLException 
//    {
//     long id = -1;
//     String sql = "insert into EJ_DB values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
//     Connection conn= null;
//     try {
//         //alert.setSqlToUserId(Util.getDateFromString(alert.getToUserId()));
//         conn = getConnection();
//         id = this.findNextPtid("EJ_DB");
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setLong(1, id);
//            stmt.setString(2, comment.getDate());
//            stmt.setString(3, comment.getTime());
//            stmt.setString(4, comment.getTerminalID());
//            stmt.setString(5, comment.getAccountNo());
//            stmt.setString(6, comment.getRrn());
//            stmt.setString(7, comment.getStan());
//            stmt.setString(8, comment.getPAN());
//            stmt.setString(9, comment.getTRAN_TYPE());
//            stmt.setString(10, comment.getAmount());
//            stmt.setString(11, comment.getNOTES_STATUS());
//            stmt.setString(12, comment.getCARD_STATUS());
//            stmt.setString(13, comment.getMESSAGE());
//            stmt.setString(14, comment.getTRANSACTIONINFO());
//            stmt.setString(15, comment.getATM_TYPE());
//            stmt.setString(16, comment.getAUTHID());
//            stmt.setString(17, comment.getSTATUS());
//            stmt.setDouble(18, comment.getAMOUNT_DISPLACED());
//            stmt.setDouble(19, comment.getAMOUNT_REJECTED());
//            stmt.setDouble(20, comment.getREMAININGAMOUNT());
//            stmt.setString(21, comment.getLOADINGDATE());
//            stmt.setString(22, comment.getQUERYDATE());
//            stmt.setString(23, comment.getNOTE_TYPES());
//            stmt.setString(24, comment.getNOTES_PRESENT());
//            stmt.setString(25, comment.getNOTES_DISPENSE());
//            stmt.setString(26, comment.getNOTES_REJECT());
//            stmt.setString(27, comment.getNOTES_REMAIN());
//            stmt.setDate(28, comment.getCREATE_DATE());
//            stmt.setString(29, comment.getSTATUS());
//            stmt.setString(30, comment.getComment());
//
//            comment.setId(id);
//
//
//
//
//            stmt.execute();
//            stmt.close();
//            
//
//            conn.commit();
//     }  catch (SQLException ex) {
//         ex.printStackTrace();
//         System.out.println("error creating comment " + comment.getComment()+ " error msg " + ex.getMessage());
//         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         throw ex;
//     }  catch (Exception ex) {
//         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         throw new SQLException(ex.getMessage());
//     }  
//     finally
//     {
//         try {
//             this.releaseConnection(conn);
//         } catch (SQLException ex) {
//             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
//     return comment;
//    }
//    
//   /**
//     * finds All Comments Data
//     * @return
//     * @throws Exception 
//     */
//    
//public List findAllComments() throws SQLException{
//        List viewers = new ArrayList();
//     String sql = "select * from EJ_DB ";
//  
//
//     Connection conn= null;
//     try {
//         conn = getConnection();
//
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next())
//            {
//                System.out.println("where is d Driver?");
//                JournalViewerData viewer = new JournalViewerData();
//                viewer.setId(rs.getLong("id"));
//                
//                viewer.setTerminalID(rs.getString("TERMINALID"));
//                viewer.setPan(rs.getString("PAN"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//                viewer.setStan(rs.getString("STAN"));
//                viewer.setAmount(rs.getString("AMOUNT"));
//                viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
//
//            /*   if (viewer.getDate()!= null)
//                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
//               viewers.add(viewer); 
//            }
//                System.out.println("All journals "+viewers.size());
//
//            rs.close();
//            stmt.close();
//
//
//
//           // conn.commit();
//     }  catch (SQLException ex) {
//         ex.printStackTrace();
//         System.out.println("error finding all journals error msg " + ex.getMessage());
//         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         throw ex;
//     }  catch (Exception ex) {
//         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         throw new SQLException(ex.getMessage());
//     }  
//     finally
//     {
//         try {
//             this.releaseConnection(conn);
//         } catch (SQLException ex) {
//             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
//     return viewers;
//    } 
}
