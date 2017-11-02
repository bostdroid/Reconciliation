/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.task.persistence;

import com.activedge.atm.task.data.TaskData;
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
public class TaskDAO  extends BaseDAO{
 
/**
     * creates  Task Data
     * @param  task - the task data to create
     * @return  TaskData - created Task Data
     * @throws SQLException - if a database error occurs 
     */
    public TaskData createTask(TaskData task) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_task values (?,?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         id = this.findNextPtid("ATM_TASK");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, task.getCode());
            stmt.setString(3, task.getDescription());
            stmt.setString(4, task.getModule());
             
            task.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating task " + task.getId() + " error msg " + ex.getMessage());
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
     return task;
    }
    /**
     * updates Task Data
     * @param task - the update task
     * @return TaskData the updated Task
     * @throws SQLException  - error if any
     */
    public TaskData updateTask(TaskData task) throws SQLException {
        


     String sql = "update atm_task set code = ?, description = ?, module = ? where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, task.getCode());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getModule());
            stmt.setLong(4, task.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating task " + task.getId() + " error msg " + ex.getMessage());
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
     return task;
    }  
    /**
     * delete a  Task Data
     * @param task
     * @return
     * @throws Exception 
     */
    public TaskData deleteTask(TaskData task) throws Exception {
        
        
     String sql = "delete from atm_task where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, task.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_task " + task.getId() + " error msg " + ex.getMessage());
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
     return task;
    } 
    /**
     * creates Task Data
     * @param ptask
     * @return
     * @throws Exception 
     */
    public TaskData viewTask(TaskData ptask) throws Exception {
        
        TaskData task = new TaskData();
     String sql = "select * from  atm_task where id = ?   ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, ptask.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                
                task.setCode(rs.getString("code"));
                task.setDescription(rs.getString("description"));
                task.setModule(rs.getString("module"));
                task.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating task " + task.getId() + " error msg " + ex.getMessage());
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
     return task;
    } 
    /**
     * finds All Task Data
     * @return
     * @throws Exception 
     */
    public List findAllTasks() throws SQLException {
        List tasks = new ArrayList();
         
     String sql = "select * from atm_task ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                TaskData task = new TaskData();
                task.setId(rs.getLong("id"));
                task.setCode(rs.getString("code"));
                task.setDescription(rs.getString("description"));
                task.setModule(rs.getString("module"));           
                tasks.add(task);
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
     return tasks;
    }   
    
    
    
    /**
     * finds Task Data
     * @return
     * @throws Exception 
     */
    public List findAllTasks(long roleId) throws SQLException {
        List tasks = new ArrayList();
         
String sql = "select * from  atm_task where code not in (select task_code from atm_roletask where role_id = " + roleId + ")";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                TaskData task = new TaskData();
                task.setCode(rs.getString("code"));
                task.setDescription(rs.getString("description"));
                task.setModule(rs.getString("module"));
                System.out.println("task" + task.getCode());
                tasks.add(task);
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
     return tasks;
    } 
    /**
     * Search for TaskByCriteria
     * @return
     * @throws Exception 
     */
    public List findTasksByCriteria(TaskData searchCriteria) throws SQLException {
        List tasks = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_branch a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from atm_task";
  
   String sSQLWhere = "";
   if (searchCriteria.getCode()!= null &&  searchCriteria.getCode().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " code = ? ");
   }
   if (searchCriteria.getDescription()!= null &&  searchCriteria.getDescription().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " description = ? ");
   }
   if (searchCriteria.getModule()!= null &&  searchCriteria.getModule().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " module = ? ");
   } 
    
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getCode()!= null &&  searchCriteria.getCode().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getCode());
   }
   if (searchCriteria.getDescription()!= null &&  searchCriteria.getDescription().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getDescription());
   }
   if (searchCriteria.getModule()!= null &&  searchCriteria.getModule().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getModule());
   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                TaskData task = new TaskData();
                task.setId(rs.getLong("id"));
                
                task.setCode(rs.getString("code"));
                task.setDescription(rs.getString("description"));
                task.setModule(rs.getString("module"));
                System.out.println("task " + task.getCode());
                
                
                tasks.add(task);
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
     return tasks;
    } 
}
