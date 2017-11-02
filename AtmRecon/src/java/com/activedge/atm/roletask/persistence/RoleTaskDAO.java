/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.roletask.persistence;

import com.activedge.atm.role.data.RoleData;
import com.activedge.atm.roletask.data.RoleTaskData;
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
 * @author Backup
 */
public class RoleTaskDAO extends BaseDAO {
    
    /**
     * creates  RActivity Data
     * @param roleactivity
     * @return  RActivityData - created RActivity Data
     * @throws SQLException - if a database error occurs 
     */
    public RoleData createRoleTask(RoleData roletask, String[]  assignedTask) throws SQLException 
    {
        System.out.println("@debug" + roletask);
       if (assignedTask == null)
           assignedTask = new String[0];
     long id = -1;
     String sql = "insert into atm_roletask values (?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         for (String task : assignedTask)
         {
              try {
         id = this.findNextPtid("ATM_ROLE_TASK");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setLong(2, roletask.getRoleID());
            stmt.setString(3, task);
           
            roletask.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
        }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating role task " + roletask.getId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         //throw ex;
       }
         }
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating role task " + roletask.getId() + " error msg " + ex.getMessage());
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
     return roletask;
    }
    
    public RoleTaskData createRRoleTask(RoleTaskData roletask, String[]  assignedTask) throws SQLException 
    {
        System.out.println("@debug" + roletask);
       if (assignedTask == null)
           assignedTask = new String[0];
     long id = -1;
     String sql = "insert into atm_roletask values (?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         for (String task : assignedTask)
         {
              try {
         id = this.findNextPtid("ATM_ROLE_TASK");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setLong(2, roletask.getRoleID());
            stmt.setString(3, task);
           
            roletask.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
        }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating role task " + roletask.getId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         //throw ex;
       }
         }
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating role task " + roletask.getId() + " error msg " + ex.getMessage());
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
     return roletask;
    }
    /**
     * updates Activity Data
     * @param roletask
     * @return ActivityData the updated activity
     * @throws SQLException  - error if any
     */
    public RoleTaskData updateRoleTask(RoleTaskData roletask) throws SQLException {
     String sql = "update atm_roletask set role_ID = ?, task_code = ? where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, roletask.getRoleID());
            stmt.setString(2, roletask.getTaskCode());
            stmt.setLong(3, roletask.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating role task " + roletask.getId() + " error msg " + ex.getMessage());
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
     return roletask;
    }  
   
    /**
     * delete a  activity Data
     * @param roletask
     * @return
     * @throws Exception 
     */
    public long deleteRoleTaskByRoleId(long roleId) throws Exception {
        
        
     String sql = "delete from atm_roletask where role_ID = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, roleId);


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_role_task role id " + roleId + " error msg " + ex.getMessage());
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
     return roleId;
    }   
    /**
     * delete a  activity Data
     * @param roletask
     * @return
     * @throws Exception 
     */
    public RoleTaskData deleteRoleTask(RoleTaskData roletask) throws Exception {
        
        
     String sql = "delete from atm_roletask where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, roletask.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_role_task " + roletask.getId() + " error msg " + ex.getMessage());
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
     return roletask;
    } 
    /**
     * views activity Data
     * @param ptask
     * @return
     * @throws Exception 
     */
    public RoleTaskData viewRoleTask(RoleTaskData ptask) throws Exception {
        
        RoleTaskData roletask = new RoleTaskData();
     String sql = "select * from  atm_roletask where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, ptask.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                
                roletask.setRoleID(rs.getInt("role_ID"));
                roletask.setTaskCode(rs.getString("task_code"));
                roletask.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error viewing role task " + roletask.getId() + " error msg " + ex.getMessage());
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
     return roletask;
    } 
    /**
     * finds AllActivity Data
     * @return
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public List findAllRoleTasks() throws SQLException {
        List roleTasks = new ArrayList();
         
     String sql = "select * from  atm_roletask  ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                RoleTaskData roletask = new RoleTaskData();
                roletask.setId(rs.getLong("id"));
                roletask.setRoleID(rs.getInt("role_ID"));
                roletask.setTaskCode(rs.getString("task_code"));
                
                roleTasks.add(roletask);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all tasks error msg " + ex.getMessage());
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
     return roleTasks;
    }  
    
   /**
     * finds AllActivity Data
     * @return
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public List findAllRoleTasks(long roleId) throws SQLException {
        List roleTasks = new ArrayList();
         
     String sql = "select a.*, b.description from  atm_roletask a, atm_task b  where a.task_code = b.code and role_ID =" + roleId;
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         System.out.println("SQL="  + sql);
//         System.out.println("role ID ");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                RoleTaskData roletask = new RoleTaskData();
                roletask.setId(rs.getLong("id"));
                roletask.setRoleID(rs.getInt("ROLE_ID"));
                
                roletask.setTaskCode(rs.getString("TASK_CODE"));     
                roletask.setDescription(rs.getString("DESCRIPTION")); 
                roleTasks.add(roletask);
                System.out.println("hfhhf" + roletask.getTaskCode());
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all tasks error msg " + ex.getMessage());
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
     return roleTasks;
    }      
   /**
     * finds AllActivity Data
     * @return
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public List findAllTasks(long roleId) throws SQLException {
        List roleTasks = new ArrayList();
         
     String sql = "select * from  atm_task  where task_code not in (select task_code from atm_roletask where role_id = " + roleId;
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                RoleTaskData roletask = new RoleTaskData();
                roletask.setTaskCode(rs.getString("task_code"));
                         
                roleTasks.add(roletask);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all tasks error msg " + ex.getMessage());
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
     return roleTasks;
    }  
}
