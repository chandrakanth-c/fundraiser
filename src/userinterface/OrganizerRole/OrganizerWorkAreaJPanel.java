/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrganizerRole;

import Business.Application.Application;
import Business.Application.SplitVolunteerRequest;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FundRaiserOrganization;
import Business.UserAccount.OrganizerAccount;
import Business.UserAccount.UserAccount;
import Business.UserAccount.VolunteerAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.apache.log4j.Logger;
import userinterface.WalletDialogBox.TopUp;

/**
 *
 * @author raunak
 */
public class OrganizerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private FundRaiserOrganization fundRaiserOrg;
    private EcoSystem business;

    static final Logger logger = Logger.getLogger(OrganizerWorkAreaJPanel.class);

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public OrganizerWorkAreaJPanel(JPanel userProcessContainer,
            UserAccount account, FundRaiserOrganization fundRaiserOrg,
            Enterprise enterprise, EcoSystem business) {
        initComponents();
        
        //populating the wallet amount
        lblWalletAmt.setText("Wallet money: "+Double.toString(account.getWalletMoney()));
        
        //welcome user
        lblWelcome.setText("Welcome "+account.getEmployee().getName()+"!");

        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.fundRaiserOrg = fundRaiserOrg;
        this.business = business;
        addDynamicComponents(fundRaiserOrg.getWorkQueue().getWorkRequestList());

    }
    
    public void refresh(){
        lblWalletAmt.setText("Wallet money: "+Double.toString(userAccount.getWalletMoney()));
    }

    public void refreshPage() {
        addDynamicComponents(fundRaiserOrg.getWorkQueue().getWorkRequestList());
    }

    private void addDynamicComponents(ArrayList<WorkRequest> workRequestList) {
        jPanel1.removeAll();
        jPanel1.setPreferredSize(new Dimension(1100, 1700));
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 1000, 1200);
        panel.setBackground(new Color(153,204,255));//new Color(0,0,255)
        int x = 0, y = 0;
        final ArrayList<WorkRequest> filteredWorkRequestList = new ArrayList<WorkRequest>();
        for (WorkRequest wr : workRequestList) {
            if (!(wr instanceof SplitVolunteerRequest)
                    && (wr.getStatus().equals(Business.Utils.BusinessStatus.Advertised.getValue())
                    || wr.getStatus().equals(Business.Utils.BusinessStatus.InProgress.getValue())
                    || wr.getStatus().equals(Business.Utils.BusinessStatus.Fulfilled.getValue())
                    || wr.getStatus().equals(Business.Utils.BusinessStatus.UnFulfilled.getValue()))) {
                filteredWorkRequestList.add(wr);
            }
        }
        for (int i = 0; i < filteredWorkRequestList.size(); i++) {
            final int p = i;
            JPanel pa = new JPanel();
            pa.setLayout(new GridLayout(0, 2));
//           GridLayout experimentLayout = new GridLayout(0,2);
            pa.setBounds(x + 30, y + 30, 330, 350);
            pa.setPreferredSize(new Dimension(300, 300));
            JLabel lab1 = new JLabel("Payee");
            lab1.setPreferredSize(new Dimension(250, 80));
            JLabel lab2 = new JLabel(filteredWorkRequestList.get(i).getSender().getEmployee().getName());
            lab2.setPreferredSize(new Dimension(250, 80));
            JLabel lab3 = new JLabel("Amount Requested");
            lab3.setPreferredSize(new Dimension(250, 80));
            JLabel lab4 = new JLabel(Double.toString(((Application) filteredWorkRequestList.get(i)).getAmountRequested()));
            lab4.setPreferredSize(new Dimension(250, 80));
            JLabel lab5 = new JLabel("Amount Required By");
            Date date = ((Application) filteredWorkRequestList.get(i)).getRequiredBy();
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = dateFormat.format(date);
            JLabel lab6 = new JLabel(strDate);
            JLabel lab7 = new JLabel("Status");
            String appStatus = ((Application) filteredWorkRequestList.get(i)).getStatus();
            JLabel lab8 = new JLabel(appStatus);
            pa.add(lab1);
            pa.add(lab2);
            pa.add(lab3);
            pa.add(lab4);
            pa.add(lab5);
            pa.add(lab6);
            pa.add(lab7);
            pa.add(lab8);
            String btnLabel = "";
            if (appStatus.equals(Business.Utils.BusinessStatus.Advertised.getValue())) {
                btnLabel = "Take Action";
            } else {
                btnLabel = "View Status";
            }

            JButton b1 = new JButton(btnLabel);
            b1.setBackground(Color.YELLOW);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    userProcessContainer.add(new AdvertisedWorkAreaJPanel(userProcessContainer,
                            filteredWorkRequestList.get(p), userAccount, fundRaiserOrg, enterprise, business));
                    layout.next(userProcessContainer);
                }
            });
            
            pa.add(b1);

            panel.add(pa);
        }
        
        logger.info("Adding panels!");

        jPanel1.add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblWalletAmt = new javax.swing.JLabel();
        btnTopUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setText("VOLUNTEERS UNDER ME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1100, 60, 190, 53);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Welcome,");
        add(lblWelcome);
        lblWelcome.setBounds(46, 26, 326, 47);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(50, 130, 1230, 690);

        lblWalletAmt.setText("Wallet Amount: $x");
        add(lblWalletAmt);
        lblWalletAmt.setBounds(880, 40, 124, 19);

        btnTopUp.setText("TopUp Wallet");
        btnTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUpActionPerformed(evt);
            }
        });
        add(btnTopUp);
        btnTopUp.setBounds(880, 70, 108, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/apple/Downloads/images-for-fr/volvol.jpeg")); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -120, 1770, 1250);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        /**
         * if(role.toString().equals("Volunteer")) {
            organization.getUserAccountDirectory().createVolunteerAccount(userName, password, employee, role, this.organizerOfVolunteer);
        }
         */
        List<VolunteerAccount> volList = new ArrayList<VolunteerAccount>();
        for(OrganizerAccount org: fundRaiserOrg.getUserAccountDirectory().getOrganizerAccountList()) {
            if(org.getEmployee().getId() == (userAccount.getEmployee().getId())) {
                volList = org.getVolunteerList();
            }
        }
//        List<VolunteerAccount> volList = fundRaiserOrg.getUserAccountDirectory().getOrganizerAccountList().get(0).getVolunteerList();
        userProcessContainer.add(new VolunteerPerformanceJPanel(userProcessContainer,fundRaiserOrg, userAccount, volList));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUpActionPerformed
        // TODO add your handling code here:

        TopUp t=new TopUp(this.userAccount,this);
        t.setVisible(true);
    }//GEN-LAST:event_btnTopUpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTopUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblWalletAmt;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
