/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.reportportal.persistence;

//import com.activedge.atm.file.action.VerifyAction;
import com.activedge.atm.reportportal.data.ReportPortalData;
import com.activedge.atm.util.GenerateLogs;
import com.activedge.atm.web.common.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechDev
 */
public class ReportPortalDAO extends BaseDAO {
    
    ArrayList traveller = null;
    StringBuilder sb1 = new StringBuilder();
    String date1 = sb1.toString();
    private String terminalID;
    private String terminalError;
    StringBuilder querryBuilder;
    String querryToEx = "";
   /**
     * finds All JournalViewers Data
     * @return
     * @throws Exception 
     */
    public List findAllReportPortals() throws SQLException{
        List reports = new ArrayList();
         
     String sql = "select * from PTRX WHERE TRAN_DATE >=? AND TRAN_DATE <=?";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
//                System.out.println("where is d Driver?");
                
                ReportPortalData report = new ReportPortalData();
//                System.out.println("where is d Terminal?" +report.getTerminal());
                //report.setId(rs.getLong("id"));
                
                report.setTerminal(rs.getString("TERMINAL"));
                report.setSource(rs.getString("TRAN_SOURCE"));
                report.setDisplay(rs.getString("DISPLAY"));
                report.setCardNumber(rs.getString("PAN"));
                report.setAccountNo(rs.getString("ACCOUNTNO"));
                report.setStan(rs.getString("STAN"));
                report.setAmount(rs.getString("AMOUNT"));
                report.setRrn(rs.getString("RRN"));
                report.setStatus(rs.getString("STATUS"));
                report.setStartDate(rs.getString("TRAN_DATE"));
                report.setTime(rs.getString("TRAN_TIME"));
                
//               if (report.getDate()!= null)
                   // report.setSqlDate(Util.getDateFromString(report.getDate()));
               reports.add(report); 
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all reports error msg " + ex.getMessage());
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
     * Search for All Report Data
     * @return
     * @throws Exception 
     */
    public List findReportsByCriteria(ReportPortalData searchCriteria) throws SQLException {
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_asset a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from PTRX";
        
        System.out.println("criteria date "+searchCriteria.getStartDate());
        

        String startDate = searchCriteria.getStartDate();
        String newDate = "";
        if (startDate != null & startDate.length() > 9){
            String day = startDate.substring(8, 10);
            String month = startDate.substring(5, 7);
            String year = startDate.substring(0, 4);
            newDate = year+month+day;
            System.out.println("new date "+ newDate);
        }
        
        String endDate = searchCriteria.getEndDate();
        String newDate1= "";
        if (endDate!=null & endDate.length() > 9){
            String day = endDate.substring(8, 10);
            String month = endDate.substring(5, 7);
            String year = endDate.substring(0, 4);
            newDate1 = year+month+day;
            System.out.println("new date1 "+ newDate1);
        }

   String sSQLWhere = "";
   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
   {   
    //   sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = "+ searchCriteria.getTerminal());
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = ?");
   }
   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_SOURCE = ? ");
   }
   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " DISPLAY = ? ");
   } 
   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
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
   if (searchCriteria.getStatus()!= null && searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STATUS = ? ");
   }
//   if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 ))
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= "+newDate+" AND TRAN_DATE <= "+newDate1);
//   } 
   if ( searchCriteria.getStartDate()!=null && searchCriteria.getStartDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= ? ");
   } 
   if ( searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE <= ? ");
   }
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_TIME = ? ");
   } 
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
         
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTerminal());
   } 
   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getSource());
   }
   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDisplay());
   } 
   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getCardNumber());
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
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getStatus());
   } 
/*  if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0))
   {
        stmt.setString(i++, newDate);
   } */
   if (searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate);
   } 
   if (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate1);
   }
   
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 

          
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                ReportPortalData report = new ReportPortalData();

                
                report.setTerminal(rs.getString("TERMINAL"));
                System.out.println("where is d Report? " +report.getTerminal());
                report.setSource(rs.getString("TRAN_SOURCE"));
                report.setDisplay(rs.getString("DISPLAY"));
                report.setCardNumber(rs.getString("PAN"));
                report.setAccountNo(rs.getString("ACCOUNTNO"));
                report.setStan(rs.getString("STAN"));
                report.setAmount(rs.getString("AMOUNT"));
                report.setRrn(rs.getString("RRN"));
                report.setStatus(rs.getString("STATUS"));
                report.setStartDate(rs.getString("TRAN_DATE"));
                System.out.println("start date " +report.getStartDate());
