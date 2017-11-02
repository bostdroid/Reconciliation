/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.journalviewer.action;

import com.activedge.atm.journalviewer.DAO.JournalViewerDAO;
import com.activedge.atm.journalviewer.data.JournalViewerData;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class JournalViewerAction {
    
    private JournalViewerData viewer;
    private List viewers;
    
   
        public String execute() throws Exception {

        return SUCCESS;
    }
        
     /**
     * finds AllJournalsByCriteria 
     * @return
     * @throws Exception 
     */
    public String findJournalsByCriteria() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
    List journalList = dao.findJournalsByCriteria(getViewer());
         System.out.println("Get Date "+viewer.getDate());
//         System.out.println("Get total "+ viewers.size());
         
    setViewers(journalList);
    return SUCCESS;
    }
     /**
     * finds AllSuccessful Transactions Data
     * @return
     * @throws Exception 
     */
    public String findAllSuccessfulTrans() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
    List journalList = dao.findAllSuccessfulTrans();
    setViewers(journalList);
    return SUCCESS;
    }
    
     /**
     * finds AllDispenseError Transactions Data
     * @return
     * @throws Exception 
     */
        
    public String findAllDispenseErrors() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
    List transList = dao.findAllDispenseErrors();
     setViewers(transList);         
        
    return SUCCESS;
    }
  
     /**
     * finds AllViewers Data
     * @return
     * @throws Exception 
     */
    public String findAllJournalViewers() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
        System.out.println("I'm here");
    List journalList = dao.findAllJournalViewers();
        System.out.println("Here I am");
    setViewers(journalList);
    return SUCCESS;
    }
    
    public String findAllDashboardViewers() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
        System.out.println("Dashboard");
    List journalList = dao.findAllDashboardViewers();
        System.out.println("Dashboard here");
    setViewers(journalList);
    return SUCCESS;
    }
    
     /**
     * finds AllViewers Data
     * @return
     * @throws Exception 
     */
    public String findAllFailedTrans() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
        System.out.println("I'm here");
    List journalList = dao.findAllFailedTrans();
        System.out.println("Here I am");
    setViewers(journalList);
    return SUCCESS;
    }
    
     /**
     * finds AllBusy Terminal Data
     * @return
     * @throws Exception 
     */
    public String findAllBusiestTerminal() throws Exception {
    JournalViewerDAO dao = new JournalViewerDAO();
        System.out.println("I'm here");
    List journalList = dao.findAllBusiestTerminal();
        System.out.println("Here I am");
    setViewers(journalList);
    return SUCCESS;
    }
        /**
     * creates Comment Data
     * @return
     * @throws Exception 
     */
//    public String createComment() throws Exception {
//        JournalViewerDAO dao = new JournalViewerDAO();
//        JournalViewerData data = dao.createComment(getViewer());
////        List commentList = dao.findAllComments();
//        setViewer(data);
////        setViewers(commentList);
//        
//        return SUCCESS;
//    }
    
    /**
     * @return the viewer
     */
    public JournalViewerData getViewer() {
        return viewer;
    }

    /**
     * @param viewer the viewer to set
     */
    public void setViewer(JournalViewerData viewer) {
        this.viewer = viewer;
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


}
