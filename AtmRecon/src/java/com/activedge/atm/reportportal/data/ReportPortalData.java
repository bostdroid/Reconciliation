/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.reportportal.data;

import com.activedge.atm.web.common.BaseData;

/**
 *
 * @author TechDev
 */
public class ReportPortalData extends BaseData{
    private String terminal;
    private String source;
    private String display;
    private String cardNumber;
    private String accountNo;
    private String stan;
    private String amount;
    private String rrn;
    private String status;
    private String date;
    private String startDate;
    private String endDate;
    private String time;
    private java.sql.Date sqlDate;
    private java.sql.Date sqlStartDate;
    private java.sql.Date sqlEndDate;
    private String tabletitle;
    /**
     * @return the terminal
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal the terminal to set
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the display
     */
    public String getDisplay() {
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the sqlStartDate
     */
    public java.sql.Date getSqlStartDate() {
        return sqlStartDate;
    }

    /**
     * @param sqlStartDate the sqlStartDate to set
     */
    public void setSqlStartDate(java.sql.Date sqlStartDate) {
        this.sqlStartDate = sqlStartDate;
    }

    /**
     * @return the sqlEndDate
     */
    public java.sql.Date getSqlEndDate() {
        return sqlEndDate;
    }

    /**
     * @param sqlEndDate the sqlEndDate to set
     */
    public void setSqlEndDate(java.sql.Date sqlEndDate) {
        this.sqlEndDate = sqlEndDate;
    }

    /**
     * @return the tabletitle
     */
    public String getTabletitle() {
        return tabletitle;
    }

    /**
     * @param tabletitle the tabletitle to set
     */
    public void setTabletitle(String tabletitle) {
        this.tabletitle = tabletitle;
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
}
