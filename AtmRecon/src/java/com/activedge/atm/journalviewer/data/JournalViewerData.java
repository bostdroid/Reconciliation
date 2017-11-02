/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.journalviewer.data;

import com.activedge.atm.web.common.BaseData;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author TechDev
 */
public class JournalViewerData extends BaseData{
    
    private String terminalID;
    private String pan;
    private String accountNo;
    private String stan;
    private String amount;
    private String rrn;
    private String date;
    private String time;
    private java.sql.Date sqlDate;
    private String status;
    private String comment;
    private String PAN;
    private String TRAN_TYPE;
    private String NOTES_STATUS;
    private String CARD_STATUS;
    private String MESSAGE;
    private String TRANSACTIONINFO;
    private String ATM_TYPE;
    private String AUTHID;
    private double AMOUNT_DISPLACED;
    private double AMOUNT_REJECTED;
    private double REMAININGAMOUNT;
    private String LOADINGDATE;
    private String QUERYDATE;
    private String NOTE_TYPES;
    private String NOTES_PRESENT;
    private String NOTES_DISPENSE;
    private String NOTES_REJECT;
    private String NOTES_REMAIN;
    private Date CREATE_DATE;
    private String STATUS;
    private String USER_COMMENT;
















    /**
     * @return the terminalID
     */
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
     * @return the pan
     */
    public String getPan() {
        return pan;
    }

    /**
     * @param pan the pan to set
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the stan
     */
    public String getStan() {
        return stan;
    }

