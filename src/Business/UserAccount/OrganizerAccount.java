/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavanrao
 */
public class OrganizerAccount extends UserAccount {
    
    private static int organizerId=0;

    OrganizerAccount() {
        volunteerList = new ArrayList();
    }
    
    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId() {
        this.organizerId++;
    }
    private List<VolunteerAccount> volunteerList;

    public List<VolunteerAccount> getVolunteerList() {
        return volunteerList;
    }

    public void setVolunteerList(List<VolunteerAccount> volunteerList) {
        this.volunteerList = volunteerList;
    }
    
    public void addVolunteerToList(VolunteerAccount volunteer) {
        this.volunteerList.add(volunteer);
    }
}
