/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class FunRaiserEnterprise extends Enterprise{
    
     public FunRaiserEnterprise(String name){
        super(name,EnterpriseType.FundRaiser);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
