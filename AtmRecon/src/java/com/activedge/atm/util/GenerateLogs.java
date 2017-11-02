/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.util;

//import com.activedge.atm.db.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author TechDev
 */
public class GenerateLogs {

    private static final String FILENAME = "atmPortalLogs.txt";

    public GenerateLogs(String newContent) {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                File file = new File(FILENAME);
   System.out.println("yes,,,," + file.getAbsolutePath());
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);

                    bw.write(file.getAbsolutePath());
                    bw.newLine();
                    bw.flush();
                }

                // true = append file
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);

                bw.write(newContent);
                bw.newLine();
                bw.flush();
                //System.out.println("Done");

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
                try {
                    System.gc();
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writelogs(String newContent) {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                File file = new File(FILENAME);
   System.out.println("yes,,,," + file.getAbsolutePath());
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);

                    bw.write(file.getAbsolutePath());
                    bw.newLine();
                    bw.flush();
                }

                // true = append file
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);

                bw.write(newContent);
                bw.newLine();
                bw.flush();
                //System.out.println("Done");

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
                try {
                    System.gc();
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
