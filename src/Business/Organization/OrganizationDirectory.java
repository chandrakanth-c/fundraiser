/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.FunRaiserEnterprise;
import Business.Enterprise.PayeeEnterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Payee.getValue())){
            organization = new PayeeOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FundRainser.getValue())){
            organization = new FundRaiserOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.DigitalMarketing.getValue())){
            organization = new DigitalMarketingOrganisation();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Auction.getValue())){
            organization = new AuctionEmployeeOrganisation();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Payer.getValue())){
            organization = new PayerOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}