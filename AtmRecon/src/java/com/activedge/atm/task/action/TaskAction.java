/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activedge.atm.task.action;

import com.activedge.atm.task.data.TaskData;
import com.activedge.atm.task.persistence.TaskDAO;
import com.activedge.atm.web.common.BaseAction;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TechDev
 */
public class TaskAction extends BaseAction {
    private TaskData task;
    private List tasks;
    private String editMode;



    public String execute() throws SQLException{
        
        return SUCCESS;
    }
    /**
     * creates Task Data
     * @return
     * @throws Exception 
     */
    public String createTask() throws Exception {
        
        TaskDAO dao = new TaskDAO();
        TaskData data = dao.createTask(getTask());
        List taskList = dao.findAllTasks();
        setTask(data);
        setTasks(taskList);
        return SUCCESS;
       
    }
    /**
     * updates Task Data
     * @return
     * @throws Exception 
     */
    public String updateTask() throws Exception {
        TaskDAO dao = new TaskDAO();
        TaskData data = dao.updateTask(getTask());
        List taskList = dao.findAllTasks();
        setTask(data);
        setTasks(taskList);        
        
        return SUCCESS;
    }  
    
    /**
     * deletes Task Data
     * @return
     * @throws Exception 
     */
    public String deleteTask() throws Exception {
        TaskDAO dao = new TaskDAO();
        TaskData data = dao.deleteTask(getTask());
        List taskList = dao.findAllTasks();
        setTask(data);
        setTasks(taskList);        
        
        return SUCCESS;
    } 
    /**
     * views Task Data
     * @return
     * @throws Exception 
     */
    public String viewTask() throws Exception {
        TaskDAO dao = new TaskDAO();
        TaskData data = dao.viewTask(getTask());
        List taskList = dao.findAllTasks();
        setTask(data);
        setTasks(taskList); 

        return SUCCESS;
    }    
    /**
     * finds All Tasks Data
     * @return
     * @throws Exception 
     */
    public String findAllTasks() throws Exception {
        TaskDAO dao = new TaskDAO();
        List taskList = dao.findAllTasks();
        setTasks(taskList);         
        
        return SUCCESS;
    }     
    /**
     * searches for TaskByCriteria Data
     * @return
     * @throws Exception 
     */
    
    public String findTasksByCriteria() throws Exception {
        TaskDAO dao = new TaskDAO();
        List taskList = dao.findTasksByCriteria(getTask());
        setTasks(taskList);
        System.out.println("task" + taskList.size());
        System.out.println("task" + tasks.size());
        
        return SUCCESS;
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

    /**
     * @return the task
     */
    public TaskData getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(TaskData task) {
        this.task = task;
    }

    /**
     * @return the tasks
     */
    public List getTasks() {
        return tasks;
    }

    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List tasks) {
        this.tasks = tasks;
    }
}
