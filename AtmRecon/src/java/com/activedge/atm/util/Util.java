/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *the util class to help with utility  methods
 * @author ifeanyi
 */
public class Util {

    /**
     * the method converts a String to a Sql Date for the database
     * @param sDate - the String date
     * @return Date  - the sql date for the database
     */
    public static Date getDateFromString(String sDate)
    {

        Date sqlDate = null;
        if (sDate == null  || sDate.trim().length() < 1)
            return sqlDate;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sqlDate = new Date(df.parse(sDate).getTime());
        } catch (Exception ex) {

            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sqlDate;
    }

    /**
     * the method converts a String to a Sql Date for the database
     * @param sqlDate - the Sql date
     * @return String  - the string date for the UI
     */
    public static String getStringFromDate(Date sqlDate)
    {
        String sDate = null;
       if (sqlDate == null)
            return sDate;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sDate = df.format(sqlDate);
        } catch (Exception ex) {

            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sDate;
    }

}