//                report.setEndDate(rs.getString("TRAN_DATE"));
//                System.out.println("End date " +report.getEndDate());
                report.setTime(rs.getString("TRAN_TIME"));
//                report.setComment(rs.getString("COMMENT"));
                reports.add(report);
  

            }
            
//            else
//            {
//                VerifyTerminal action = new VerifyTerminal();
//                boolean verify = action.verifyLoad(searchCriteria.getStartDate(), searchCriteria.getTerminal());
//                if (verify!=true){
//                    System.out.println("Terminal " + searchCriteria.getTerminal()+ " has not been uploaded");
//
//
//                traveller.add(null);
//                traveller.add(null);
//                traveller.add(null);
//                traveller.add(null);
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
//                //String newreturnmessage = getTerminalID() + " has no records on " + date1;
//                String newreturnmessage = searchCriteria.getTerminal()+ " not uploaded in report on  " + searchCriteria.getStartDate();
//                try {
//                        java.util.Date showdate = sdf.parse(searchCriteria.getStartDate());
//
//                        String displaydate = sdf2.format(showdate);
//                        newreturnmessage = getTerminalID() + " not uploaded in report on  " + displaydate;
//                        System.out.println("testing....xxxxx");
//                    } catch (ParseException ex) {
//                        Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//                    }  
//                traveller.add(newreturnmessage);
//                }
//                else
//                {
//                traveller.add(null);
//                traveller.add(null);
//                traveller.add(null);
//                traveller.add(null);
//                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//                SimpleDateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy");
//                String returnmessage = "There are no errors for terminal "+getTerminalID() + " on" + date1;
//                System.out.println("testing....xx1xxx");
//                    try {
//                        java.util.Date showdate = df.parse(date1);
//
//                        String displaydate = df2.format(showdate);
//                        returnmessage = "<span style='color: blue'>   " + getTerminalID() + " has no exceptions on " + displaydate + " . Thanks</span>" ;
//                        System.out.println("testing....xxxxx");
//                    } catch (ParseException ex) {
//                        Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                //traveller.add(getTerminalID() + " has no records on " + date1);
//                    traveller.add(returnmessage);
//                }
//                terminalError=(querryBuilder.append(" (Terminal '"+ searchCriteria.getTerminal()+"' ) has not been uploaded between '"+ searchCriteria.getStartDate() +"' and '"+ searchCriteria.getEndDate() +"' ").toString());
//               querryToEx = querryBuilder.toString();
//               System.out.println(" querryToEx " + querryToEx);
//               
//            }  

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all reports error msg " + ex.getMessage());
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
     * Search for All Report Data
     * @return
     * @throws Exception 
     */
    public List findAllReportsByCriteria(ReportPortalData searchCriteria) throws SQLException {
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_asset a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from PTRX";
        
        System.out.println("criteria date "+searchCriteria.getStartDate());
        

        String startDate = searchCriteria.getStartDate();
        String newDate = "";
        if (startDate != null & startDate.length() > 9){
            String day = startDate.substring(8, 10);
            String month = startDate.substring(5, 7);
            String year = startDate.substring(0, 4);
            newDate = year+month+day;

        }
        
        String endDate = searchCriteria.getEndDate();
        String newDate1= "";
        if (endDate!=null & endDate.length() > 9){
            String day = endDate.substring(8, 10);
            String month = endDate.substring(5, 7);
            String year = endDate.substring(0, 4);
            newDate1 = year+month+day;

        }
        
//        String terminal = searchCriteria.getTerminal();
//        String newTerminal = "";
//        if (terminal=="ALL"){
//            newTerminal = terminal;
//            System.out.println("new terminal "+newTerminal);
//        }
   String sSQLWhere = "";
   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
   {   
    //   sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = "+ searchCriteria.getTerminal());
       sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = ?");
   }
   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_SOURCE = ? ");
   }
   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " DISPLAY = ? ");
   } 
   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
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
   if (searchCriteria.getStatus()!= null && searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " STATUS = ? ");
   }
//   if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 ))
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= "+newDate+" AND TRAN_DATE <= "+newDate1);
//   } 
   if ( searchCriteria.getStartDate()!=null && searchCriteria.getStartDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= ? ");
   } 
   if ( searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE <= ? ");
   }
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_TIME = ? ");
   } 
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTerminal());
   } 
   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getSource());
   }
   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getDisplay());
   } 
   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getCardNumber());
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
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getStatus());
   } 
