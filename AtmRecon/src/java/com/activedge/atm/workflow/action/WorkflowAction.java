/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.workflow.action;


import com.activedge.atm.user.data.UserData;
import com.activedge.atm.web.common.BaseAction;
import com.activedge.atm.workflow.data.WorkflowData;
import com.activedge.atm.workflow.persistence.WorkflowDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Activedge1
 */

public class WorkflowAction extends BaseAction {

    /**
     * @return the workflow
     */
    public WorkflowData getWorkflow() {
        return workflow;
    }

    /**
     * @return the workflows
     */
    public List getWorkflows() {
        return workflows;
    }

    /**
     * @param workflows the workflows to set
     */
    public void setWorkflows(List workflows) {
        this.workflows = workflows;
    }
    private WorkflowData workflow;
    
    private List workflows;

 
    /**
     * creates Workflow Data
     * @return
     * @throws Exception 
     */
    public String createWorkflow() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        WorkflowData data = dao.createWorkflow(getWorkflow());
        List workflowList = dao.findAllWorkflows();
        setWorkflow(data);
        setWorkflows(workflowList);

        return SUCCESS;
    }
    /**
     * updates Workflow Data
     * @return
     * @throws Exception 
     */
    public String updateWorkflow() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        WorkflowData data = dao.updatewWorkflow(getWorkflow());
        List workflowList = dao.findAllWorkflows();
        setWorkflow(data);
        setWorkflows(workflowList);

        return SUCCESS;
    }
    /**
     * deletes workflow Data
     * @return
     * @throws Exception 
     */
    public String deleteWorkflow() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        WorkflowData data = dao.deleteWorkflow(getWorkflow());
        List workflowList = dao.findAllWorkflows();
        setWorkflow(data);
        setWorkflows(workflowList);

        return SUCCESS;
    }
    /**
     * views Workflow Data
     * @return
     * @throws Exception 
     */
    public String viewWorkflow() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        WorkflowData data = dao.viewWorkflow(getWorkflow());
        List workflowList = dao.findAllWorkflows();
        setWorkflow(data);
        setWorkflows(workflowList);

        return SUCCESS;
    }
    
        
    public String createworkflow() throws Exception {
        setWorkflow(new WorkflowData());
        setWorkflows(new ArrayList());
        
        return SUCCESS;
    }
 
    public String execute() throws Exception {
        setWorkflow(new WorkflowData());
        setWorkflows(new ArrayList());
        
        return SUCCESS;
    }    
    /**
     * finds AllWorkflow Data
     * @return
     * @throws Exception 
     */
    public String findAllWorkflow() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        List workflowList = dao.findAllWorkflows();
        setWorkflows(workflowList);

        return SUCCESS;
    }

    /**
     * @param workflow the workflow to set
     */
    public void setWorkflow(WorkflowData workflow) {
        this.workflow = workflow;
    }

    /**
     * searches Workflow Data
     * @return
     * @throws Exception 
     */
    public String findWorkflowsByCriteria() throws Exception {
        WorkflowDAO dao = new WorkflowDAO();
        List workflowList = dao.findWorkflowsByCriteria(getWorkflow()); 
        setWorkflows(workflowList);         
        
        return SUCCESS;
    }


}
