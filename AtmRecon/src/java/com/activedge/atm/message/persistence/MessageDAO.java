/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.message.persistence;

import com.activedge.atm.message.data.MessageData;
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
 * the data access persistence layer for the Message entity
 * @since 01 Dec 2016
 */
public class MessageDAO extends BaseDAO {
    

    
    
    /**
     * creates Message Data
     * @param  message - the message data to create
     * @return  Message Data - created Message Data
     * @throws SQLException - if a database error occurs 
     */
    public MessageData createMessage(MessageData message) throws SQLException 
    {
     long id = -1;
     String sql = "insert into atm_message values (?,?,?,?,?,?)";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         //message.setSqlToUserId(Util.getDateFromString(message.getToUserId()));
         conn = getConnection();
         id = this.findNextPtid("ATM_MESSAGE");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, message.getFromUserId());
            stmt.setString(3, message.getToUserId());
           // stmt.setString(4, message.getSubject());
            stmt.setString(4, message.getMessage());
           // stmt.setDate(5, message.getSqlToUserId());
           // stmt.setLong(6, message.getVersionId());
            
            stmt.setString(5, message.getStatus());
            stmt.setDate(6, message.getCreateDate());
            message.setId(id);

            stmt.execute();
            stmt.close();
            

            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating message " + message.getFromUserId() + " error msg " + ex.getMessage());
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
     return message;
    }
        
     //
    
    
    /**
     * updates Message Data
     * @param message - the update message
     * @return MessageData the updated message
     * @throws SQLException  - error if any
     */
    public MessageData updateMessage(MessageData message) throws SQLException {
        


     String sql = "update ATM_MESSAGE set   from_user_id  = ?, to_user_id =?,  message = ?, status = ? ,"
               +  "create_date = ? where id = ? ";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         //message.setSqlToUserId(Util.getDateFromString(message.getToUserId()));
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, message.getFromUserId());
            stmt.setString(2, message.getToUserId());
           // stmt.setString(3, message.getSubject());
            stmt.setString(3, message.getMessage());
           // stmt.setDate(4, message.getSqlToUserId());
            stmt.setString(4, message.getStatus());
            stmt.setDate(5, message.getCreateDate());
            stmt.setLong(6, message.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating message " + message.getFromUserId() + " error msg " + ex.getMessage());
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
     return message;
    }  
    
    /**
     * delete a  Message Data
     * @return
     * @throws Exception 
     */
    public MessageData deleteMessage(MessageData message) throws Exception {
        
        
     String sql = "delete from atm_message where id = ? ";
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, message.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting atm_message " + message.getFromUserId() + " error msg " + ex.getMessage());
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
     return message;
    } 
    
    /**
     * creates Message Data
     * @return
     * @throws Exception 
     */
    public MessageData viewMessage(MessageData pmessage) throws Exception {
        
        MessageData message = new MessageData();
     //String sql = "select * from  atm_message LEFT JOIN atm_user ON atm_message.from_user_id=atm_user.id where id = ?   ";
     String sql = "select a.*, b.login_id from atm_message a, atm_user b where a.from_user_id = b.id and a.id = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, pmessage.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                message.setId(rs.getLong("id"));
                message.setName(rs.getString("login_id"));
                message.setFromUserId(rs.getString("from_user_id"));
                message.setToUserId(rs.getString("to_user_id"));
               // message.setSubject(rs.getString("subject"));
                message.setMessage(rs.getString("message"));
                //message.setSqlToUserId(rs.getDate("to_user_id"));
                message.setCreateDate(rs.getDate("create_date"));
              //  message.setVersionId(rs.getInt("version"));
                
               message.setStatus(rs.getString("status"));
            }
            
                
                 
               



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating message " + message.getFromUserId() + " error msg " + ex.getMessage());
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
     return message;
    }   
    
    /**
     * creates Message Data
     * @return
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public List findAllMessages() throws SQLException {
        List messages = new ArrayList();
         
     //String sql = "select * from  atm_message LEFT JOIN atm_user ON atm_message.from_user_id=atm_user.id";
     String sql = "select a.*, b.login_id from atm_message a, atm_user b where a.from_user_id = b.id";
     
   //  String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                MessageData message = new MessageData();
                message.setId(rs.getLong("id"));
                message.setName(rs.getString("login_id"));
                message.setFromUserId(rs.getString("from_user_id"));
                message.setToUserId(rs.getString("to_user_id"));
              //  message.setSubject(rs.getString("subject"));
                message.setMessage(rs.getString("message"));
               // message.setSqlToUserId(rs.getDate("to_user_id"));
                message.setCreateDate(rs.getDate("create_date"));
              //  message.setVersionId(rs.getInt("version"));
                
               message.setStatus(rs.getString("status")); 
               messages.add(message);
               
              // if (message.getSqlToUserId() != null)
               //     message.setToUserId(Util.getStringFromDate(message.getSqlToUserId()));
              // messages.add(message);
            }

                                                
            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all messages error msg " + ex.getMessage());
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
     return messages;
    }  
    
    
   
    
    
    public List findMessagesByCriteria(MessageData searchCriteria) throws SQLException {
        List messages = new ArrayList();
         
     //String sql = "select * from atm_message ";
     //String sql = "select * from  atm_message LEFT JOIN atm_user ON atm_message.from_user_id=atm_user.id";
     String sql = "select a.*, b.login_id from atm_message a, atm_user b where a.from_user_id = b.id ";
   String sSQLWhere = "";
   if (searchCriteria.getFromUserId() != null &&  searchCriteria.getFromUserId().trim().length() > 0)
   {   
            sSQLWhere = addWhereClause(sSQLWhere, " from_user_id = ? ");
   }
   if (searchCriteria.getToUserId() != null &&  searchCriteria.getToUserId().trim().length() > 0)
   {
      // sSQLWhere += " message_no = ? ";
       sSQLWhere = addWhereClause(sSQLWhere, " to_user_id = ? ");
   }
 /*  if (searchCriteria.getSubject() != null &&  searchCriteria.getSubject().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " subject = ? ");
      // sSQLWhere += " name = ? ";
   }   */
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
     sql += " AND a." + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getFromUserId() != null &&  searchCriteria.getFromUserId().trim().length() > 0)
   {
      // sSQLWhere += " message_no = ? ";
       stmt.setString(i++, searchCriteria.getFromUserId());
   }
   if (searchCriteria.getToUserId() != null &&  searchCriteria.getToUserId().trim().length() > 0)
   {
      // sSQLWhere += " message_no = ? ";
       stmt.setString(i++, searchCriteria.getToUserId());
   }
  /* if (searchCriteria.getSubject() != null &&  searchCriteria.getSubject().trim().length() > 0)
   {
    //   sSQLWhere = addWhereClause(sSQLWhere, " name = ? ");
        stmt.setString(i++, searchCriteria.getSubject());
      // sSQLWhere += " name = ? ";
   } */
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
                
                MessageData message = new MessageData();
                message.setId(rs.getLong("id"));
                message.setName(rs.getString("login_id"));
                message.setFromUserId(rs.getString("from_user_id"));
                message.setToUserId(rs.getString("to_user_id"));
               // message.setSubject(rs.getString("subject"));
                message.setMessage(rs.getString("message"));
                message.setStatus(rs.getString("status"));
                message.setCreateDate(rs.getDate("create_date"));
                messages.add(message);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all messages error msg " + ex.getMessage());
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
     return messages;
    }  

    
}
