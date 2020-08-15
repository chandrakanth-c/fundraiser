/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BackgroundCheckExecutiveRole;
import Business.Role.FundRaiserOrgRole;
import Business.Role.NgoRole;
import Business.Role.OrganizerRole;
import Business.Role.Role;
import Business.Role.VolunteerRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class FundRaiserOrganization extends Organization{

    public FundRaiserOrganization() {
        super(Organization.Type.FundRainser.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new OrganizerRole());
        roles.add(new VolunteerRole());
        roles.add(new BackgroundCheckExecutiveRole());
        roles.add(new FundRaiserOrgRole());
        return roles;
    }
     
}