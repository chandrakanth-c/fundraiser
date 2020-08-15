/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Application;

import Business.UserAccount.VolunteerAccount;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Floyed Pinto
 */
public class SplitVolunteerRequest extends Application {

    private double splitAmount;

    private WorkRequest parentWorkRequest;

    private VolunteerAccount assignedToVolunteer;
    
    private String taskStatus;
    
    private double splitAmountRequired;

    public double getSplitAmountRequired() {
        return splitAmountRequired;
    }

    public void setSplitAmountRequired(double splitAmountRequired) {
        this.splitAmountRequired = splitAmountRequired;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    private double amountAchieved;

    public double getAmountAchieved() {
        return amountAchieved;
    }

    public void setAmountAchieved(double amountAchieved) {
        this.amountAchieved = amountAchieved;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(double splitAmount) {
        this.splitAmount = splitAmount;
    }

    public WorkRequest getParentWorkRequest() {
        return parentWorkRequest;
    }

    public void setParentWorkRequest(WorkRequest parentWorkRequest) {
        this.parentWorkRequest = parentWorkRequest;
    }

    public VolunteerAccount getAssignedToVolunteer() {
        return assignedToVolunteer;
    }

    public void setAssignedToVolunteer(VolunteerAccount assignedToVolunteer) {
        this.assignedToVolunteer = assignedToVolunteer;
    }

}
