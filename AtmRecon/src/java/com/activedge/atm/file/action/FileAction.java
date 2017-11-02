/*
 * $Id: FileAction.template,v 1.2 2008-03-27 05:47:21 ub3rsold4t Exp $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.activedge.atm.file.action;

//import com.activedge.atm.db.util.GenerateLogs;
import com.activedge.atm.file.data.FileData;
import com.activedge.atm.util.ConfigurationUtil;
import com.activedge.atm.util.GenerateLogs;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * <code>Set welcome message.</code>
 */
public class FileAction extends ActionSupport {

    public List getMyList() {
        return myList;
    }

    public void setMyList(List myList) {
        this.myList = myList;
    }
    
    
    List myList ;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }
    String terminalID;
    
    String fileName;
    
    String fileDirectory;    
    
    String file;
    
    private String journalDate;
    
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }
    
    String date;

    public String execute() throws Exception {
        setMessage(getText(MESSAGE));
        return SUCCESS;
    }
    
    public String listfiles() throws Exception {
       // String dir = this.getFileDirectory();
        String dir = ConfigurationUtil.getInstance().getProfile().getJournal();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String journaldate = getJournalDate();
        java.sql.Date sqldbdate = new java.sql.Date(df.parse(journaldate).getTime());
        String fileFolder = "C:\\work\\FIRSTBANK\\files\\send to emma\\send to emma";
        System.out.println("directory "+dir);
        if (dir != null && dir.trim().length() > 0)
        {
            fileFolder = dir;
        }
        journaldate = journaldate.replaceAll("/", "");
        journaldate = journaldate.replaceAll("-", "");
        journaldate = journaldate.replaceAll("\\\\", "");
        fileFolder += "\\" + journaldate;
        String rundate =  df2.format(Calendar.getInstance().getTime());
        String message = "run date [" + rundate + "] folder ..." + fileFolder;
        
        System.out.println(rundate);
//         new GenerateLogs(message);
        GenerateLogs.writelogs(rundate);
    final String filePattern = getTerminalID();        
        String[] files = new String[0];
    File f = new File(fileFolder);
        if (f.exists()) {

            FilenameFilter nameFilter = new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(filePattern);
                }
            };
            if (filePattern == null || filePattern.trim().equalsIgnoreCase("")) {
                files = f.list();
            } else {
                files = f.list(nameFilter);
            }
        }
        //SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        myList = new ArrayList();
        int index = 0;
        for (index = 0; index < files.length; index++) {

            FileData data = new FileData();
            String fileName = files[index];
            if (new File(fileFolder + "\\" + fileName).isDirectory())
                continue;
            data.setName(fileName);
            data.setId(index + 1);
            data.setFileSize(((new File(fileFolder + "\\" + fileName)).length() / 1024));
            Date sqldate = new java.sql.Date((new File(fileFolder + "\\" + fileName)).lastModified());
            data.setCreateDate(sqldate);
            data.setStrCreateDate(df.format(sqldate));
            
            myList.add(data);
        }  
        setFileDirectory(fileFolder);
        return SUCCESS;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String downloadx()
    {
        byte[] bRead = new byte[1024];
        String file= this.getFile();
        System.out.println("downloadFolderFiles ...");



        String fileFolder = "C:\\work\\FIRSTBANK\\files\\send to emma\\send to emma";
        String filePath = fileFolder;

        filePath += "\\" + file;
       
        if (!(new File(filePath)).isFile()) {

            return "failure";


        }

        /*response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + file);
        // System.out.println("file Path MMM" + filePath);
        FileInputStream br = null;
        try {
            ServletOutputStream out = response.getOutputStream();
            br = new FileInputStream(filePath);
            // in = new ByteArrayInputStream();
            int result = 0;
            while ((result = br.read(bRead)) != -1) {
                out.write(bRead, 0, result);
            }
            br.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/
        return SUCCESS;
    }

    /**
     * Provide default value for Message property.
     */
    public static final String MESSAGE = "HelloWorld.message";

    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on FileAction page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
   private InputStream inputStream;
  
    private long contentLength;
 
    public String download() throws FileNotFoundException {
        String file= this.getFile();
        System.out.println("downloadFolderFiles ...");



        String dir = this.getFileDirectory();
        String rootdir = ConfigurationUtil.getInstance().getProfile().getJournalpath();
        String fileFolder = "C:\\work\\FIRSTBANK\\files\\send to emma\\send to emma";
        if (dir != null && dir.trim().length() > 0)
        {
            fileFolder = dir;
        }
        else
        {
            fileFolder = rootdir;
        }
        String filePath = fileFolder;

        filePath += "\\" + file;
        System.out.print(",,ok,,,,,,," + filePath);
       File fileToDownload = new File(filePath);
        if (!fileToDownload.isFile()) {

            return "failure";


        }        
         
        
 
        inputStream = new FileInputStream(fileToDownload);
        fileName = fileToDownload.getName();
        contentLength = fileToDownload.length();
         
        return SUCCESS;
    }
     
    public long getContentLength() {
        return contentLength;
    }
 

 
    public InputStream getInputStream() {
        return inputStream;
    }      

    /**
     * @return the journalDate
     */
    public String getJournalDate() {
        return journalDate;
    }

    /**
     * @param journalDate the journalDate to set
     */
    public void setJournalDate(String journalDate) {
        this.journalDate = journalDate;
    }
}

