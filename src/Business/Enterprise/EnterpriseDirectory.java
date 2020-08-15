/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Payee){
            enterprise=new PayeeEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.FundRaiser){
            enterprise=new FunRaiserEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type==Enterprise.EnterpriseType.DigitalMarketing){
            enterprise=new DigitalMarketingEnterprise(name);
            enterpriseList.add(enterprise);
//        }else if(type==Enterprise.EnterpriseType.Auction){
//            enterprise=new AuctionEnterprise(name);
//            enterpriseList.add(enterprise);
       }else if(type==Enterprise.EnterpriseType.Payer){
            enterprise=new PayerEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
