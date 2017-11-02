/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.reportportal.action;

//import com.activedge.file.action.VerifyTerminal;
import com.activedge.atm.reportportal.persistence.ReportPortalDAO;
import com.activedge.atm.reportportal.data.ReportPortalData;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class ReportPortalAction {
    private ReportPortalData report;
    private List reports;
    private List verifyT;
    private String verifyTerminal;
    private String verify;
    
    public String execute() throws Exception {

        return SUCCESS;
    }
        
     /**
     * finds AllReports Data
     * @return
     * @throws Exception 
     */
    public String findAllReportPortals() throws Exception {
    ReportPortalDAO dao = new ReportPortalDAO();
        System.out.println("I'm here");
    List reportList = dao.findAllReportPortals();
        System.out.println("Here I am");
    setReports(reportList);
    return SUCCESS;
    }
    
    /**
     * searches for ReportsByCriteria
     * @return
     * @throws Exception 
     */
    
    public String findReportsByCriteria() throws Exception {
        ReportPortalDAO dao = new ReportPortalDAO();
        List reportList = dao.findReportsByCriteria(getReport());
        getVerify();
        if (reportList.isEmpty()){
            
            
                VerifyTerminal action = new VerifyTerminal();
                boolean verify = action.verifyLoad(report.getStartDate(), report.getTerminal());
                if (verify!=true){
                    System.out.println("Terminal " + report.getTerminal()+ " has not been uploaded");

                String newreturnmessage = "Terminal " + report.getTerminal()+ " not uploaded in report on  " + report.getStartDate();
                setVerify(newreturnmessage);
                }
                else
                {
                     //setVerifyT(reportList);
                String returnmessage = "There are no errors for terminal "+report.getTerminal()+ " on " + report.getStartDate();
                System.out.println("testing....xx1xxx "+returnmessage);
                setVerify(returnmessage);
                }
//               
            }  
        
        setReports(reportList);
        
        
        return SUCCESS;
    }    

    public String findReportsByDate() throws Exception {
        ReportPortalDAO dao = new ReportPortalDAO();
        List reportList = dao.findReportsByDate(getReport());
        setReports(reportList);         
        
        return SUCCESS;
    }
    
    /**
     * @return the report
     */
    public ReportPortalData getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(ReportPortalData report) {
        this.report = report;
    }

    /**
     * @return the reports
     */
    public List getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List reports) {
        this.reports = reports;
    }
    String returnmessage = "";
    String terminalError = "";
    StringBuilder querryBuilder;
    String querryToEx = "";
    ArrayList traveller;
    StringBuilder sb1 = new StringBuilder();
    String date1 = sb1.toString();

    /**
     * @return the verifyT
     */
    public List getVerifyT() {
        return verifyT;
    }

    /**
     * @param verifyT the verify to set
     */
    public void setVerifyT(List verifyT) {
        this.verifyT = verifyT;
    }

    /**
     * @return the verifyTerminal
     */
    public String getVerifyTerminal() {
        if (verifyT.isEmpty()){
            return verifyTerminal = "";
        }
        else{
            verifyTerminal = verifyT.toString();
        }
        return verifyTerminal;
    }

    /**
     * @param verifyTerminal the verifyTerminal to set
     */
    public void setVerifyTerminal(String verifyTerminal) {
        this.verifyTerminal = verifyTerminal;
    }

    /**
     * @return the verify
     */
    public String getVerify() {
//        if(reports.isEmpty()){
        
             return verify;
        }
     
           
//        }
////        else{
//            verify = reports.toString();
//        }
        //return verify;
    

    /**
     * @param verify the verify to set
     */
    public void setVerify(String verify) {
        this.verify = verify;
    }    

}
