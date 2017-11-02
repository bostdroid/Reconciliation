/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.reportportal.util;

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
    
    public static final String DB_JV_USER = "db_jv_user";
    /**
     * the place holder for journal path 
     */
    public static String journalpath = "";

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

    private String jvUser;
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * the  journal path
     */
    private String journal;

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

    /**
     * @return the jvUser
     */
    public String getJvUser() {
        return jvUser;
    }

    /**
     * @param jvUser the jvUser to set
     */
    public void setJvUser(String jvUser) {
        this.jvUser = jvUser;
    }
 
    
}