/*  if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0))
   {
        stmt.setString(i++, newDate);
   } */
   if (searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate);
   } 
   if (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate1);
   }
   
   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTime());
   } 

          
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                ReportPortalData report = new ReportPortalData();

                
                report.setTerminal(rs.getString("TERMINAL"));
                System.out.println("where is d Report? " +report.getTerminal());
                report.setSource(rs.getString("TRAN_SOURCE"));
                report.setDisplay(rs.getString("DISPLAY"));
                report.setCardNumber(rs.getString("PAN"));
                report.setAccountNo(rs.getString("ACCOUNTNO"));
                report.setStan(rs.getString("STAN"));
                report.setAmount(rs.getString("AMOUNT"));
                report.setRrn(rs.getString("RRN"));
                report.setStatus(rs.getString("STATUS"));
                report.setStartDate(rs.getString("TRAN_DATE"));
                System.out.println("start date " +report.getStartDate());
//                report.setEndDate(rs.getString("TRAN_DATE"));
//                System.out.println("End date " +report.getEndDate());
                report.setTime(rs.getString("TRAN_TIME"));
                reports.add(report);
  
//                if (asset.getCreatesDate()!= null){
//                    asset.setCreateDate(Util.getDateFromString(asset.getCreatesDate()));
//                }
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all reports error msg " + ex.getMessage());
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
     * Search for All Report Data
     * @return
     * @throws Exception 
     */
    public List findReportsByDate(ReportPortalData searchCriteria) throws SQLException {
        List reports = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_asset a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from PTRX";
        
        System.out.println("criteria date "+searchCriteria.getStartDate());
        

        String startDate = searchCriteria.getStartDate();
        String newDate = "";
        if (startDate != null & startDate.length() > 9){
            String day = startDate.substring(8, 10);
            String month = startDate.substring(5, 7);
            String year = startDate.substring(0, 4);
            newDate = year+month+day;
            System.out.println("new date "+ newDate);
        }
        
        String endDate = searchCriteria.getEndDate();
        String newDate1= "";
        if (endDate!=null & endDate.length() > 9){
            String day = endDate.substring(8, 10);
            String month = endDate.substring(5, 7);
            String year = endDate.substring(0, 4);
            newDate1 = year+month+day;
            System.out.println("new date1 "+ newDate1);
        }

   String sSQLWhere = "";
//   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
//   {   
//    //   sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = "+ searchCriteria.getTerminal());
//       sSQLWhere = addWhereClause(sSQLWhere, " TERMINAL = ?");
//   }
//   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_SOURCE = ? ");
//   }
//   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " DISPLAY = ? ");
//   } 
//   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " PAN = ? ");
//   } 
//   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " STAN = ? ");
//   } 
//   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " AMOUNT = ? ");
//   } 
//   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " RRN = ? ");
//   } 
//   if (searchCriteria.getStatus()!= null && searchCriteria.getStatus().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " STATUS = ? ");
//   }
////   if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 ))
////   {
////       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= "+newDate+" AND TRAN_DATE <= "+newDate1);
////   } 
   if ( searchCriteria.getStartDate()!=null && searchCriteria.getStartDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE >= ? ");
   } 
   if ( searchCriteria.getEndDate()!=null && searchCriteria.getEndDate().trim().length() > 0 )
   {
       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_DATE <= ? ");
   }
//   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " TRAN_TIME = ? ");
//   } 
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
//   if (searchCriteria.getTerminal()!= null &&  searchCriteria.getTerminal().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getTerminal());
//   } 
//   if (searchCriteria.getSource()!= null &&  searchCriteria.getSource().trim().length() > 0)
//   {
//       stmt.setString(i++, searchCriteria.getSource());
//   }
//   if (searchCriteria.getDisplay()!= null &&  searchCriteria.getDisplay().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getDisplay());
//   } 
//   if (searchCriteria.getCardNumber()!= null &&  searchCriteria.getCardNumber().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getCardNumber());
//   } 
//   if (searchCriteria.getStan()!= null &&  searchCriteria.getStan().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getStan());
//   } 
//   if (searchCriteria.getAmount()!= null &&  searchCriteria.getAmount().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getAmount());
//   } 
//   if (searchCriteria.getRrn()!= null &&  searchCriteria.getRrn().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getRrn());
//   } 
//   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getStatus());
//   } 
/*  if ((searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0) && (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0))
   {
        stmt.setString(i++, newDate);
   } */
   if (searchCriteria.getStartDate()!= null && searchCriteria.getStartDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate);
   } 
   if (searchCriteria.getEndDate()!= null && searchCriteria.getEndDate().trim().length() > 0)
   {
        stmt.setString(i++, newDate1);
   }
   
