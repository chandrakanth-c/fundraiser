/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    private ArrayList<OrganizerAccount> organizerAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
        organizerAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public ArrayList<OrganizerAccount> getOrganizerAccountList() {
        return organizerAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        for (OrganizerAccount oa: organizerAccountList)
            if (oa.getUsername().equals(username) && oa.getPassword().equals(password)){
                return oa;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public VolunteerAccount createVolunteerAccount(String username, String password, Employee employee, Role role, OrganizerAccount organizer) {
        VolunteerAccount volunteerAccount = new VolunteerAccount();
        volunteerAccount.setOrganizer(organizer);
        volunteerAccount.setUsername(username);
        volunteerAccount.setPassword(password);
        volunteerAccount.setRole(role);
        volunteerAccount.setEmployee(employee);
        userAccountList.add(volunteerAccount);
        organizer.addVolunteerToList(volunteerAccount);
        return volunteerAccount;
    }
    
    public OrganizerAccount createOrganizerAccount(String username, String password, Employee employee, Role role) {
        OrganizerAccount organizerAccount = new OrganizerAccount();
        organizerAccount.setUsername(username);
        organizerAccount.setPassword(password);
        organizerAccount.setRole(role);
        organizerAccount.setEmployee(employee);
        organizerAccount.setOrganizerId();
        organizerAccountList.add(organizerAccount);
        return organizerAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
