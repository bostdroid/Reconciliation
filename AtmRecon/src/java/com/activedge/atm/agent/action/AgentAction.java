/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.agent.action;

import com.activedge.atm.agent.data.AgentData;
import com.activedge.atm.agent.persistence.AgentDAO;
import com.activedge.atm.branch.DAO.BranchDAO;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class AgentAction extends BaseAction{

    private AgentData agent;
    private String editMode;
    private List agents;
    private List<String> chooseAgent;
    private List agentList;
    private List branchList;
    
    /**
     * @return the agents
     */
    public List getAgents() {
        return agents;
    }

    /**
     * @param agents the agents to set
     */
    public void setAgents(List agents) {
        this.agents = agents;
    }
    
    /**
     * @return the branch
     */
    public AgentData getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(AgentData agent) {
        this.agent = agent;
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
        
        setAgent(new AgentData());
        BranchDAO dao = new BranchDAO();
        List branchLists = dao.findAllBranches();
//        List<String>  branchList = dao.findAllBranches();
        setBranchList(branchLists); 
//        setChooseBranch(branchList);
        return SUCCESS;
    }
    /**
     * creates Agent Data
     * @return
     * @throws Exception 
     */
    public String createAgent() throws Exception {
        AgentDAO dao = new AgentDAO();
        AgentData data = dao.createAgent(getAgent());
        List agentList = dao.findAllAgents();
        setAgent(data);
        setAgents(agentList);
        
        return SUCCESS;
    }
    /**
     * updates Branch Data
     * @return
     * @throws Exception 
     */
    public String updateAgent() throws Exception {
        AgentDAO dao = new AgentDAO();
        AgentData data = dao.updateAgent(getAgent());
        List agentList = dao.findAllAgents();
        setAgent(data);
        setAgents(agentList);        
        
        return SUCCESS;
    }  
       
    
    /**
     * deletes Branch Data
     * @return
     * @throws Exception 
     */
    public String deleteAgent() throws Exception {
        AgentDAO dao = new AgentDAO();
        AgentData data = dao.deleteAgent(getAgent());
        List agentList = dao.findAllAgents();
        setAgent(data);
        setAgents(agentList);        
        
        return SUCCESS;
    } 
    /**
     * views Branch Data
     * @return
     * @throws Exception 
     */
    public String viewAgent() throws Exception {
        AgentDAO dao = new AgentDAO();
        AgentData data = dao.viewAgent(getAgent());
        List agentList = dao.findAllAgents();
        setAgent(data);
        setAgents(agentList); 

        return SUCCESS;
    }   
    
    /**
     * finds AllBranches Data
     * @return
     * @throws Exception 
     */
    public String findAllAgents() throws Exception {
        AgentDAO dao = new AgentDAO();
        List agentList = dao.findAllAgents();
        setAgents(agentList);         
        
        return SUCCESS;
    }     
/**
     * searches for BranchByCriteria Data
     * @return
     * @throws Exception 
     */
    
    public String findAgentsByCriteria() throws Exception {
        AgentDAO dao = new AgentDAO();
        List agentList = dao.findAgentsByCriteria(getAgent());
        setAgents(agentList);         
        
        return SUCCESS;
    } 

 

    /**
     * @return the chooseAgent
     */
    public List<String> getChooseAgent() {
        return chooseAgent;
    }

    /**
     * @param chooseAgent the chooseAgent to set
     */
    public void setChooseAgent(List<String> chooseAgent) {
        this.chooseAgent = chooseAgent;
    }

    /**
     * @return the agentList
     */
    public List getAgentList() {
        return agentList;
    }

    /**
     * @param agentList the agentList to set
     */
    public void setAgentList(List agentList) {
        this.agentList = agentList;
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
