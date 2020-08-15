/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import org.apache.log4j.Logger;
import userinterface.MainJFrame;

/**
 * Email sender Runnable class which can be used to send emails in a multithreaded approach
 * @author Floyed Pinto
 */
public class EmailSenderRunnable implements Runnable{

    private final String receiverEmail;
    private final String messageContent;
    private final String subject;
    
    static final Logger logger = Logger.getLogger(EmailSenderRunnable.class);

    
    public EmailSenderRunnable(String receiverEmail, String messageContent
            ,String subject){
        this.receiverEmail = receiverEmail;
        this.messageContent = messageContent;
        this.subject = subject;
    }
    
    @Override
    public void run() {
        
        logger.info("Sending email to user: "+receiverEmail);
        
        String res = BusinessUtils.sendEmail(receiverEmail, messageContent, subject);
        
        logger.info("Sending email to user: " + receiverEmail + " "+res);
    }
    
}
