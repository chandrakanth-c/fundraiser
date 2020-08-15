/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PayeeOrganization;
import Business.UserAccount.UserAccount;
import userinterface.LabAssistantRole.EnvironmentalistWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.NgoRole.NgoWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class EnvironmentalistRole extends Role {

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
//        return new EnvironmentalistWorkAreaJPanel(userProcessContainer, account, organization, business);
//    }
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NgoWorkAreaJPanel(userProcessContainer, account, (PayeeOrganization)organization, enterprise, business);
    }
    
    
    @Override
    public String toString(){
        return "Environmentalist";
    }
}
