/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PayeeOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LabAssistantRole.EnvironmentalistWorkAreaJPanel;
import userinterface.NgoRole.NgoWorkAreaJPanel;

/**
 *
 * @author apple
 */
public class CommonPeopleRole extends Role{
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NgoWorkAreaJPanel(userProcessContainer, account, (PayeeOrganization)organization, enterprise, business);
    }
    
    @Override
    public String toString(){
        return "Common People";
    }
}
