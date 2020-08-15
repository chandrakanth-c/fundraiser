/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.WorkQueue.WorkRequest;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 * Utils class for all common business related operations
 * @author Floyed Pinto
 */
public class BusinessUtils {

    static final Logger logger = Logger.getLogger(BusinessUtils.class);

    /**
     * Adding a request to another queue
     * @param from - The request from 
     * @param to - The request to
     * @param workRequest - The workrequest which has to be addred to the @param to
     * @param business - the current business
     * @param enterprise - the business enterprise
     */
    public static void addToNextQueue(Organization from, 
            Organization.Type to, WorkRequest workRequest, 
            EcoSystem business, Enterprise enterprise) {

        Network n = null;

        for (Network net : business.getNetworkList()) {

            if (net.getEnterpriseDirectory().getEnterpriseList().contains(enterprise)) {
                n = net;
            }
        }

        for (Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()) {

            for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {

                if (org.getName().equals(to.getValue())) {
                    if(!org.getWorkQueue().getWorkRequestList().contains(workRequest))
                    org.getWorkQueue().addWorkRequest(workRequest);           
                }
            }
        }
    }
    
    
    public static String sendEmail(String to,String msg, String subject){
        
        String toEmail = to;
        String fromEmail="fundcauseorg@gmail.com";
        
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        Session session=Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication("fundcauseorg@gmail.com", "Fund@2019!@");  
            }
        });
        
        try{
            
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
            logger.info("Sending email to "+ to+ " Successful!");
            return "successfull";
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "Invalid email!");
            logger.info("Sending email to "+ to+ " Failed ::"+ ex.toString());
            return "unsuccessful";
            
        }
        
    }
    
    /**
     * Multi Threaded approach for sending multiple emails
     * @param emails - List of emails which have to be sent to
     * @param content - content of each of the emails
     * @param subject - subject of each of the emails
     */
    public static void sendMultipleEmails(List<String> emails, String content, String subject){
        
        logger.info("Multithreaded email sending initiated to emails: "+emails);
        
        for(String email : emails){
            
            //Creating new threads for each email send request
            Thread thread = new Thread(new EmailSenderRunnable(email,content,subject));
            
            //starting the thread
            thread.start();
        }
    }

}
