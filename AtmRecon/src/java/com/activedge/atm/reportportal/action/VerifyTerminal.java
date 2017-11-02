/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.reportportal.action;

import com.activedge.atm.file.data.FileData;
import com.activedge.atm.web.common.BaseDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechDev
 */
public class VerifyTerminal extends BaseDAO {
    
    private FileData verify;
    String terminalID;
    String journalDate;
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    /**
     * @return the date
     */
    public String getJournalDate() {
        return journalDate;
    }

    /**
     * @param journalDate the date to set
     */
    public void setJournalDate(String journalDate) {
        this.journalDate = journalDate;
    }
    public String execute(){
        return SUCCESS;
    }
    public String verifyterminal() throws SQLException{
         System.out.println("I am free");
        
//       if (getTerminalID() == null || getJournalDate() ==null){
//          
//          this.addFieldError("Field cannot be empty", ERROR);
//      }
//       else {
//           System.out.println("I am boolean");
//           boolean verified =  verifyLoad(verify.getJournalDate(), verify.getTerminalID());
//           if (!verified)
//               return INPUT;
//      }
        return SUCCESS;
    }
/**
 * the method to verify if a journal was loaded for that day
 * @param journalDate - date of transaction
 * @param terminalID - terminal id 
 * @return boolean  - true if it was loaded or vice versa
 * @throws SQLException - sql errors if any.
 */
    public boolean verifyLoad(String journalDate, String terminalID) throws SQLException {
        boolean verified = false;
        String date = journalDate;
        
        date = date.replaceAll("-", "");
        date = date.replaceAll("/", "");
        date = date.replaceAll("\\\\", "");
        
        String sql = "select * from VERIFYTERMINAL WHERE terminal_ID = ? AND verify_date = ? ";
//        MyConnectionPool cPool = new MyConnectionPool();
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerifyTerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Connection conn = cPool.getCon();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, terminalID);
        stmt.setString(2, date);
        System.out.println(date);
        ResultSet rs = stmt.executeQuery();
        if (rs.next())
        {
            verified = true;
            System.out.println("verify querry "+sql);
        }
       
        stmt.close();
        
        conn.close();
        return verified;
    }

    /**
     * @return the verify
     */
    public FileData getVerify() {
        return verify;
    }

    /**
     * @param verify the verify to set
     */
    public void setVerify(FileData verify) {
        this.verify = verify;
    }
}
