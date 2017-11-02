/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.agent.persistence;

import com.activedge.atm.agent.data.AgentData;
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
public class AgentDAO extends BaseDAO {
    
/**
     * creates  Agent Data
     * @param  agent - the agent data to create
     * @return  AgentData - created Agent Data
     * @throws SQLException - if a database error occurs 
     */
    public AgentData createAgent(AgentData agent) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_agent (id, terminal_id, terminal_name, location, brand, status, terminal_addr, branch_id)values (?,?,?,?,?,?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         id = this.findNextPtid("ATM_AGENT");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, agent.getTerminal_id());
            stmt.setString(3, agent.getTerminal_name());
            stmt.setString(4, agent.getLocation());
            stmt.setString(5, agent.getBrand());
            stmt.setString(6, agent.getStatus());
            stmt.setString(7, agent.getTerminal_addr());
            stmt.setString(8, agent.getBranch_id());
//            stmt.setString(5, branch.getTerminalGroupID());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
//            sdf.format(createDate);
//            stmt.setDate(5, createDate);
            
             
            agent.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating terminal " + agent.getId() + " error msg " + ex.getMessage());
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
     return agent;
    }
    /**
     * updates Branch Data
     * @param branch - the update branch
     * @return BranchData the updated Branch
     * @throws SQLException  - error if any
     */
    public AgentData updateAgent(AgentData agent) throws SQLException {
        


     String sql = "update atm_agent set terminal_id = ?, terminal_name = ?, location = ?, brand = ?, status = ?, terminal_addr = ?, branch_id = ? "
               +  " where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, agent.getTerminal_id());
            stmt.setString(2, agent.getTerminal_name());
            stmt.setString(3, agent.getLocation());
//            stmt.setString(3, branch.getTerminalGroupID());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
//            sdf.format(createDate);
            stmt.setString(4, agent.getBrand());
            stmt.setString(5, agent.getStatus());
            stmt.setString(6, agent.getTerminal_addr());
            stmt.setString(7, agent.getBranch_id());


            stmt.setLong(8, agent.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating terminal " + agent.getId() + " error msg " + ex.getMessage());
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
     return agent;
    }  
    /**
     * delete a  Branch Data
     * @param agent
     * @return
     * @throws Exception 
     */
    public AgentData deleteAgent(AgentData agent) throws Exception {
        
        
     String sql = "delete from atm_agent where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, agent.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_agent " + agent.getId() + " error msg " + ex.getMessage());
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
     return agent;
    } 
    /**
     * creates Agent Data
     * @param pagent
     * @return
     * @throws Exception 
     */
    public AgentData viewAgent(AgentData pagent) throws Exception {
        
        AgentData agent = new AgentData();
     String sql = "select * from  atm_branch where id = ?   ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, pagent.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                
                agent.setTerminal_id(rs.getString("terminal_id"));
                agent.setTerminal_name(rs.getString("terminal_name"));
                agent.setLocation(rs.getString("location"));
                agent.setBrand(rs.getString("brand"));
                agent.setStatus(rs.getString("status"));
                agent.setTerminal_addr(rs.getString("terminal_addr"));
//                branch.setTerminalGroupID(rs.getString("terminal_GroupID"));
                agent.setBranch_id(rs.getString("branch_id"));
                agent.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating terminal " + agent.getId() + " error msg " + ex.getMessage());
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
     return agent;
    } 
    /**
     * creates Agent Data
     * @return
     * @throws Exception 
     */
    public List findAllAgents() throws SQLException {
        List agents = new ArrayList();
         
     String sql = "select a.*, b.name as branchname from  atm_agent a, atm_branch b where a.branch_id = b.id ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                AgentData agent = new AgentData();
                agent.setId(rs.getLong("id"));
                agent.setTerminal_id(rs.getString("terminal_id"));
                agent.setTerminal_name(rs.getString("terminal_name"));
                agent.setLocation(rs.getString("location"));
                agent.setBrand(rs.getString("brand"));
                agent.setStatus(rs.getString("status"));
                agent.setTerminal_addr(rs.getString("terminal_addr"));
                agent.setBranch_id(rs.getString("branchname"));
//                branch.setTerminalGroupID(rs.getString("terminal_GroupID"));              
                agents.add(agent);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all terminals error msg " + ex.getMessage());
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
     return agents;
    }  
    /**
     * Search for AgentByCriteria
     * @return
     * @throws Exception 
     */
    public List findAgentsByCriteria(AgentData searchCriteria) throws SQLException {
        List agents = new ArrayList();
         
     // String sql = "select a.*, b.name from am_retirement a, am_asset b ";
     //String sql = "select a.* , b.name from  am_branch a, am_asset b  where a.asset_id = b.id ";
        String sql = "select * from atm_agent";
  
   String sSQLWhere = "";
   if (searchCriteria.getTerminal_id()!= null &&  searchCriteria.getTerminal_id().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " terminal_id = ? ");
   }
   if (searchCriteria.getTerminal_name()!= null &&  searchCriteria.getTerminal_name().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " terminal_name = ? ");
   }
   if (searchCriteria.getLocation()!= null &&  searchCriteria.getLocation().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " location = ? ");
   } 
   if (searchCriteria.getBrand()!= null &&  searchCriteria.getBrand().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " brand = ? ");
   } 
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " status = ? ");
   } 
   if (searchCriteria.getTerminal_addr()!= null &&  searchCriteria.getTerminal_addr().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " terminal_addr = ? ");
   }
   if (searchCriteria.getBranch_id()!= null &&  searchCriteria.getBranch_id().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " branch_id = ? ");
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
   if (searchCriteria.getTerminal_id()!= null &&  searchCriteria.getTerminal_id().trim().length() > 0)
   {   
            stmt.setString(i++, searchCriteria.getTerminal_id());
   }
   if (searchCriteria.getTerminal_name()!= null &&  searchCriteria.getTerminal_name().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getTerminal_name());
   }
   if (searchCriteria.getLocation()!= null &&  searchCriteria.getLocation().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getLocation());
   } 
   if (searchCriteria.getBrand()!= null &&  searchCriteria.getBrand().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getBrand());
   } 
   if (searchCriteria.getStatus()!= null &&  searchCriteria.getStatus().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getStatus());
   } 
   if (searchCriteria.getTerminal_addr()!= null &&  searchCriteria.getTerminal_addr().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getTerminal_addr());
   } 
   if (searchCriteria.getBranch_id()!= null &&  searchCriteria.getBranch_id().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getBranch_id());
   } 
//   if (searchCriteria.getTerminalGroupID()!= null &&  searchCriteria.getTerminalGroupID().trim().length() > 0)
//   {
//        stmt.setString(i++, searchCriteria.getTerminalGroupID());
//   } 
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
                AgentData agent = new AgentData();
                agent.setId(rs.getLong("id"));
                agent.setTerminal_id(rs.getString("terminal_id"));
                agent.setTerminal_name(rs.getString("terminal_name"));
                agent.setLocation(rs.getString("location"));
                agent.setBrand(rs.getString("brand"));
                agent.setStatus(rs.getString("status"));
                agent.setTerminal_addr(rs.getString("terminal_addr"));
                agent.setBranch_id(rs.getString("branch_id"));
//                branch.setTerminalGroupID(rs.getString("terminal_GroupID"));
//                branch.setCreateDate(rs.getDate("create_date"));
              //  retirement.setVersionId(rs.getInt("version"));

               agents.add(agent);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all terminals error msg " + ex.getMessage());
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
     return agents;
    }  
}

