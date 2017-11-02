/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.branch.DAO;

import com.activedge.atm.branch.data.BranchData;
import com.activedge.atm.web.common.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechDev
 */
public class BranchDAO extends BaseDAO {
    
/**
     * creates  Branch Data
     * @param  branch - the branch data to create
     * @return  BranchData - created Branch Data
     * @throws SQLException - if a database error occurs 
     */
    public BranchData createBranch(BranchData branch) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_branch values (?,?,?,?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         id = this.findNextPtid("ATM_BRANCH");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, branch.getBranchName());
            stmt.setString(3, branch.getAddress());
            stmt.setString(4, branch.getBranchCode());
            stmt.setString(5, branch.getStatus());
//            stmt.setString(5, branch.getTerminalGroupID());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
            sdf.format(createDate);
            stmt.setDate(6, createDate);
            
             
            branch.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating branch " + branch.getId() + " error msg " + ex.getMessage());
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
     return branch;
    }
    /**
     * updates Branch Data
     * @param branch - the update branch
     * @return BranchData the updated Branch
     * @throws SQLException  - error if any
     */
    public BranchData updateBranch(BranchData branch) throws SQLException {
        


     String sql = "update atm_branch set name = ?, address = ?,  branch_code = ?, status = ?, create_date = ? "
               +  " where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, branch.getBranchName());
            stmt.setString(2, branch.getAddress());
            stmt.setString(3, branch.getBranchCode());
            stmt.setString(4, branch.getStatus());
//            stmt.setString(3, branch.getTerminalGroupID());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
            sdf.format(createDate);
            stmt.setDate(5, createDate);
            
            stmt.setLong(6, branch.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating branch " + branch.getId() + " error msg " + ex.getMessage());
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
     return branch;
    }  
    /**
     * delete a  Branch Data
     * @param branch
     * @return
     * @throws Exception 
     */
    public BranchData deleteBranch(BranchData branch) throws Exception {
        
        
     String sql = "delete from atm_branch where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, branch.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting am_branch " + branch.getId() + " error msg " + ex.getMessage());
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
     return branch;
    } 
    /**
     * creates Branch Data
     * @param pbranch
     * @return
     * @throws Exception 
     */
    public BranchData viewBranch(BranchData pbranch) throws Exception {
        
        BranchData branch = new BranchData();
     String sql = "select * from  atm_branch where id = ?   ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, pbranch.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                
                branch.setBranchName(rs.getString("name"));
                branch.setAddress(rs.getString("address"));
                branch.setBranchCode(rs.getString("branch_code"));
                branch.setStatus(rs.getString("status"));
//                branch.setTerminalGroupID(rs.getString("terminal_GroupID"));
                branch.setCreateDate(rs.getDate("create_date"));
                branch.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating branch " + branch.getId() + " error msg " + ex.getMessage());
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
     return branch;
    } 
    /**
     * creates Branch Data
     * @return
     * @throws Exception 
     */
    public List findAllBranches() throws SQLException {
        List branches = new ArrayList();
         
     String sql = "select * from  atm_branch ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                BranchData branch = new BranchData();
                branch.setId(rs.getLong("id"));
                branch.setBranchName(rs.getString("name"));
                branch.setAddress(rs.getString("address"));
                branch.setBranchCode(rs.getString("branch_code"));
                branch.setStatus(rs.getString("status"));
                branch.setCreateDate(rs.getDate("create_date"));              
                branches.add(branch);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all branches error msg " + ex.getMessage());
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
     return branches;
    }  
    /**
     * Search for BranchByCriteria
     * @return
     * @throws Exception 
     */
    public List findBranchesByCriteria(BranchData searchCriteria) throws SQLException {
        List branches = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_branch a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from atm_branch";
  
   String sSQLWhere = "";
   if (searchCriteria.getBranchName()!= null &&  searchCriteria.getBranchName().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " name = ? ");
   }
   if (searchCriteria.getBranchCode()!= null &&  searchCriteria.getBranchCode().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " branch_code = ? ");
   }
   if (searchCriteria.getAddress()!= null &&  searchCriteria.getAddress().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " address = ? ");
   } 
//   if (searchCriteria.getTerminalGroupID()!= null &&  searchCriteria.getTerminalGroupID().trim().length() > 0)
//   {
//       sSQLWhere = addWhereClause(sSQLWhere, " terminal_GroupID = ? ");
//   } 
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getBranchName()!= null &&  searchCriteria.getBranchName().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getBranchName());
   }
   if (searchCriteria.getBranchCode()!= null &&  searchCriteria.getBranchCode().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getBranchCode());
   }
   if (searchCriteria.getAddress()!= null &&  searchCriteria.getAddress().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getAddress());
   } 
//   if (searchCriteria.getTerminalGroupID()!= null &&  searchCriteria.getTerminalGroupID().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getTerminalGroupID());
//   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                BranchData branch = new BranchData();
                branch.setId(rs.getLong("id"));
                branch.setBranchName(rs.getString("name"));
                branch.setBranchCode(rs.getString("branch_code"));
                branch.setAddress(rs.getString("address"));
//                branch.setTerminalGroupID(rs.getString("terminal_GroupID"));
                branch.setCreateDate(rs.getDate("create_date"));
              //  retirement.setVersionId(rs.getInt("version"));

               branches.add(branch);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all branches error msg " + ex.getMessage());
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
     return branches;
    }  
}
