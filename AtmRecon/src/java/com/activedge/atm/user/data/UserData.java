/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activedge.atm.user.data;

import com.activedge.atm.web.common.BaseData;
import java.io.File;
import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Backup
 */
public class UserData extends BaseData {
    /**
     * login id
     */
    private String loginId;
    /**
     * login password
     */
    private String password; 
    /**
     * login employee Number
     */
    private String employeeNo;  
    /**
     * profile pix
     */
    private Blob profilePix;
    
    private File image;
    
    private String branch;

    private String assignedTask;
    /**
     * login retries
     */
    private int retries; 
    /**
     * login lock - Y or N
     */
    private String lock; 
    /**
     * last activity date
     */
    private Date lastActivityDate;
    
    /**
     * last activity date
     */
    private String strLastActivityDate; 
    /**
     * the role id of the user object
     */
    private long roleId = -1;   
    
    private String role;
    /**
     * the role name of the user object
     */
    private long roleName ;  

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the employeeNo
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return the retries
     */
    public int getRetries() {
        return retries;
    }

    /**
     * @param retries the retries to set
     */
    public void setRetries(int retries) {
        this.retries = retries;
    }

    /**
     * @return the lock
     */
    public String getLock() {
        return lock;
    }

    /**
     * @param lock the lock to set
     */
    public void setLock(String lock) {
        this.lock = lock;
    }

    /**
     * @return the lastActivityDate
     */
    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    /**
     * @param lastActivityDate the lastActivityDate to set
     */
    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    /**
     * @return the sLastActivityDate
     */
    public String getStrLastActivityDate() {
        return strLastActivityDate;
    }

    /**
     * @param sLastActivityDate the sLastActivityDate to set
     */
    public void setStrLastActivityDate(String sLastActivityDate) {
        this.strLastActivityDate = sLastActivityDate;
    }

    /**
     * @return the roleName
     */
    public long getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(long roleName) {
        this.roleName = roleName;
    }
    
    /**
     * @return the roleId
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the profilePix
     */
    public Blob getProfilePix() {
        return profilePix;
    }

    /**
     * @param profilePix the profilePix to set
     */
    public void setProfilePix(Blob profilePix) {
        this.profilePix = profilePix;
    }

    /**
     * @return the image
     */
    public File getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(File image) {
        this.image = image;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the assignedTask
     */
    public String getAssignedTask() {
        return assignedTask;
    }

    /**
     * @param assignedTask the assignedTask to set
     */
    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }
}
