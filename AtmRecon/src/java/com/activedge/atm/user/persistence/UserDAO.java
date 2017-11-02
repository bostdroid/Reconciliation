/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.user.persistence;

import com.activedge.atm.role.data.RoleData;
import com.activedge.atm.user.data.UserData;
import com.activedge.atm.util.Util;
import com.activedge.atm.web.common.BaseDAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Backup
 */
public class UserDAO extends BaseDAO {
    
    private String userID = null;
    /**
     * creates User Data
     * @param  user - the user data to create
     * @return  User Data - created User Data
     * @throws SQLException - if a database error occurs 
     */
    public UserData createUser(UserData user) throws SQLException 
    {
     long id = -1;
     String sql = "INSERT INTO ATM_USER VALUES (?,?,?,?,?,?,?,?,?,?,?)";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
         id = this.findNextPtid("ATM_USER");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setString(2, user.getLoginId());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmployeeNo());
            stmt.setLong(5, user.getRetries());
            stmt.setString(6, user.getLock());
            stmt.setDate(7, user.getLastActivityDate());
             
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss");
            java.sql.Date createDate = new java.sql.Date(new java.util.Date().getTime());
            sdf.format(createDate);
            stmt.setDate(8, createDate);
            stmt.setString(9, user.getBranch());
            stmt.setString(10, user.getStatus());
//            stmt.setBlob(11, user.getProfilePix());
//            FileInputStream inputStream = new FileInputStream(user.getImage());
//            stmt.setBinaryStream(11, inputStream);
            stmt.setLong(11, user.getRoleId());
//            stmt.setBlob(13, user.getProfilePix());
//            stmt.setDate(9, user.getCreateDate());
            
            
            
            
            
            
            user.setId(id);

            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error creating user " + user.getLoginId() + " error msg " + ex.getMessage());
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
     return user;
    }
        
     //
    
    
    /**
     * updates User Data
     * @param user - the update user
     * @return UserData the updated user
     * @throws SQLException  - error if any
     */
    public UserData updateUser(UserData user) throws SQLException {
        


     String sql = "UPDATE ATM_USER SET  status = ?, login_id = ?, login_pwd =?, employee_no = ?, retries = ?, "
               +  " user_lock =?, last_activity_date = ?, role_id = ?, create_date = ?, branch =?   where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getStatus());
            stmt.setString(2, user.getLoginId());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmployeeNo());
            stmt.setLong(5, user.getRetries());
            stmt.setString(6, user.getLock());
            stmt.setDate(7, user.getLastActivityDate());
            stmt.setString(8, user.getRole());
            stmt.setDate(9, user.getCreateDate());
            stmt.setString(10, user.getBranch());
            stmt.setLong(11, user.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating user " + user.getLoginId() + " error msg " + ex.getMessage());
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
     return user;
    }  
    
    /**
     * delete a  User Data
     * @return
     * @throws Exception 
     */
    public UserData deleteUser(UserData user) throws Exception {
        
        
     String sql = "DELETE ATM_USER where id = ? ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, user.getId());


            stmt.execute();
            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error deleting am_user " + user.getLoginId() + " error msg " + ex.getMessage());
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
     return user;
    } 
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public UserData viewUser(UserData puser) throws Exception {
        
        UserData user = new UserData();
     String sql = "SELECT * FROM  ATM_USER WHERE id = ?   ";
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, puser.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                user.setStatus(rs.getString("status"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("login_pwd"));
                user.setEmployeeNo(rs.getString("employee_no"));
                user.setRetries(rs.getInt("retries"));
                user.setLock(rs.getString("user_lock"));
                user.setLastActivityDate(rs.getDate("last_activity_date"));
                user.setRole(rs.getString("role_id"));
                user.setCreateDate(rs.getDate("create_date"));
                user.setBranch(rs.getString("branch"));
//                user.setProfilePix(rs.getBlob("profile_pix"));
//                OutputStream out = new FileOutputStream("profile_pix");
//                out.flush();
//                Blob blob = rs.getBlob("profile_pix");
//                ImageIcon imageIcon = new ImageIcon(
//                blob.getBytes(0, (int)blob.length());
//					out.close();
                user.setId(rs.getLong("id"));
            }



            stmt.close();



            conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error updating user " + user.getLoginId() + " error msg " + ex.getMessage());
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
     return user;
    }   
    
    /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public List findAllUsers() throws SQLException {
        List users = new ArrayList();
         
//     String sql = "SELECT * FROM  ATM_USER ";
        String sql = "select a.*, b.code as rolecode from ATM_USER a, ATM_ROLE b where a.role_id = b.id";
//        String sql = "select a.login_id, a.employee_no, a.create_date, a.status, b.code as rolecode from ATM_USER a, ATM_ROLE b  ";
     
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = getConnection();
System.out.println(sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                UserData user = new UserData();
                
                user.setId(rs.getLong("id")); 
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("login_pwd"));
                user.setEmployeeNo(rs.getString("employee_no"));
                user.setRetries(rs.getInt("retries"));
                user.setLock(rs.getString("user_lock"));
                user.setLastActivityDate(rs.getDate("last_activity_date"));
                if (user.getLastActivityDate() != null)
                    user.setStrLastActivityDate(Util.getStringFromDate(rs.getDate("last_activity_date")));
                user.setRole(rs.getString("rolecode"));
                user.setCreateDate(rs.getDate("create_date"));
                user.setBranch(rs.getString("branch"));
                
               user.setStatus(rs.getString("status")); 
//               System.out.println("findallusers count" + users.size());
               users.add(user);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all users error msg " + ex.getMessage());
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
     return users;
    }  
    
   /**
     * creates User Data
     * @return
     * @throws Exception 
     */
    public List findUserByCriteria(UserData usercriteria) throws SQLException {
        List users = new ArrayList();
         
     String sql = "SELECT * FROM  ATM_USER ";
     String sqlWhere = "";
     if (usercriteria.getLoginId() != null && usercriteria.getLoginId().trim().length() > 0)
         sqlWhere = addWhereClause(sqlWhere, " login_id = ? ");

     
      if (usercriteria.getPassword() != null && usercriteria.getPassword().trim().length() > 0)
        sqlWhere = addWhereClause(sqlWhere, " login_pwd = ? ");
      
     if (usercriteria.getEmployeeNo() != null && usercriteria.getEmployeeNo().trim().length() > 0)
         sqlWhere = addWhereClause(sqlWhere, " employee_no = ? ");
     
     if (usercriteria.getStatus() != null && usercriteria.getStatus().trim().length() > 0)
         sqlWhere = addWhereClause(sqlWhere, " status = ? ");      
      
      if (sqlWhere.trim().length() > 0)
          sql += " where " + sqlWhere;
         
   //  String updatesql = "update am_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
      
     try {
         conn = getConnection();
         System.out.println(" SQL " + sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            int paramcount = 1;
     if (usercriteria.getLoginId() != null && usercriteria.getLoginId().trim().length() > 0)
         stmt.setString(paramcount++, usercriteria.getLoginId()); 

     
      if (usercriteria.getPassword() != null && usercriteria.getPassword().trim().length() > 0)
        stmt.setString(paramcount++, usercriteria.getPassword());           
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                UserData user = new UserData();
                user.setId(rs.getLong("id"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("login_pwd"));
                user.setEmployeeNo(rs.getString("employee_no"));
                user.setRetries(rs.getInt("retries"));
                user.setLock(rs.getString("user_lock"));
                user.setLastActivityDate(rs.getDate("last_activity_date"));
                user.setCreateDate(rs.getDate("create_date"));
                user.setBranch(rs.getString("branch"));
                user.setRole(rs.getString("role_id"));
                
               user.setStatus(rs.getString("status")); 
               users.add(user);
            }


            rs.close();
            stmt.close();



           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all users error msg " + ex.getMessage());
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
     return users;
    }      
    
    
    public List findUsersByCriteria(UserData searchCriteria) throws SQLException {
        List users = new ArrayList();
         
     // String sql = "select a.*, b.name from am_employee a, am_asset b ";
     String sql = "SELECT * FROM  ATM_USERR ";
  
   String sSQLWhere = "";
   if (searchCriteria.getLoginId() != null &&  searchCriteria.getLoginId().trim().length() > 0)
   {   
       sSQLWhere = addWhereClause(sSQLWhere, " login_id = ? ");
   }
   if (searchCriteria.getPassword() != null &&  searchCriteria.getPassword().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " login_pwd = ? ");
   }
   if (searchCriteria.getEmployeeNo() != null &&  searchCriteria.getEmployeeNo().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " employee_no = ? ");
   } 
   if (searchCriteria.getRetries() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " retries = ? ");
   }  
   if (searchCriteria.getLock() != null &&  searchCriteria.getLock().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, "user_lock = ? ");
   } 
   if (searchCriteria.getLastActivityDate() != null)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " last_activity_date = ? ");
   } 
   if (searchCriteria.getRoleId() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " role_id = ? ");
   } 
   if (searchCriteria.getStatus() != null &&  searchCriteria.getStatus().trim().length() > 0)
   {
       sSQLWhere = addWhereClause(sSQLWhere, " status = ? ");
   } 
    
   if (sSQLWhere != null && sSQLWhere.trim().length()> 0)
     sql += " where " + sSQLWhere;
   System.out.println("SQL " + sql);
     Connection conn= null;
     try {
         conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i =1;
   if (searchCriteria.getLoginId() != null &&  searchCriteria.getLoginId().trim().length() > 0)
   {   
       stmt.setString( i++, searchCriteria.getLoginId());
   }
   if (searchCriteria.getPassword() != null &&  searchCriteria.getPassword().trim().length() > 0)
   {
       stmt.setString(i++, searchCriteria.getPassword());
   }
   if (searchCriteria.getEmployeeNo() != null &&  searchCriteria.getEmployeeNo().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getEmployeeNo());
   } 
   if (searchCriteria.getRetries() > 0)
   {
        stmt.setLong(i++, searchCriteria.getRetries());
   }
   if (searchCriteria.getLock() != null &&  searchCriteria.getLock().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getLock());
   }
   if (searchCriteria.getLastActivityDate() != null)
   {
        stmt.setDate(i++, searchCriteria.getLastActivityDate());
   }
   if (searchCriteria.getRoleId() > 0)
   {
        stmt.setLong(i++, searchCriteria.getRoleId());
   }
   if (searchCriteria.getStatus() != null &&  searchCriteria.getStatus().trim().length() > 0)
   {
        stmt.setString(i++, searchCriteria.getStatus());
   }
   
                  
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {              
                UserData user = new UserData();
                user.setId(rs.getLong("id"));
                user.setLoginId(rs.getString("login_id"));
                user.setPassword(rs.getString("login_pwd"));
                user.setEmployeeNo(rs.getString("employee_no"));
                user.setRetries(rs.getInt("retries"));
                user.setLock(rs.getString("user_lock"));
                user.setLastActivityDate(rs.getDate("last_activity_date"));
                user.setCreateDate(rs.getDate("create_date"));
                user.setBranch(rs.getString("branch"));
                
               user.setStatus(rs.getString("status")); 
               users.add(user);
            }
            rs.close();
            stmt.close();
           // conn.commit();
     }  catch (SQLException ex) {
         ex.printStackTrace();
         System.out.println("error finding all users error msg " + ex.getMessage());
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
     return users;
    }

    @Override
    protected String addWhereClause(String sqlWhere, String param) {
        if (sqlWhere.trim().length() > 0)
            sqlWhere += " AND ";
        sqlWhere += param;
        return sqlWhere;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
}
