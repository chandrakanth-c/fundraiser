package userinterface.PayerRole;

import Business.Application.Application;
import Business.Application.SplitVolunteerRequest;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FundRaiserOrganization;
import Business.Organization.PayerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import userinterface.OrganizerRole.AdvertisedWorkAreaJPanel;
import userinterface.WalletDialogBox.TopUp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavanrao
 */
public class PayerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PayerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private PayerOrganization payerOrganization;
    private Enterprise enterprise;
    private EcoSystem business;
    private FundRaiserOrganization fundRaiserOrganization;
    public String orgType;
    
    public PayerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PayerOrganization payerOrganization, Enterprise enterprise) {
        this.userProcessContainer=userProcessContainer;
        this.account = account;
        this.payerOrganization = payerOrganization;
        this.enterprise = enterprise;
        this.orgType = "payer";
        initComponents();
        jButton3.setVisible(false);
        //welcome username
        jLabel1.setText("Welcome "+account.getEmployee().getName()+"!");
        
        //jButton2.setVisible(false);
        addDynamicComponentsForPayer();
    }
    
    public PayerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FundRaiserOrganization fundRaiserOrganization, Enterprise enterprise) {
        this.userProcessContainer=userProcessContainer;
        this.account = account;
        this.fundRaiserOrganization = fundRaiserOrganization;
        this.enterprise = enterprise;
        this.orgType = "fr";
        initComponents();
        jButton3.setVisible(true);
        addDynamicComponentsForOthers();
    }
    
    public void addDynamicComponentsForOthers() {
        final ArrayList<WorkRequest> workRequestList = fundRaiserOrganization.getWorkQueue().getWorkRequestList();
        JPanel panel=new JPanel(); 
        panel.setBounds(10,10,1000,800);  
        panel.setBackground(new Color(153,204,255));
        int x=0, y=0;
        for(int i=0;i<workRequestList.size();i++){
            WorkRequest wr = (Application)workRequestList.get(i);
            if(wr.getStatus().equals(Business.Utils.BusinessStatus.Advertised.getValue()) ||
               wr.getStatus().equals(Business.Utils.BusinessStatus.InProgress.getValue()) &&
               !(wr instanceof SplitVolunteerRequest)) {
                final int p = i;
                JPanel pa = new JPanel();

                pa.setLayout(new GridLayout(0,2));
                pa.setBounds(x+30,y+30,330,350);
                pa.setPreferredSize(new Dimension(250,250));

                JLabel lab1 = new JLabel("Payee");
                JLabel lab2 = new JLabel(((Application)workRequestList.get(i)).getSender().getEmployee().getName());

                JLabel lab3 = new JLabel("Cause");
                JLabel lab4 = new JLabel(((Application)workRequestList.get(i)).getCause());

                JLabel lab5 = new JLabel("Amount required");
                JLabel lab6 = new JLabel(Double.toString((((Application)workRequestList.get(i)).getAmountRequired())));

                JLabel lab7 = new JLabel("Amount required by");
                Date date = ((Application) workRequestList.get(i)).getRequiredBy();
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String strDate = dateFormat.format(date);
                JLabel lab8 = new JLabel(strDate);

                pa.add(lab1);
                pa.add(lab2);
                pa.add(lab3);
                pa.add(lab4);
                pa.add(lab5);
                pa.add(lab6);
                pa.add(lab7);
                pa.add(lab8);
                JButton b1=new JButton("DONATE");
                b1.setBackground(Color.yellow);  
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                        try {
                            userProcessContainer.add(new PayerWorkRequestJPanel(userProcessContainer,
                                    workRequestList.get(p), account, enterprise));
                        } catch (IOException ex) {
                            Logger.getLogger(PayerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        layout.next(userProcessContainer);
                    }
                });
                pa.add(b1);
                panel.add(pa);
            }
        }
        jPanel3.add(panel); 
    }
    
    public void addDynamicComponentsForPayer() {
        final ArrayList<WorkRequest> workRequestList = payerOrganization.getWorkQueue().getWorkRequestList();
        JPanel panel=new JPanel(); 
        panel.setBounds(10,10,1000,800);  
        panel.setBackground(new Color(153,204,255));
        int x=0, y=0;
        for(int i=0;i<workRequestList.size();i++){
            if(((Application)workRequestList.get(i)).getStatus().equals(Business.Utils.BusinessStatus.Advertised.getValue()) ||
                 ((Application)workRequestList.get(i)).getStatus().equals(Business.Utils.BusinessStatus.InProgress.getValue())   ) {
                final int p = i;
                JPanel pa = new JPanel();

                pa.setLayout(new GridLayout(0,2));
                pa.setBounds(x+30,y+30,330,350);
                pa.setPreferredSize(new Dimension(250,250));

                JLabel lab1 = new JLabel("Payee");
                JLabel lab2 = new JLabel(((Application)workRequestList.get(i)).getSender().getEmployee().getName());

                JLabel lab3 = new JLabel("Cause");
                JLabel lab4 = new JLabel(((Application)workRequestList.get(i)).getCause());

                JLabel lab5 = new JLabel("Amount required");
                JLabel lab6 = new JLabel(Double.toString((((Application)workRequestList.get(i)).getAmountRequired())));

                JLabel lab7 = new JLabel("Amount required by");
                Date date = ((Application) workRequestList.get(i)).getRequiredBy();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                String strDate = dateFormat.format(date);
                JLabel lab8 = new JLabel(strDate);

                pa.add(lab1);
                pa.add(lab2);
                pa.add(lab3);
                pa.add(lab4);
                pa.add(lab5);
                pa.add(lab6);
                pa.add(lab7);
                pa.add(lab8);
                JButton b1=new JButton("DONATE");
                b1.setBackground(Color.yellow);  
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                        try {
                            userProcessContainer.add(new PayerWorkRequestJPanel(userProcessContainer,
                                    workRequestList.get(p), account, enterprise));
                        } catch (IOException ex) {
                            Logger.getLogger(PayerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        layout.next(userProcessContainer);
                    }
                });
                pa.add(b1);
                panel.add(pa);
            }
        }
        jPanel3.add(panel);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome, $UserName");
        add(jLabel1);
        jLabel1.setBounds(41, 36, 210, 44);

        jLabel2.setText("Wallet Amount: $0.0");
        add(jLabel2);
        jLabel2.setBounds(1048, 15, 134, 45);

        jButton1.setText("TopUp Wallet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1042, 66, 140, 53);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        add(jPanel3);
        jPanel3.setBounds(41, 172, 1150, 650);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(40, 870, 75, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/apple/Downloads/images-for-fr/volvol.jpeg")); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, -20, 1650, 1160);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TopUp t=new TopUp(this.account,this);
        t.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void refresh(){
        jLabel2.setText("Wallet money: "+Double.toString(account.getWalletMoney()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
