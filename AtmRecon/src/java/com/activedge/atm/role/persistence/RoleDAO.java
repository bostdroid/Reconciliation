/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.role.persistence;

import com.activedge.atm.role.data.RoleData;
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
 * @author DELL
 */
public class RoleDAO extends BaseDAO {
    /**
     * creates  Role Data
     * @param  role - the role data to create
     * @return  RoleData - created Role Data
     * @throws SQLException - if a database error occurs 
     */
    public RoleData createRole(RoleData role) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_role values (?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         id = this.findNextPtid("ATM_ROLE");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, role.getCode());
            stmt.setString(3, role.getDescription());
           
            role.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating role " + role.getId() + " error msg " + ex.getMessage());
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
     return role;
    }
    /**
     * updates Role Data
     * @param role - the update role
     * @return RoleData the updated Role
     * @throws SQLException  - error if any
     */
    public RoleData updateRole(RoleData role) throws SQLException {
     String sql = "update atm_role set code = ?, description = ? where id = ? ";
                
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, role.getCode());
            stmt.setString(2, role.getDescription());
             
            stmt.setLong(3, role.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating role " + role.getId() + " error msg " + ex.getMessage());
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
     return role;
    }  
    /**
     * deletes a  Role Data
     * @param role
     * @return
     * @throws Exception 
     */
    public RoleData deleteRole(RoleData role) throws Exception {
        
        
     String sql = "delete from atm_role where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, role.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_role " + role.getId() + " error msg " + ex.getMessage());
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
     return role;
    } 
    /**
     * views Role Data
     * @param prole
     * @return
     * @throws Exception 
     */
    public RoleData viewRole(RoleData prole) throws Exception {
        
        RoleData role = new RoleData();
     String sql = "select * from  atm_role where id = ?   ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, prole.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                
                role.setCode(rs.getString("code"));
                role.setDescription(rs.getString("description"));
                 
                role.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error viewing role " + role.getId() + " error msg " + ex.getMessage());
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
     return role;
    } 
    /**
     * finds Role Data
     * @return
     * @throws Exception 
     */
    public List findAllRoles() throws SQLException {
        List roles = new ArrayList();
         
     String sql = "select * from  atm_role ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                RoleData role = new RoleData();
                role.setId(rs.getLong("id"));
                role.setCode(rs.getString("code"));
                role.setDescription(rs.getString("description"));
                
                roles.add(role);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all roles error msg " + ex.getMessage());
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
     return roles;
    }  
    
    /**
     * finds Role Data
     * @return
     * @throws Exception 
     */
    public List findAllRolesByID(Long roleId) throws SQLException {
        List roles = new ArrayList();
         
     String sql = "select code from  atm_role ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                RoleData role = new RoleData();
                role.setId(rs.getLong("id"));
                role.setCode(rs.getString("code"));
                role.setDescription(rs.getString("description"));
                
                roles.add(role);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all roles error msg " + ex.getMessage());
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
     return roles;
    } 
     
     /**
     * Search for All Asset Data
     * @return 
     * @throws java.sql.SQLException 
     */
    public List findRolesbyCriteria(RoleData searchCriteria) throws SQLException {
        List roles = new ArrayList();
         
     String sql = "select * from atm_role ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
   String sSQLWhere = "";
   if (searchCriteria.getRoleID()> 0)
   {   
            sSQLWhere = addWhereClause(sSQLWhere, " id = ? ");
   }
   if (searchCriteria.getCode()!= null &&  searchCriteria.getCode().trim().length() > 0)
   {
      // sSQLWhere += " asset_no = ? ";
       sSQLWhere = addWhereClause(sSQLWhere, " code = ? ");
   }
   if (searchCriteria.getDescription()!= null &&  searchCriteria.getDescription().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " description = ? ");
      // sSQLWhere += " name = ? ";
   } 
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getRoleID()> 0)
   {   
            stmt.setLong( i++, searchCriteria.getId());
   }
   if (searchCriteria.getCode()!= null &&  searchCriteria.getCode().trim().length() > 0)
   {
      // sSQLWhere += " asset_no = ? ";
       stmt.setString(i++, searchCriteria.getCode());
   }
   if (searchCriteria.getDescription()!= null &&  searchCriteria.getDescription().trim().length() > 0)
   {
    //   sSQLWhere = addWhereClause(sSQLWhere, " name = ? ");
        stmt.setString(i++, searchCriteria.getDescription());
      // sSQLWhere += " name = ? ";
   } 
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                RoleData role = new RoleData();
                role.setId(rs.getLong("id"));
                
                role.setCode(rs.getString("code"));
                role.setDescription(rs.getString("description"));
                roles.add(role);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all roles error msg " + ex.getMessage());
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
     return roles;
    }  

}
