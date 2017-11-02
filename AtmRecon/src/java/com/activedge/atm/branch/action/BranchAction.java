/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.branch.action;

import com.activedge.atm.branch.DAO.BranchDAO;
import com.activedge.atm.branch.data.BranchData;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class BranchAction extends BaseAction{
    private BranchData branch;
    private String editMode;
    private List branches;
    private List<String> chooseBranch;
    private List branchList;

    /**
     * @return the branch
     */
    public BranchData getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(BranchData branch) {
        this.branch = branch;
    }

    /**
     * @return the editMode
     */
    public String getEditMode() {
        return editMode;
    }

    /**
     * @param editMode the editMode to set
     */
    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }
    
    public String execute() throws SQLException{
        
        setBranch(new BranchData());
//        BranchDAO dao = new BranchDAO();
//        List branchLists = dao.findAllBranches();
//        List<String>  branchList = dao.findAllBranches();
//        setBranchList(branchLists); 
//        setChooseBranch(branchList);
        return SUCCESS;
    }
    /**
     * creates Branch Data
     * @return
     * @throws Exception 
     */
    public String createBranch() throws Exception {
        BranchDAO dao = new BranchDAO();
        BranchData data = dao.createBranch(getBranch());
        List branchList = dao.findAllBranches();
        setBranch(data);
        setBranches(branchList);
        
        return SUCCESS;
    }
    /**
     * updates Branch Data
     * @return
     * @throws Exception 
     */
    public String updateBranch() throws Exception {
        BranchDAO dao = new BranchDAO();
        BranchData data = dao.updateBranch(getBranch());
        List branchList = dao.findAllBranches();
        setBranch(data);
        setBranches(branchList);        
        
        return SUCCESS;
    }  
       
    
    /**
     * deletes Branch Data
     * @return
     * @throws Exception 
     */
    public String deleteBranch() throws Exception {
        BranchDAO dao = new BranchDAO();
        BranchData data = dao.deleteBranch(getBranch());
        List branchList = dao.findAllBranches();
        setBranch(data);
        setBranches(branchList);        
        
        return SUCCESS;
    } 
    /**
     * views Branch Data
     * @return
     * @throws Exception 
     */
    public String viewBranch() throws Exception {
        BranchDAO dao = new BranchDAO();
        BranchData data = dao.viewBranch(getBranch());
        List branchList = dao.findAllBranches();
        setBranch(data);
        setBranches(branchList); 

        return SUCCESS;
    }   
    
    /**
     * finds AllBranches Data
     * @return
     * @throws Exception 
     */
    public String findAllBranches() throws Exception {
        BranchDAO dao = new BranchDAO();
        List branchList = dao.findAllBranches();
        setBranches(branchList);         
        
        return SUCCESS;
    }     
/**
     * searches for BranchByCriteria Data
     * @return
     * @throws Exception 
     */
    
    public String findBranchesByCriteria() throws Exception {
        BranchDAO dao = new BranchDAO();
        List branchList = dao.findBranchesByCriteria(getBranch());
        setBranches(branchList);         
        
        return SUCCESS;
    } 

    /**
     * @return the branches
     */
    public List getBranches() {
        return branches;
    }

    /**
     * @param branches the branches to set
     */
    public void setBranches(List branches) {
        this.branches = branches;
    }

    /**
     * @return the chooseBranch
     */
    public List<String> getChooseBranch() {
        return chooseBranch;
    }

    /**
     * @param chooseBranch the chooseBranch to set
     */
    public void setChooseBranch(List<String> chooseBranch) {
        this.chooseBranch = chooseBranch;
    }

    /**
     * @return the branchList
     */
    public List getBranchList() {
        return branchList;
    }

    /**
     * @param branchList the branchList to set
     */
    public void setBranchList(List branchList) {
        this.branchList = branchList;
    }
}
