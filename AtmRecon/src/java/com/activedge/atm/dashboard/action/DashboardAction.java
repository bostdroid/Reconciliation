/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.dashboard.action;

import com.activedge.atm.dashboard.persistence.DashboardDAO;
import com.activedge.atm.dashboard.Data.DashboardData;
import com.activedge.atm.reportportal.persistence.ReportPortalDAO;
import com.activedge.atm.web.common.Controller;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class DashboardAction {
    
    
    private List transaction;
    private List dispense;
    private List error;
    private List failed;
    private List success;
    private List uinmpacted;
    private List viewers;
    private List busiest;
    private List disperror;
    private List dispenseError;
    private List trantype;
    private List verify;
    private String verifyTerminal;
    private int transactionSize;
    private int dispenseSize;
    private int failedSize;
    private int dispenseErrorSize;
    private int successSize;
    private DashboardData dashboard;
    private String dispenseTerminal;
    private String dispenseTerminalValue;

 
    
    public String execute() throws Exception{
        return SUCCESS;
    }


    /**
     * @return the transactionSize
     */
    public int getTransactionSize() {
        if (transaction == null){
            System.out.println("trans size "+ transactionSize);
            return transactionSize = 0;  
        }
        else{
            transactionSize = transaction.size();
            System.out.println("transaction size "+ transactionSize);
            
        }
        return transactionSize;
    }

    /**
     * @param transactionSize the transactionSize to set
     */
    public void setTransactionSize(int transactionSize) {
        this.transactionSize = transactionSize;
    }

    /**
     * @return the transaction
     */
    public List getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(List transaction) {
        this.transaction = transaction;
    }
    
    public String initReport() throws Exception{

        retrieveTransactionInfo();
//        retrieveDispenseInfo();
        retrieveDispenseErrorInfo();
        retrieveSuccessInfo();
        retrieveFailedInfo();
//        retrieveBusiestInfo();
//        retrieveUnimpactedInfo();
        retrieveHighestDispenseErrorInfo();
//        retrieveTranTypeInfo();
        //retrieveMaxTerminalInfo();
        
        //System.out.println("transaction total");
        return SUCCESS;
    }
    
    /**
     * retrieves transaction info
     * @throws SQLException 
     */
    private void retrieveTransactionInfo() throws SQLException {
        DashboardData dashdata = new DashboardData();
//        System.out.println("I am dashboard  ");
        List transactionList = Controller.findTransactionsByCriteria(dashdata);
        setTransaction(transactionList);
    }
    
    /**
     * retrieves dispense info
     * @throws SQLException 
     */
//    private void retrieveDispenseInfo() throws SQLException {
//        DashboardData dashdata = new DashboardData();
////        System.out.println("I am dashboard  ");
//        List dispenseList = Controller.findDispenseByCriteria(dashdata);
//        setDispense(dispenseList);
//        //System.out.println("I am here 2  " +transactionList.size());
//        //session.put("loggedin", "true");
//    }
//    
    /**
     * retrieves dispenseError info
     * @throws SQLException 
     */
    private void retrieveFailedInfo() throws SQLException {
        DashboardData dashdata = new DashboardData();
//        System.out.println("I am dashboard  ");
        List dispenseList = Controller.findFailedByCriteria(dashdata);
        setFailed(dispenseList);
    }
    
    /**
     * retrieves dispenseError info
     * @throws SQLException 
     */
    private void retrieveSuccessInfo() throws SQLException {
        DashboardData dashdata = new DashboardData();
//        System.out.println("I am dashboard  ");
        List dispenseList = Controller.findSuccessByCriteria(dashdata);
        setSuccess(dispenseList);
        //System.out.println("I am here 2  " +transactionList.size());
        //session.put("loggedin", "true");
    }
    
    /**
     * retrieves dispenseError info
     * @throws SQLException 
     */
    private void retrieveDispenseErrorInfo() throws SQLException {
        DashboardData dashdata = new DashboardData();
//        System.out.println("I am dashboard  ");
        List dispenseList = Controller.findDispenseErrorByCriteria(dashdata);
        setDispenseError(dispenseList);
    }
    
    /**
     * retrieves busiest info
     * @throws SQLException 
     */
//    private void retrieveBusiestInfo() throws SQLException {
//        ReportPortalDAO dao = new ReportPortalDAO();
//        System.out.println("I am chart  ");
//        List dispenseList = dao.findBusiestTerminals();
//        setBusiest(dispenseList);
//    }
    
    /**
     * retrieves unimpactedError info
     * @throws SQLException 
     */
//    private void retrieveUnimpactedInfo() throws SQLException {
//        ReportPortalDAO dao = new ReportPortalDAO();
//        System.out.println("I am chart  ");
//        List dispenseList = dao.findAllUnimpactedTerminals();
//        setUnimpacted(dispenseList);
//    }
    
    /**
     * retrieves unimpactedError info
     * @throws SQLException 
     */
    private void retrieveHighestDispenseErrorInfo() throws SQLException {
        ReportPortalDAO dao = new ReportPortalDAO();
//        System.out.println("I am chart  ");
        List dispenseList = dao.findAllHighestDispenseErrors();
        setDisperror(dispenseList);
    }
    
    /**
     * retrieves trantype info
     * @throws SQLException 
     */
//    private void retrieveTranTypeInfo() throws SQLException {
//        DashboardDAO dao = new DashboardDAO();
//        System.out.println("I am chart  ");
//        List dispenseList = dao.findAllTranTypes();
//        setTrantype(dispenseList);
//    }
     
    
            
    /**
     * retrieves unimpactedError info
     * @throws SQLException 
     */
//    private void retrieveMaxTerminalInfo() throws SQLException {
//        ReportPortalDAO dao = new ReportPortalDAO();
//        System.out.println("I am chart  ");
//        List dispenseList = dao.findAllDispenseViewers();
//        setDispense(dispenseList);
//   
//    }
//    
//        public String findAllTransactions() throws Exception {
//        DashboardDAO dao = new DashboardDAO();
//        List transList = dao.findAllTransactions();
//        setTransaction(transList);         
//        
//        return SUCCESS;
//    } 

//        public String findAllDashboardViewers() throws Exception {
//        DashboardDAO dao = new DashboardDAO();
//        List transList = dao.findAllDashboardViewers();
//        setTransaction(transList);         
//        
//        return SUCCESS;
//    } 
//      
        

    /**
     * @return the dashboard
     */
    public DashboardData getDashboard() {
        return dashboard;
    }

    /**
     * @param dashboard the dashboard to set
     */
    public void setDashboard(DashboardData dashboard) {
        this.dashboard = dashboard;
    }

    /**
     * @return the dispenseSize
     */
    public int getDispenseSize() {
        if (dispense == null){
            System.out.println("total dispense "+dispenseSize);
            dispenseSize = 0;
        }
        else{
            dispenseSize=dispense.size();
        }
        return dispenseSize;
    }

    /**
     * @param dispenseSize the dispenseSize to set
     */
    public void setDispenseSize(int dispenseSize) {
        this.dispenseSize = dispenseSize;
    }

    /**
     * @return the failedSize
     */
    public int getFailedSize() {
        if(failed==null){
            return failedSize = 0;
        }
        else{
            failedSize = failed.size();
        }
        return failedSize;
    }

    /**
     * @param failedSize the failedSize to set
     */
    public void setFailedSize(int failedSize) {
        this.failedSize = failedSize;
    }

    /**
     * @return the successSize
     */
    public int getSuccessSize() {
        if (success == null){
            return successSize = 0;
        }
        else{
            successSize = success.size();
        }
        return successSize;
    }

    /**
     * @param successSize the successSize to set
     */
    public void setSuccessSize(int successSize) {
        this.successSize = successSize;
    }

    /**
     * @return the dispense
     */
    public List getDispense() {
        return dispense;
    }

    /**
     * @param dispense the dispense to set
     */
    public void setDispense(List dispense) {
        this.dispense = dispense;
    }

    /**
     * @return the error
     */
    public List getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(List error) {
        this.error = error;
    }

    /**
     * @return the success
     */
    public List getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(List success) {
        this.success = success;
    }



    /**
     * @return the dispenseTerminalValue
     */
    public String getDispenseTerminalValue() {
        if (getDispenseTerminal() ==null){
            return dispenseTerminalValue="";
        }
        else{
            dispenseTerminalValue = dispenseTerminal.toUpperCase();
        }
        return dispenseTerminalValue;
    }

    /**
     * @param dispenseTerminalValue the dispenseTerminalValue to set
     */
    public void setDispenseTerminalValue(String dispenseTerminalValue) {
        this.dispenseTerminalValue = dispenseTerminalValue;
    }

    /**
     * @return the dispenseTerminal
     */
    public String getDispenseTerminal() {
        return dispenseTerminal;
    }

    /**
     * @param dispenseTerminal the dispenseTerminal to set
     */
    public void setDispenseTerminal(String dispenseTerminal) {
        this.dispenseTerminal = dispenseTerminal;
    }

    /**
     * @return the dispenseErrorSize
     */
    public int getDispenseErrorSize() {
        if (dispenseError== null){
            return dispenseErrorSize = 0;
        }
        else{
            dispenseErrorSize = dispenseError.size();
        }
        return dispenseErrorSize;
    }

    /**
     * @param dispenseErrorSize the dispenseErrorSize to set
     */
    public void setDispenseErrorSize(int dispenseErrorSize) {
        this.dispenseErrorSize = dispenseErrorSize;
    }

    /**
     * @return the failed
     */
    public List getFailed() {
        return failed;
    }

    /**
     * @param failed the failed to set
     */
    public void setFailed(List failed) {
        this.failed = failed;
    }

    /**
     * @return the viewers
     */
    public List getViewers() {
        return viewers;
    }

    /**
     * @param viewers the viewers to set
     */
    public void setViewers(List viewers) {
        this.viewers = viewers;
    }

    /**
     * @return the terminals
     */
    public List getUnimpacted() {
        return uinmpacted;
    }

    /**
     * @param uinmpacted the uinmpacted to set
     */
    public void setUnimpacted(List uinmpacted) {
        this.uinmpacted = uinmpacted;
    }

    /**
     * @return the disperror
     */
    public List getDisperror() {
        return disperror;
    }

    /**
     * @param disperror the disperror to set
     */
    public void setDisperror(List disperror) {
        this.disperror = disperror;
    }

    /**
     * @return the busiest
     */
    public List getBusiest() {
        return busiest;
    }

    /**
     * @param busiest the busiest to set
     */
    public void setBusiest(List busiest) {
        this.busiest = busiest;
    }

    /**
     * @return the dispenseError
     */
    public List getDispenseError() {
        return dispenseError;
    }

    /**
     * @param dispenseError the dispenseError to set
     */
    public void setDispenseError(List dispenseError) {
        this.dispenseError = dispenseError;
    }

    /**
     * @return the trantype
     */
    public List getTrantype() {
        return trantype;
    }

    /**
     * @param trantype the trantype to set
     */
    public void setTrantype(List trantype) {
        this.trantype = trantype;
    }

    /**
     * @return the verify
     */
    public List getVerify() {
        return verify;
    }

    /**
     * @param verify the verify to set
     */
    public void setVerify(List verify) {
        this.verify = verify;
    }

    /**
     * @return the verifyTerminal
     */
    public String getVerifyTerminal() {
        if(verify.isEmpty()){
           return verifyTerminal = "";
        }
        else{
            verifyTerminal = verify.toString();
        }
        return verifyTerminal;
    }

    /**
     * @param verifyTerminal the verifyTerminal to set
     */
    public void setVerifyTerminal(String verifyTerminal) {
        this.verifyTerminal = verifyTerminal;
    }

}
