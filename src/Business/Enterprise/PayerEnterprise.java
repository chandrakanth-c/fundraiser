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
public class PayerEnterprise extends Enterprise{
    
    public PayerEnterprise(String name){
        super(name,EnterpriseType.Payer);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
