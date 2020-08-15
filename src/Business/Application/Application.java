/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Application;

import Business.WorkQueue.WorkRequest;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pavanrao
 */
public class Application extends WorkRequest {
    
    private String cause;
    private Double amountRequested;
    private Date requiredBy;
    private String description;
    private String applicationId;
    private String status;
    private String comment;
    private Double amountCollected = 0.0;
    private Double amountRequired;
    private String payeeEmail;

    public String getPayeeEmail() {
        return payeeEmail;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }
    
    private List<Date> adPostTime = new ArrayList<Date>();

    public Double getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(Double amountRequired) {
        this.amountRequired = amountRequired;
    }
    
    private List<SplitVolunteerRequest> children = new ArrayList<SplitVolunteerRequest>();

    public List<SplitVolunteerRequest> getChildren() {
        return children;
    }

    public void setChildren(List<SplitVolunteerRequest> children) {
        this.children = children;
    }

    public void addChild(SplitVolunteerRequest child) {
        this.children.add(child);
    }



    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(Double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public Date getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(Date requiredBy) {
        this.requiredBy = requiredBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getAmountCollected() {
        return amountCollected;
    }

    public void setAmountCollected(Double amountCollected) {
        this.amountCollected = amountCollected;
    }

    public List<Date> getAdPostTime() {
        return adPostTime;
    }

    public void setAdPostTime(List<Date> adPostTime) {
        this.adPostTime = adPostTime;
    }
    
    public void addAdPostTime(Date date) {
        if(this.adPostTime == null) this.adPostTime = new ArrayList<Date>();
        this.adPostTime.add(date);
    }
    
}
