/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.web.common;

import com.activedge.atm.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bost
 * Class to establish database connection and manage all database functionalities
 * 30 November, 2016
 */
public class BaseDAO {
 
 protected Connection getConnection() throws ClassNotFoundException, SQLException{
  
    
    //@returns a connection to the database 
     return ConnectionUtil.getInstance().getConnection();
 }
  protected Connection getEjConnection() throws ClassNotFoundException, SQLException{
  
    
    //@returns a connection to the database 
     return ConnectionUtil.getInstance().getEJConnection();
 }
   protected Connection getReportConnection() throws ClassNotFoundException, SQLException{
  
    
    //@returns a connection to the database 
     return ConnectionUtil.getInstance().getReportConnection();
 }
 
 protected void releaseConnection(Connection conn) throws SQLException{
     //String variable for the database driver
        ConnectionUtil.getInstance().releaseConnection(conn);

 } 
 //Check connection
 /**public static void main(String[] args) throws ClassNotFoundException, SQLException{
     getPreparedStatement("select*from branch");
 }
     * @param b
*/
 /**
  * the api to get the next id of a particular table
  * @param tableName - table name
  * @return long the next Id
  */
 protected long findNextPtid(String tableName)
 {
     long id = -1;
     String sql = "Select table_id from atm_entity where table_name = ?";
     String updatesql = "update atm_entity set table_id = (table_id + 1) where table_name = ?";
     Connection conn= null;
     try {
         conn = this.getConnection();
            PreparedStatement stmt = conn.prepareStatement(updatesql);
            stmt.setString(1, tableName);

            stmt.execute();
            stmt.close();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tableName);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                id = rs.getLong(1);
                id--;
            }
            rs.close();
            stmt.close();
            conn.commit();
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
     }  
     finally
     {
         try {
             this.releaseConnection(conn);
         } catch (SQLException ex) {
             Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     return id;
     
     
 }
 

 
    protected String addWhereClause(String sSQLWhere, String parameter) {
        if (sSQLWhere.trim().length() > 0)
        {
            sSQLWhere += " AND ";
        }
        sSQLWhere += parameter;

        return sSQLWhere;
    } 
}
