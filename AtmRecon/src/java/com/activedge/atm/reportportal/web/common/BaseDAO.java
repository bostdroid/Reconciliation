

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.reportportal.web.common;

import com.activedge.atm.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

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
    protected String addWhereClause(String sSQLWhere, String parameter) {
        if (sSQLWhere.trim().length() > 0)
        {
            sSQLWhere += " AND ";
        }
        sSQLWhere += parameter;

        return sSQLWhere;
    } 
 
}