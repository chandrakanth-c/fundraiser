/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.PayerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class PayerOrganization extends Organization{
    public PayerOrganization() {
        super(Organization.Type.Payer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PayerRole());
        return roles;
    }
}
