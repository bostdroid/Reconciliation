/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author TechDEv
 */
public class ConnectionUtil {
    
    private static ConnectionUtil instance = null;
    private static Collection connections;
    
 public Connection getConnection() throws ClassNotFoundException, SQLException{
     //String variable for the database driver
   // String driver = "com.mysql.jdbc.Driver";
        ConfigProfile cfgProfile = ConfigurationUtil.getInstance().getProfile();
   // String driver = "oracle.jdbc.OracleDriver";
    String driver = cfgProfile.getDriver();
    //String variable for the database user
  //  String user="root";
    //String user="assetmgr";
    String user = cfgProfile.getUser();
    //String variable for the database password
  //  String password="";
   // String password="assetmgr";
    String password = cfgProfile.getPassword();
    //String variable for the database uri on the database server
   // String uri="jdbc:mysql://localhost:3306/asset_manager";
    String url = cfgProfile.getUrl();
    
    PreparedStatement ps=null;
    //Connecting to the driver
    Class.forName(driver);
    //Creating database access
    Connection conn = DriverManager.getConnection(url, user, password);
    conn.setAutoCommit(false);
    connections.add(conn);
    
    //@returns a connection to the database 
     return conn;
 }
 
 
  public Connection getEJConnection() throws ClassNotFoundException, SQLException{
     //String variable for the database driver
   // String driver = "com.mysql.jdbc.Driver";
        ConfigProfile cfgProfile = ConfigurationUtil.getInstance().getProfile();
   // String driver = "oracle.jdbc.OracleDriver";
    String ejdriver = cfgProfile.getEjDriver();
    //String variable for the database user
  //  String user="root";
    //String user="assetmgr";
    String ejuser = cfgProfile.getEjUser();
    //String variable for the database password
  //  String password="";
   // String password="assetmgr";
    String ejpassword = cfgProfile.getEjPassword();
    //String variable for the database uri on the database server
   // String uri="jdbc:mysql://localhost:3306/asset_manager";
    String ejurl = cfgProfile.getEjUrl();
    
    PreparedStatement ps=null;
      System.out.println("driver name "+ejdriver);
    //Connecting to the driver
    Class.forName(ejdriver);
    //Creating database access
    Connection conn = DriverManager.getConnection(ejurl, ejuser, ejpassword);
    conn.setAutoCommit(false);
    connections.add(conn);
    
    //@returns a connection to the database 
     return conn;
 }
    
    public Connection getReportConnection() throws ClassNotFoundException, SQLException{
     //String variable for the database driver
   // String driver = "com.mysql.jdbc.Driver";
        ConfigProfile cfgProfile = ConfigurationUtil.getInstance().getProfile();
   // String driver = "oracle.jdbc.OracleDriver";
    String reportdriver = cfgProfile.getReportDriver();
    //String variable for the database user
  //  String user="root";
    //String user="assetmgr";
    String reportuser = cfgProfile.getReportUser();
    //String variable for the database password
  //  String password="";
   // String password="assetmgr";
    String reportpassword = cfgProfile.getReportPassword();
    //String variable for the database uri on the database server
   // String uri="jdbc:mysql://localhost:3306/asset_manager";
    String reporturl = cfgProfile.getReportUrl();
    
    PreparedStatement ps=null;
    //Connecting to the driver
    Class.forName(reportdriver);
    //Creating database access
    Connection conn = DriverManager.getConnection(reporturl, reportuser, reportpassword);
    conn.setAutoCommit(false);
    connections.add(conn);
    
    //@returns a connection to the database 
     return conn;
 }
    
    private ConnectionUtil()
    {

        init();
    }

    private void init() {
        connections = new ArrayList();
        
    }
    
    public static ConnectionUtil getInstance()
    {
        
        if (instance == null)
        {
            instance = new ConnectionUtil();
        }        
        return instance;
    }
    
     public void releaseConnection(Connection conn) throws SQLException{
     //String variable for the database driver
        if (conn != null)
            conn.close();
    }    
}