    /**
     * @param stan the stan to set
     */
    public void setStan(String stan) {
        this.stan = stan;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the rrn
     */
    public String getRrn() {
        return rrn;
    }

    /**
     * @param rrn the rrn to set
     */
    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    /**
     * @return the date
     */
    public String getDate() {
        
     return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
//     String querydate = date;
//     String newdate = "";
//     if (querydate != null & querydate.length() > 9){
//     String day =querydate.substring(0, 2);
//      String mon =querydate.substring(3, 5);
//       String year =querydate.substring(6, 10);
//         newdate = year+mon+day;
        this.date = date;
     }
    

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the sqlDate
     */
    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    /**
     * @param sqlDate the sqlDate to set
     */
    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the PAN
     */
    public String getPAN() {
        return PAN;
    }

    /**
     * @param PAN the PAN to set
     */
    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    /**
     * @return the TRAN_TYPE
     */
    public String getTRAN_TYPE() {
        return TRAN_TYPE;
    }

    /**
     * @param TRAN_TYPE the TRAN_TYPE to set
     */
    public void setTRAN_TYPE(String TRAN_TYPE) {
        this.TRAN_TYPE = TRAN_TYPE;
    }

    /**
     * @return the NOTES_STATUS
     */
    public String getNOTES_STATUS() {
        return NOTES_STATUS;
    }

    /**
     * @param NOTES_STATUS the NOTES_STATUS to set
     */
    public void setNOTES_STATUS(String NOTES_STATUS) {
        this.NOTES_STATUS = NOTES_STATUS;
    }

    /**
     * @return the CARD_STATUS
     */
    public String getCARD_STATUS() {
        return CARD_STATUS;
    }

    /**
     * @param CARD_STATUS the CARD_STATUS to set
     */
    public void setCARD_STATUS(String CARD_STATUS) {
        this.CARD_STATUS = CARD_STATUS;
    }

    /**
     * @return the MESSAGE
     */
    public String getMESSAGE() {
        return MESSAGE;
    }

    /**
     * @param MESSAGE the MESSAGE to set
     */
    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    /**
     * @return the TRANSACTIONINFO
     */
    public String getTRANSACTIONINFO() {
        return TRANSACTIONINFO;
    }

    /**
     * @param TRANSACTIONINFO the TRANSACTIONINFO to set
     */
    public void setTRANSACTIONINFO(String TRANSACTIONINFO) {
        this.TRANSACTIONINFO = TRANSACTIONINFO;
    }

    /**
     * @return the ATM_TYPE
     */
    public String getATM_TYPE() {
        return ATM_TYPE;
    }

    /**
     * @param ATM_TYPE the ATM_TYPE to set
     */
    public void setATM_TYPE(String ATM_TYPE) {
        this.ATM_TYPE = ATM_TYPE;
    }

    /**
     * @return the AUTHID
     */
    public String getAUTHID() {
        return AUTHID;
    }

    /**
     * @param AUTHID the AUTHID to set
     */
    public void setAUTHID(String AUTHID) {
        this.AUTHID = AUTHID;
    }

    /**
     * @return the AMOUNT_DISPLACED
     */
    public double getAMOUNT_DISPLACED() {
        return AMOUNT_DISPLACED;
    }

    /**
     * @param AMOUNT_DISPLACED the AMOUNT_DISPLACED to set
     */
    public void setAMOUNT_DISPLACED(double AMOUNT_DISPLACED) {
        this.AMOUNT_DISPLACED = AMOUNT_DISPLACED;
    }

    /**
     * @return the AMOUNT_REJECTED
     */
    public double getAMOUNT_REJECTED() {
        return AMOUNT_REJECTED;
    }

    /**
     * @param AMOUNT_REJECTED the AMOUNT_REJECTED to set
     */
    public void setAMOUNT_REJECTED(double AMOUNT_REJECTED) {
        this.AMOUNT_REJECTED = AMOUNT_REJECTED;
    }

    /**
     * @return the REMAININGAMOUNT
     */
    public double getREMAININGAMOUNT() {
        return REMAININGAMOUNT;
    }

    /**
     * @param REMAININGAMOUNT the REMAININGAMOUNT to set
     */
    public void setREMAININGAMOUNT(double REMAININGAMOUNT) {
        this.REMAININGAMOUNT = REMAININGAMOUNT;
    }

    /**
     * @return the LOADINGDATE
     */
    public String getLOADINGDATE() {
        return LOADINGDATE;
    }

    /**
     * @param LOADINGDATE the LOADINGDATE to set
     */
    public void setLOADINGDATE(String LOADINGDATE) {
        this.LOADINGDATE = LOADINGDATE;
    }

    /**
     * @return the QUERYDATE
     */
    public String getQUERYDATE() {
        return QUERYDATE;
    }

    /**
     * @param QUERYDATE the QUERYDATE to set
     */
    public void setQUERYDATE(String QUERYDATE) {
        this.QUERYDATE = QUERYDATE;
    }

    /**
     * @return the NOTE_TYPES
     */
    public String getNOTE_TYPES() {
        return NOTE_TYPES;
    }

    /**
     * @param NOTE_TYPES the NOTE_TYPES to set
     */
    public void setNOTE_TYPES(String NOTE_TYPES) {
        this.NOTE_TYPES = NOTE_TYPES;
    }

    /**
     * @return the NOTES_PRESENT
     */
    public String getNOTES_PRESENT() {
        return NOTES_PRESENT;
    }

    /**
     * @param NOTES_PRESENT the NOTES_PRESENT to set
     */
    public void setNOTES_PRESENT(String NOTES_PRESENT) {
        this.NOTES_PRESENT = NOTES_PRESENT;
    }

    /**
     * @return the NOTES_DISPENSE
     */
    public String getNOTES_DISPENSE() {
        return NOTES_DISPENSE;
    }

    /**
     * @param NOTES_DISPENSE the NOTES_DISPENSE to set
     */
    public void setNOTES_DISPENSE(String NOTES_DISPENSE) {
        this.NOTES_DISPENSE = NOTES_DISPENSE;
    }

    /**
     * @return the NOTES_REJECT
     */
    public String getNOTES_REJECT() {
        return NOTES_REJECT;
    }

    /**
     * @param NOTES_REJECT the NOTES_REJECT to set
     */
    public void setNOTES_REJECT(String NOTES_REJECT) {
        this.NOTES_REJECT = NOTES_REJECT;
    }

    /**
     * @return the NOTES_REMAIN
     */
    public String getNOTES_REMAIN() {
        return NOTES_REMAIN;
    }

    /**
     * @param NOTES_REMAIN the NOTES_REMAIN to set
     */
    public void setNOTES_REMAIN(String NOTES_REMAIN) {
        this.NOTES_REMAIN = NOTES_REMAIN;
    }

    /**
     * @return the CREATE_DATE
     */
    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    /**
     * @param CREATE_DATE the CREATE_DATE to set
     */
    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    /**
     * @return the STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * @param STATUS the STATUS to set
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    /**
     * @return the USER_COMMENT
     */
    public String getUSER_COMMENT() {
        return USER_COMMENT;
    }

    /**
     * @param USER_COMMENT the USER_COMMENT to set
     */
    public void setUSER_COMMENT(String USER_COMMENT) {
        this.USER_COMMENT = USER_COMMENT;
    }
    


}
