/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PayerEnterprise;
import Business.Organization.Organization;
import Business.Organization.PayeeOrganization;
import Business.Organization.PayerOrganization;
import Business.UserAccount.UserAccount;
import userinterface.LabAssistantRole.EnvironmentalistWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.NgoRole.NgoWorkAreaJPanel;
import userinterface.PayerRole.PayerWorkAreaJPanel;

/**
 *
 * @author apple
 */
public class PayerRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PayerWorkAreaJPanel(userProcessContainer, account, (PayerOrganization)organization, enterprise);
    }
    
    @Override
    public String toString(){
        return "Payer";
    }
    
}
