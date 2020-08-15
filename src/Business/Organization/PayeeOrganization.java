/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CommonPeopleRole;
import Business.Role.EnvironmentalistRole;
import Business.Role.NgoRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PayeeOrganization extends Organization{

    public PayeeOrganization() {
        super(Organization.Type.Payee.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NgoRole());
        roles.add(new EnvironmentalistRole());
        roles.add(new CommonPeopleRole());
        return roles;
    }
     
   
    
    
}
