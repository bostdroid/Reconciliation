/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.util;

/**
 *
 * @author TechDEv
 * contains all the entries on the config file
 * @since 01 dec 2016
 */
public class ConfigProfile {
    /**
     * the place holder for database UrL
     */
    public static final String DB_URL = "db_url";
    /**
     * the place holder for database Driver
     */
    public static final String DB_DRIVER = "db_driver";
    /**
     * the place holder for database Password
     */
    public static final String DB_PASSWORD = "db_password";
    /**
     * the place holder for database User
     */
    public static final String DB_USER = "db_user";
        /**
     * the place holder for journal path 
     */
    private static String journalpath = "journalpath";
    /**
     * the place holder for database URL
     */
    public static final String DB_EJ_URL = "db_ej_url";
    /**
     * the place holder for database Driver
     */
    public static final String DB_EJ_DRIVER = "db_ej_driver";
    /**
     * the place holder for database Password
     */
    public static final String DB_EJ_PASSWORD = "db_ej_password";
    /**
     * the place holder for database User
     */
    public static final String DB_EJ_USER = "db_ej_user";
    /**
     * the place holder for database URL
     */
    public static final String DB_REPORT_URL = "db_report_url";
    /**
     * the place holder for database Driver
     */
    public static final String DB_REPORT_DRIVER = "db_report_driver";
    /**
     * the place holder for database Password
     */
    public static final String DB_REPORT_PASSWORD = "db_report_password";
        /**
     * the place holder for database User
     */
    public static final String DB_REPORT_USER = "db_report_user";       

    /**
     * @return the journalpath
     */
    public static String getJournalpath() {
        return journalpath;
    }

    /**
     * @param aJournalpath the journalpath to set
     */
    public static void setJournalpath(String aJournalpath) {
        journalpath = aJournalpath;
    }
    
    /**
     * the database UrL
     */
    private String url;
    /**
     * the database Driver
     */
    private String driver;
    /**
     * the database Password
     */
    private String password;
        /**
     * the database User
     */
    private String user;
   /**
     * the database ej UrL
     */
    private String ejUrl;
    /**
     * the  journal path
     */
    private String journal;
    /**
     * the database ej Driver
     */
    private String ejDriver;
    /**
     * the database ej Password
     */
    private String ejPassword;
        /**
     * the database ej User
     */
    private String ejUser;
    
   /**
     * the database report UrL
     */
    private String reportUrl;
    /**
     * the database report Driver
     */
    private String reportDriver;
    /**
     * the database report Password
     */
    private String reportPassword;
        /**
     * the database report User
     */
    private String reportUser;    

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the ejUrl
     */
    public String getEjUrl() {
        return ejUrl;
    }

    /**
     * @param ejUrl the ejUrl to set
     */
    public void setEjUrl(String ejUrl) {
        this.ejUrl = ejUrl;
    }

    /**
     * @return the ejDriver
     */
    public String getEjDriver() {
        return ejDriver;
    }

    /**
     * @param ejDriver the ejDriver to set
     */
    public void setEjDriver(String ejDriver) {
        this.ejDriver = ejDriver;
    }

    /**
     * @return the ejPassword
     */
    public String getEjPassword() {
        return ejPassword;
    }

    /**
     * @param ejPassword the ejPassword to set
     */
    public void setEjPassword(String ejPassword) {
        this.ejPassword = ejPassword;
    }

    /**
     * @return the ejUser
     */
    public String getEjUser() {
        return ejUser;
    }

    /**
     * @param ejUser the ejUser to set
     */
    public void setEjUser(String ejUser) {
        this.ejUser = ejUser;
    }

    /**
     * @return the reportUrl
     */
    public String getReportUrl() {
        return reportUrl;
    }

    /**
     * @param reportUrl the reportUrl to set
     */
    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    /**
     * @return the reportDriver
     */
    public String getReportDriver() {
        return reportDriver;
    }

    /**
     * @param reportDriver the reportDriver to set
     */
    public void setReportDriver(String reportDriver) {
        this.reportDriver = reportDriver;
    }

    /**
     * @return the reportPassword
     */
    public String getReportPassword() {
        return reportPassword;
    }

    /**
     * @param reportPassword the reportPassword to set
     */
    public void setReportPassword(String reportPassword) {
        this.reportPassword = reportPassword;
    }

    /**
     * @return the reportUser
     */
    public String getReportUser() {
        return reportUser;
    }

    /**
     * @param reportUser the reportUser to set
     */
    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    /**
     * @return the journal
     */
    public String getJournal() {
        return journal;
    }

    /**
     * @param journal the journal to set
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }
   
}
