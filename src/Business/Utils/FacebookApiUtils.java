/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Group;
import org.apache.log4j.Logger;
import userinterface.MainJFrame;


/**
 *
 * @author Floyed Pinto
 */
public class FacebookApiUtils {
     static final Logger logger = Logger.getLogger(EmailSenderRunnable.class);
    
    public static void postToFacebook(String message){
        
        String accessToken = "EAAk8M1u3UCQBABOloZAiAMZA74dtt5Cut1QxSdv2SZA8gFqyRD5j7Cbi5IW5Q6hiZCl9M0pZCKlaCW2xZCLtTr7JyRj2BE0ZCQ1UwW1Er5eSaDPFP1fdYZComWZCs6xldZCBD0dttZBLbET42F4FXEP8Po4Yl3O6cZBQysxvX42HkjjfFajHBZCOcUbd2VU4kksnZAAM3AL0HKepfSNwrJBZAUQMAOzmWni66eT5F9dnGuIs9DJcr0v9dNEN3Ds";
        
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_5_0);
        
        Connection<Group> result = fbClient.fetchConnection("me/groups", Group.class);
        
        for(List<Group> feedPage : result ){
            
            for(Group page : feedPage){
                
                logger.info("page "+page);
                
                FacebookType res = fbClient.publish(page.getId()+"/feed", FacebookType.class, Parameter.with("message",message));

                logger.info("Post response "+res.getId());                
            }
        }
    }
}