//   if (searchCriteria.getTime()!= null &&  searchCriteria.getTime().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getTime());
//   } 

          
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                ReportPortalData report = new ReportPortalData();

                
                report.setTerminal(rs.getString("TERMINAL"));
                System.out.println("where is d Report? " +report.getTerminal());
                report.setSource(rs.getString("TRAN_SOURCE"));
                report.setDisplay(rs.getString("DISPLAY"));
                report.setCardNumber(rs.getString("PAN"));
                report.setAccountNo(rs.getString("ACCOUNTNO"));
                report.setStan(rs.getString("STAN"));
                report.setAmount(rs.getString("AMOUNT"));
                report.setRrn(rs.getString("RRN"));
                report.setStatus(rs.getString("STATUS"));
                report.setStartDate(rs.getString("TRAN_DATE"));
                System.out.println("start date " +report.getStartDate());
//                report.setEndDate(rs.getString("TRAN_DATE"));
//                System.out.println("End date " +report.getEndDate());
                report.setTime(rs.getString("TRAN_TIME"));
                reports.add(report);
  
//                if (asset.getCreatesDate()!= null){
//                    asset.setCreateDate(Util.getDateFromString(asset.getCreatesDate()));
//                }
            }
            GenerateLogs.writelogs("ReportByDate "+terminalID);

            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all reports error msg " + ex.getMessage());
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
     * finds All UnimpactedViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllUnimpactedTerminals() throws SQLException{
        List viewers = new ArrayList();
        String sql = "select TOP 5 TERMINAL, sum(CAST(AMOUNT AS NUMERIC)) AS AMOUNT, "
                + "COUNT(1) as tran_count FROM PTRX where DISPLAY = 'UNIMPACTED' GROUP BY TERMINAL ORDER BY TRAN_COUNT DESC ";
  

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                ReportPortalData viewer = new ReportPortalData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminal(rs.getString("TERMINAL"));
///
                viewer.setDisplay(rs.getString("TRAN_COUNT"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//              viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
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

 /**
     * finds All DispenseViewers Data
     * @return
     * @throws Exception 
     */
    
public List findAllHighestDispenseErrors() throws SQLException{
        List viewers = new ArrayList();
//     String sql = "select TOP 5 TERMINAL, sum(CAST(AMOUNT AS NUMERIC)) AS AMOUNT, "
//             + "COUNT(1) as tran_count FROM PTRX where DISPLAY = 'DISPENSE ERROR' GROUP BY TERMINAL ORDER BY TRAN_COUNT DESC ";
        String sql = "select TERMINAL as TERMINAL, COUNT(1) as tran_count FROM PTRX where "
            + "TRAN_DATE = (select max(TRAN_DATE) from ptrx) OR DISPLAY = 'Dispense Error'   "
            + "GROUP BY TERMINAL ORDER BY TRAN_COUNT DESC";

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int top = 0;
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                ReportPortalData viewer = new ReportPortalData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminal(rs.getString("TERMINAL"));
///
                viewer.setDisplay(rs.getString("TRAN_COUNT"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//              viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
                System.out.println("All journals "+viewers.size());
            /*   if (viewer.getDate()!= null)
                    viewer.setSqlDate(Util.getDateFromString(viewer.getDate())); */
               viewers.add(viewer); 
               top++;
               if (top==5){
                   break;
               }
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
     * finds All DispenseViewers Data
     * @return
     * @throws Exception 
     */
    
public List findBusiestTerminals() throws SQLException{
        List viewers = new ArrayList();
     String sql = "SELECT * FROM PTRX ";
// String sql =  "SELECT TERMINALID, COUNT(*) AS TRAN_COUNT FROM EJ_DB WHERE ROWNUM <=5 GROUP BY TERMINALID ORDER BY TRAN_COUNT";

     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println("where is d Driver?");
                ReportPortalData viewer = new ReportPortalData();
//                viewer.setId(rs.getLong("id"));
                
                viewer.setTerminal(rs.getString("TERMINAL"));
///
                viewer.setAmount(rs.getString("TRAN_COUNT"));
//                viewer.setStatus(rs.getString("CASH_DISP_STATUS"));
//              viewer.setRrn(rs.getString("RRN"));
//                viewer.setDate(rs.getString("EJ_DATE"));
//                viewer.setTime(rs.getString("EJ_TIME"));
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

    /**
     * @return the terminalID
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

}