/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FundRaiserOrganization;
import Business.Organization.Organization;
import Business.Organization.PayerOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FundRaiserRole.FundRaiserWorkAreaJPanel;
import userinterface.PayerRole.PayerWorkAreaJPanel;

/**
 *
 * @author pavanrao
 */
public class FundRaiserOrgRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new FundRaiserWorkAreaJPanel(userProcessContainer, account, (FundRaiserOrganization)organization, enterprise);
    }
    
    @Override
    public String toString(){
        return "Fundraiser Organization";
    }   
}
