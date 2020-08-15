/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        this.workRequestList = new ArrayList();
    }
    
    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public void addWorkRequest(WorkRequest w){
        workRequestList.add(w);
    }
    
}