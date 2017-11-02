/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.util;

import com.activedge.atm.util.GenerateLogs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechDEv
 */
public class ConfigurationUtil {
    private static ConfigurationUtil instance = null;
    
    private static String journalpath = "";   
    private static boolean propertyLoaded = false;

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
     * @return the propertyLoaded
     */
    public static boolean isPropertyLoaded() {
        return propertyLoaded;
    }

    /**
     * @param aPropertyLoaded the propertyLoaded to set
     */
    public static void setPropertyLoaded(boolean aPropertyLoaded) {
        propertyLoaded = aPropertyLoaded;
    }
    /**
     * config profile
     */
    ConfigProfile config;
    
    private ConfigurationUtil()
    {
        init();
    }

    private void init() {
        config = new ConfigProfile();
        File f1 = new File("");
        System.out.println(" file path " + f1.getPath());
        
        File f = new File("atm.properties");
        System.out.println(" file absolute path " + f.getAbsolutePath());
        if (!f.exists())
        {
            System.err.println("The atm.properties file not found");
            
            Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, new Exception("The atm.properties file not found"));
            return;
        }
        else
        {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(f));
                String line = null;
                while ( (line = bf.readLine())!= null)
                {
                    if (line.contains(ConfigProfile.DB_USER))
                    {
                        config.setUser(line.substring(ConfigProfile.DB_USER.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_PASSWORD))
                    {
                        config.setPassword(line.substring(ConfigProfile.DB_PASSWORD.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_DRIVER))
                    {
                        config.setDriver(line.substring(ConfigProfile.DB_DRIVER.length() + 1));
                    }  
                    else if (line.contains(ConfigProfile.DB_URL))
                    {
                        config.setUrl(line.substring(ConfigProfile.DB_URL.length() + 1));
                    }  
                    else if (line.contains(ConfigProfile.DB_EJ_USER))
                    {
                        config.setEjUser(line.substring(ConfigProfile.DB_EJ_USER.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_EJ_PASSWORD))
                    {
                        config.setEjPassword(line.substring(ConfigProfile.DB_EJ_PASSWORD.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_EJ_DRIVER))
                    {
                        config.setEjDriver(line.substring(ConfigProfile.DB_EJ_DRIVER.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_EJ_URL))
                    {
                        config.setEjUrl(line.substring(ConfigProfile.DB_EJ_URL.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_REPORT_USER))
                    {
                        config.setReportUser(line.substring(ConfigProfile.DB_REPORT_USER.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_REPORT_PASSWORD))
                    {
                        config.setReportPassword(line.substring(ConfigProfile.DB_REPORT_PASSWORD.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_REPORT_DRIVER))
                    {
                        config.setReportDriver(line.substring(ConfigProfile.DB_REPORT_DRIVER.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.DB_REPORT_URL))
                    {
                        config.setReportUrl(line.substring(ConfigProfile.DB_REPORT_URL.length() + 1));
                    }
                    else if (line.contains(ConfigProfile.getJournalpath()))
                    {
                        config.setJournal(line.substring(ConfigProfile.getJournalpath().length() + 1));
                    } 
//                    setJournalpath(ConfigProfile.getJournalpath());
//                if (getJournalpath() == null || getJournalpath().trim().length() < 1)
//                    setJournalpath("c:\\journaldirfx");
//                new GenerateLogs("Journal Path " + getJournalpath());
//                setPropertyLoaded(true);
                }
                bf.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.err.println("The atm.properties file not found");
                Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("The atm.properties file not found");
                Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("The atm.properties file not found");
                Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static ConfigurationUtil getInstance() {
        if (instance == null)
        {
            instance = new ConfigurationUtil();
        }
        return instance;
    }   
    
    public ConfigProfile getProfile()
    {
        return config;
    }
    
    
}
