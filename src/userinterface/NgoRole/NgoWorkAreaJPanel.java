/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NgoRole;

import Business.Enterprise.Enterprise;
import Business.Organization.PayeeOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Application.Application;
import Business.EcoSystem;
import Business.Organization.FundRaiserOrganization;
import Business.Organization.Organization;
import Business.Utils.BusinessUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Business.Utils.BusinessStatus;
import com.restfb.types.send.SettingTypeEnum;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import userinterface.BackgroundCheckRole.BackgroundCheckWorkAreaJPanel;
import userinterface.BackgroundCheckRole.BackgroundTakeActionJPanel;
import userinterface.WalletDialogBox.TopUp;
//for email

/**
 *
 * @author apple
 */
public class NgoWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PayeeWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PayeeOrganization payeeOrg;
    private FundRaiserOrganization fundRaiserOrganization;
    private EcoSystem business;
    private String orgType;
    
    public NgoWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, FundRaiserOrganization fundRaiserOrganization, 
            Enterprise enterprise) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.fundRaiserOrganization = fundRaiserOrganization;
        this.orgType = "fr";
        this.populateUI();
        jButton1.setVisible(true);
    }
    
    public NgoWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, 
        PayeeOrganization payeeOrganization, Enterprise enterprise,  EcoSystem business) {
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.payeeOrg = payeeOrganization;
        this.business = business;
        this.orgType = "ngo";
        this.populateUI();   
        jButton1.setVisible(false);
    }
    
    private void populateUI() {
        initComponents();
        
        if(this.orgType.equals("ngo"))
        //Welcome user
        welcomeLbl.setText("Welcome "+this.userAccount.getEmployee().getName()+"!");
        
        //Populating the combo box
        for(int i=0;i<=12;i++){
            comboPayeeReq.addItem(BusinessStatus.values()[i].toString());
        }
        
        //validating the date
        dataResolveDate.setMinSelectableDate(new Date());
        
        //populating the wallet amount
        lblWalletAmt.setText("Wallet money: "+Double.toString(this.userAccount.getWalletMoney()));
        
        populateTable();
    }
    
    public void refresh(){
        lblWalletAmt.setText("Wallet money: "+Double.toString(userAccount.getWalletMoney()));
    }
    
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblPayeeRequests.getModel();
        
        model.setRowCount(0);
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        if(orgType.equals("ngo")) {
            for(WorkRequest request : payeeOrg.getWorkQueue().getWorkRequestList()){
            
                if((request.getSender().getUsername()).equals(userAccount.getUsername())){
                    Object[] row = new Object[8];
                    row[0] = request.getSender().getEmployee().getName();
                    row[1] = ((Application)request).getCause();
                    row[2] = dateFormat.format(request.getRequestDate());
                    if(((Application)request).getRequiredBy() != null){
                        row[3] = dateFormat.format(((Application)request).getRequiredBy());
                    }
                    row[4] = request.getStatus();
                    row[5] = ((Application)request).getAmountRequested();
                    row[6] = ((Application)request).getAmountCollected();
                    row[7] = ((Application)request).getAmountRequired();
                    model.addRow(row);
                }
            }
        }
        else {
            for(WorkRequest request : fundRaiserOrganization.getWorkQueue().getWorkRequestList()){
            
                if((request.getSender().getUsername()).equals(userAccount.getUsername()) ){
                    Object[] row = new Object[8];
                    row[0] = request.getSender().getEmployee().getName();
                    row[1] = ((Application)request).getCause();
                    row[2] = dateFormat.format(request.getRequestDate());
                    if(((Application)request).getRequiredBy() != null){
                        row[3] = dateFormat.format(((Application)request).getRequiredBy());
                    }
                    row[4] = request.getStatus();
                    row[5] = ((Application)request).getAmountRequested();
                    row[6] = ((Application)request).getAmountCollected();
                    row[7] = ((Application)request).getAmountRequired();
                    model.addRow(row);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayeeRequests = new javax.swing.JTable();
        lblSubmit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtAmtRequired = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCause = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        comboPayeeReq = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblWalletAmt = new javax.swing.JLabel();
        btnTopUp = new javax.swing.JButton();
        lblContactEmail = new javax.swing.JLabel();
        txtContactEmail = new javax.swing.JTextField();
        dataResolveDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(null);

        welcomeLbl.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        welcomeLbl.setText("Welcome");
        add(welcomeLbl);
        welcomeLbl.setBounds(80, 40, 327, 22);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Your previous applications");
        add(jLabel1);
        jLabel1.setBounds(80, 80, 250, 22);

        tblPayeeRequests.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tblPayeeRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Payee", "Cause", "Requested Date", "Resolution Date", "Status", "Amount Requested", "Amount Collected", "Amount Required"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPayeeRequests);

        add(jScrollPane1);
        jScrollPane1.setBounds(80, 110, 1092, 160);

        lblSubmit.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblSubmit.setText("Submit new application");
        add(lblSubmit);
        lblSubmit.setBounds(470, 310, 219, 22);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel2.setText("Cause*");
        add(jLabel2);
        jLabel2.setBounds(370, 390, 50, 17);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel4.setText("Amount required by*");
        add(jLabel4);
        jLabel4.setBounds(270, 500, 148, 17);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel5.setText("Description*");
        add(jLabel5);
        jLabel5.setBounds(320, 620, 100, 17);

        btnSubmit.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit);
        btnSubmit.setBounds(500, 710, 189, 44);
        add(txtAmtRequired);
        txtAmtRequired.setBounds(440, 450, 341, 26);

        txtCause.setColumns(20);
        txtCause.setRows(5);
        jScrollPane2.setViewportView(txtCause);

        add(jScrollPane2);
        jScrollPane2.setBounds(440, 360, 341, 84);

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane3.setViewportView(txtDesc);

        add(jScrollPane3);
        jScrollPane3.setBounds(440, 600, 341, 84);

        comboPayeeReq.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPayeeReqItemStateChanged(evt);
            }
        });
        comboPayeeReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPayeeReqActionPerformed(evt);
            }
        });
        add(comboPayeeReq);
        comboPayeeReq.setBounds(1000, 80, 173, 27);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel6.setText("Search by Status");
        add(jLabel6);
        jLabel6.setBounds(870, 80, 112, 17);

        lblWalletAmt.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        lblWalletAmt.setText("Wallet Amount: $x");
        add(lblWalletAmt);
        lblWalletAmt.setBounds(1030, 40, 145, 19);

        btnTopUp.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnTopUp.setText("TopUp Wallet");
        btnTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUpActionPerformed(evt);
            }
        });
        add(btnTopUp);
        btnTopUp.setBounds(850, 30, 131, 38);

        lblContactEmail.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        lblContactEmail.setText("Contact email*");
        add(lblContactEmail);
        lblContactEmail.setBounds(310, 550, 110, 17);

        txtContactEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactEmailActionPerformed(evt);
            }
        });
        add(txtContactEmail);
        txtContactEmail.setBounds(440, 550, 341, 26);
        add(dataResolveDate);
        dataResolveDate.setBounds(440, 500, 341, 26);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabel8.setText("Amount required in USD*");
        add(jLabel8);
        jLabel8.setBounds(250, 460, 174, 17);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(110, 770, 80, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/apple/Downloads/images-for-fr/bccheck1.jpg")); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1510, 1120);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        if(txtAmtRequired.getText().equals("") || txtCause.getText().equals("") || txtDesc.getText().equals("") || dataResolveDate.getDate()== null){
            JOptionPane.showMessageDialog(null, "Please enter all the fields!");
            return;
        }
        
        try{
            Integer.parseInt(txtAmtRequired.getText());
            if(Integer.parseInt(txtAmtRequired.getText()) <= 0){
                JOptionPane.showMessageDialog(null, txtAmtRequired.getText() + " is not a valid amount!");
                return;
            }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, txtAmtRequired.getText() + "is not a valid number! Please enter the amount!");
                populateTable();
                return;
        }
        
        //BusinessUtils.sendEmail(txtContactEmail.getText(),"Your application for "+txtCause.getText()+" cause is successfully submitted!","Information regarding your new Fund Request");
        
        //Setting the user email
        userAccount.setEmail(txtContactEmail.getText());
        
        if(BusinessUtils.sendEmail(txtContactEmail.getText()
                ,"Your application for "+txtCause.getText()+" cause is successfully submitted!","Information regarding your new Fund Request").equals("unsuccessful")){
                txtAmtRequired.setText("");
            return;
        } 
        
        Application app=new Application();
        
        app.setCause(txtCause.getText());
        app.setAmountRequested(Double.parseDouble(txtAmtRequired.getText()));
        app.setDescription(txtDesc.getText());
        app.setMessage("");
        app.setSender(this.userAccount);
        app.setRequiredBy(dataResolveDate.getDate());
        app.setStatus(BusinessStatus.Submitted.getValue());
        app.setAmountRequired(app.getAmountRequested());
        app.setPayeeEmail(txtContactEmail.getText());
        
        
        if(orgType.equals("ngo")) {
            payeeOrg.getWorkQueue().addWorkRequest(app);
            BusinessUtils.addToNextQueue(payeeOrg, Organization.Type.FundRainser, app, this.business, this.enterprise);
        }
        else {
            fundRaiserOrganization.getWorkQueue().addWorkRequest(app);
//            BusinessUtils.addToNextQueue(fundRaiserOrganization, Organization.Type.FundRainser, app, this.business, this.enterprise);
        }        
        JOptionPane.showMessageDialog(null, "Application successfully submitted!");
        
        //clearing the fields
        dataResolveDate.setDateFormatString("");
        txtAmtRequired.setText("");
        txtCause.setText("");
        txtDesc.setText("");
        txtContactEmail.setText("");

        //populating the table again
         populateTable();
        
        
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    
    private void comboPayeeReqItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPayeeReqItemStateChanged
        // TODO add your handling code here:
        if(comboPayeeReq.getSelectedItem().equals("Submitted")){
            filterPopulateTable(BusinessStatus.Submitted.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.BckgrdChkReq.getValue())){
            filterPopulateTable(BusinessStatus.BckgrdChkReq.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.BckgrdChkApp.getValue())){
            filterPopulateTable(BusinessStatus.BckgrdChkApp.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.BckgrdChkRej.getValue())){
            filterPopulateTable(BusinessStatus.BckgrdChkRej.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.Advertised.getValue())){
            filterPopulateTable(BusinessStatus.Advertised.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.InProgress.getValue())){
            filterPopulateTable(BusinessStatus.InProgress.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.Fulfilled.getValue())){
            filterPopulateTable(BusinessStatus.Fulfilled.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.UnFulfilled.getValue())){
            filterPopulateTable(BusinessStatus.UnFulfilled.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.ReadyToPick.getValue())){
            filterPopulateTable(BusinessStatus.ReadyToPick.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.VInProgress.getValue())){
            filterPopulateTable(BusinessStatus.VInProgress.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.VFulfilled.getValue())){
            filterPopulateTable(BusinessStatus.VFulfilled.getValue());
        }else if(comboPayeeReq.getSelectedItem().equals(BusinessStatus.VUnfulfilled.getValue())){
            filterPopulateTable(BusinessStatus.VUnfulfilled.getValue());
        }else{
            populateTable();
        }
    }//GEN-LAST:event_comboPayeeReqItemStateChanged

    
    private void filterPopulateTable(String s){
        
        //BusinessStatus.BckgrdChkReq.getValue()
        
        DefaultTableModel model = (DefaultTableModel)tblPayeeRequests.getModel();
        
        model.setRowCount(0);
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        for(WorkRequest request : payeeOrg.getWorkQueue().getWorkRequestList()){
            if(request.getStatus().equals(s)){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = ((Application)request).getCause();
            row[2] = dateFormat.format(request.getRequestDate());
            if(((Application)request).getRequiredBy() != null){
                row[3] = dateFormat.format(((Application)request).getRequiredBy());
            }
            row[4] = request.getStatus();
            row[5] = ((Application)request).getAmountRequested();
            
            model.addRow(row);
            }
        }
        
    }
    
    private void comboPayeeReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPayeeReqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPayeeReqActionPerformed

    private void btnTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUpActionPerformed
        // TODO add your handling code here:
        
        TopUp t=new TopUp(this.userAccount,this);
        t.setVisible(true);
    }//GEN-LAST:event_btnTopUpActionPerformed

    private void txtContactEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactEmailActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_txtContactEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnTopUp;
    private javax.swing.JComboBox<String> comboPayeeReq;
    private com.toedter.calendar.JDateChooser dataResolveDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblContactEmail;
    private javax.swing.JLabel lblSubmit;
    private javax.swing.JLabel lblWalletAmt;
    private javax.swing.JTable tblPayeeRequests;
    private javax.swing.JTextField txtAmtRequired;
    private javax.swing.JTextArea txtCause;
    private javax.swing.JTextField txtContactEmail;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables
    int count=0;
}

