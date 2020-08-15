/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Application.SplitVolunteerRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavanrao
 */
public class VolunteerAccount extends UserAccount {
    OrganizerAccount organizer;

    private List<SplitVolunteerRequest> assignedSplitRequestList = new ArrayList<SplitVolunteerRequest>();
    
    public OrganizerAccount getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerAccount organizer) {
        this.organizer = organizer;
    }

    public List<SplitVolunteerRequest> getAssignedSplitRequestList() {
        return assignedSplitRequestList;
    }

    public void setAssignedSplitRequestList(List<SplitVolunteerRequest> assignedSplitRequestList) {
        this.assignedSplitRequestList = assignedSplitRequestList;
    }
    
    public void addAssignedSplitRequestList(SplitVolunteerRequest splitVolunteerRequest) {
        
        if(assignedSplitRequestList == null){
            assignedSplitRequestList = new ArrayList<SplitVolunteerRequest>();
        }
        this.assignedSplitRequestList.add(splitVolunteerRequest);
    }
    
}
