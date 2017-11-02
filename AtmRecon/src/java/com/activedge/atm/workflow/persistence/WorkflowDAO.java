/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.workflow.persistence;

import com.activedge.atm.workflow.data.WorkflowData;
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
 * @author Activedge1
 */
public class WorkflowDAO extends BaseDAO{

/**
 *
 * @author DELL
 */

    /**
     * creates workflowData
     * @return
     * @throws Exception 
     */
    public WorkflowData createWorkflow(WorkflowData workflow) throws SQLException{
        long id = -1;
        Connection conn = null;
        String sql = "insert into ATM_WORKFLOW values (?,?,?,?,?,?,?,?)";
        
        try{
            conn = getConnection();
            id = this.findNextPtid("ATM_WORKFLOW");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, workflow.getFromUserID());
            stmt.setString(3, workflow.getToUserID());
            stmt.setString(4, workflow.getModule());
            stmt.setString(5, workflow.getModuleID());
            stmt.setString(6, workflow.getNextActivity());
            stmt.setString(7, workflow.getRemark());
            stmt.setString(8, workflow.getWorkflowStatus());
            workflow.setId(id);
            stmt.execute();
            stmt.close();
            
            conn.commit();
        }
         catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating workflow " + workflow.getId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     }
     return workflow;   
    }
    /**
     * updates workflowData
     * @return
     * @throws Exception 
     */
    public WorkflowData updatewWorkflow (WorkflowData workflow) throws SQLException{
        Connection conn = null;
        String sql = "update ATM_WORKFLOW set from_user_ID = ?, to_user_ID = ?, module = ?, module_ID = ?, next_activity = ?, remark = ?, workflow_status = ? "
                + " where id = ? ";
        try{
                conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, workflow.getFromUserID());
            stmt.setString(2, workflow.getToUserID());
            stmt.setString(3, workflow.getModule());
            stmt.setString(4, workflow.getModuleID());
            stmt.setString(5, workflow.getNextActivity());
            stmt.setString(6, workflow.getRemark());
            stmt.setString(7, workflow.getWorkflowStatus());
            
            stmt.setLong(8, workflow.getId());
            
                
                stmt.execute();
                stmt.close();
                        
                conn.commit();
            } catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating workflow " + workflow.getId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     }
        return workflow;
    }
    /**
     * deletes workflowData
     * @return
     * @throws Exception 
     */
    public WorkflowData deleteWorkflow (WorkflowData workflow) throws SQLException{
        
        String sql = "delete from ATM_WORKFLOW where id = ? ";
        Connection conn = null;
        try{
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, workflow.getId());
            
            stmt.execute();
            stmt.close();
            
            conn.commit();
        }
        catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_workflow " + workflow.getId() + " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     }
      return workflow;  
    }
    /**
     * views Workflow Data
     * @param pworkflow
     * @return
     * @throws Exception 
     */
    public WorkflowData viewWorkflow(WorkflowData pworkflow) throws Exception {
        
        WorkflowData workflow = new WorkflowData();
     //String sql = "select * from  ATM_WORKFLOW where id = ?   ";
     //String sql = "select * from  ATM_WORKFLOW LEFT JOIN atm_user ON ATM_WORKFLOW.from_user_ID=atm_user.id where id = ?  "; 
     String sql = "select a.*, b.login_id from ATM_WORKFLOW a, atm_user b where a.from_user_id = b.id and a.id = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, pworkflow.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {               
                workflow.setFromUserID(rs.getString("from_user_ID"));
                workflow.setName(rs.getString("login_id"));
                workflow.setToUserID(rs.getString("to_user_ID"));
                workflow.setModule(rs.getString("module"));
                workflow.setModuleID(rs.getString("module_ID"));
                workflow.setNextActivity(rs.getString("next_activity"));
                workflow.setRemark(rs.getString("remark"));
                workflow.setWorkflowStatus(rs.getString("workflow_Status"));
                workflow.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating workflow " + workflow.getId()+ " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     }
     return workflow;
    }   
    
   /**
     * finds All categories Data
     * @return
     * @throws Exception 
     */
    public List findAllWorkflows() throws SQLException {
        List workflows = new ArrayList();
         
     //String sql = "select * from ATM_WORKFLOW LEFT JOIN atm_user ON ATM_WORKFLOW.from_user_ID=atm_user.id";
     String sql = "select a.*, b.login_id from ATM_WORKFLOW a, atm_user b where a.from_user_id = b.id";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {   
                WorkflowData workflow = new WorkflowData();
                workflow.setId(rs.getLong("id"));
                workflow.setName(rs.getString("login_id"));
                workflow.setFromUserID(rs.getString("from_user_ID"));
                workflow.setToUserID(rs.getString("to_user_ID"));
                workflow.setModule(rs.getString("module"));
                workflow.setModuleID(rs.getString("module_ID"));
                workflow.setNextActivity(rs.getString("next_activity"));
                workflow.setRemark(rs.getString("remark"));
                workflow.setWorkflowStatus(rs.getString("workflow_Status"));
                
                workflows.add(workflow);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all workflows error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     }
     return workflows;
    }  
    
    
    public WorkflowData selectWorkflow(WorkflowData pworkflow) throws Exception {
        
        WorkflowData workflow = new WorkflowData();
     String sql = "select id, description from  ATM_WORKFLOW ORDER BY description ASC ";
   //  String updatesql = "update atm_asset set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, pworkflow.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                workflow.setFromUserID(rs.getString("from_user_ID"));
                workflow.setName(rs.getString("login_id"));
                workflow.setToUserID(rs.getString("to_user_ID"));
                workflow.setModule(rs.getString("module"));
                workflow.setModuleID(rs.getString("module_ID"));
                workflow.setNextActivity(rs.getString("next_activity"));
                workflow.setRemark(rs.getString("remark"));
                workflow.setWorkflowStatus(rs.getString("workflow_Status"));
                workflow.setId(rs.getLong("id"));               
            }
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error selecting workflow " + workflow.getId()+ " error msg " + ex.getMessage());
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw ex;
     }  catch (Exception ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         throw new SQLException(ex.getMessage());
     }  
     finally
     {
         this.releaseConnection(conn);
     return workflow;
    }
    }
    
    
    public List findWorkflowsByCriteria(WorkflowData searchCriteria) throws SQLException {
        List workflows = new ArrayList();
         
     //String sql = "select * from  ATM_WORKFLOW LEFT JOIN atm_user ON ATM_WORKFLOW.from_user_ID=atm_user.id";
    String sql = "select a.*, b.login_id from ATM_WORKFLOW a, atm_user b where a.from_user_id = b.id ";
   String sSQLWhere = "";
   if (searchCriteria.getFromUserID() != null &&  searchCriteria.getFromUserID().trim().length() > 0)
   {   
            sSQLWhere = addWhereClause(sSQLWhere, " from_user_id = ? ");
   }
   if (searchCriteria.getToUserID() != null &&  searchCriteria.getToUserID().trim().length() > 0)
   {
      // sSQLWhere += " workflow_no = ? ";
       sSQLWhere = addWhereClause(sSQLWhere, " to_user_id = ? ");
   }
   if (searchCriteria.getModule() != null &&  searchCriteria.getModule().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " module = ? ");
      // sSQLWhere += " name = ? ";
   } 
   if (searchCriteria.getModuleID() != null &&  searchCriteria.getModuleID().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " module_ID = ? ");
      // sSQLWhere += " name = ? ";
   }    
   if (searchCriteria.getNextActivity() != null &&  searchCriteria.getNextActivity().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " next_activity = ? ");
      // sSQLWhere += " name = ? ";
   }
   if (searchCriteria.getRemark() != null &&  searchCriteria.getRemark().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " remark = ? ");
      // sSQLWhere += " name = ? ";
   }
   if (searchCriteria.getWorkflowStatus() != null &&  searchCriteria.getWorkflowStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " workflow_status = ? ");
      // sSQLWhere += " name = ? ";
   }
   
   
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " and a." + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getFromUserID() != null &&  searchCriteria.getFromUserID().trim().length() > 0)
   {
      // sSQLWhere += " workflow_no = ? ";
       stmt.setString(i++, searchCriteria.getFromUserID());
   }
   if (searchCriteria.getToUserID() != null &&  searchCriteria.getToUserID().trim().length() > 0)
   {
      // sSQLWhere += " workflow_no = ? ";
       stmt.setString(i++, searchCriteria.getToUserID());
   }
   if (searchCriteria.getModule() != null &&  searchCriteria.getModule().trim().length() > 0)
   {
    //   sSQLWhere = addWhereClause(sSQLWhere, " name = ? ");
        stmt.setString(i++, searchCriteria.getModule());
      // sSQLWhere += " name = ? ";
   } 
   if (searchCriteria.getModuleID() != null &&  searchCriteria.getModuleID().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getModuleID());

   }    
   if (searchCriteria.getNextActivity() != null &&  searchCriteria.getNextActivity().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getNextActivity());

   } 
   if (searchCriteria.getRemark() != null &&  searchCriteria.getRemark().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getRemark());

   } 
   if (searchCriteria.getWorkflowStatus() != null &&  searchCriteria.getWorkflowStatus().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getWorkflowStatus());

   } 
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                WorkflowData workflow = new WorkflowData();
                workflow.setId(rs.getLong("id"));
                
                workflow.setFromUserID(rs.getString("from_user_id"));
                workflow.setName(rs.getString("login_id"));
                workflow.setToUserID(rs.getString("to_user_id"));
                workflow.setModule(rs.getString("module"));
                workflow.setModuleID(rs.getString("module_ID"));
                workflow.setNextActivity(rs.getString("next_activity"));
                workflow.setRemark(rs.getString("remark"));
                workflow.setWorkflowStatus(rs.getString("workflow_Status"));
                workflows.add(workflow);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all workflows error msg " + ex.getMessage());
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
     return workflows;
    }  
    
}