/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import Src.DBConnection;

import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Keerththan
 */
public class JobAllocation extends javax.swing.JFrame {

    Connection con= null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    

    /**
     * Creates new form JobAllocation
     */
    public JobAllocation() throws SQLException {
        initComponents();
        con = DBConnection.conntion();
        updatevehicleNoCombo();
        
        updateempIDCombo();
        
        tableload();
        this.setLocationRelativeTo(null) ;
       
    }
//repair
    private void updatevehicleNoCombo() {
        String sql = "select CusVehicleNO  from  customert where  CusVehicleNO  not in (select FK_CusVehicleNO from joballocation ) ";

        try {

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                vehicleNoCombo.addItem(rs.getString(1));
            }
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
//repair
    private void updateempIDCombo() {
        String sql = "select EmployeeID  from employeet where EmployeeID    not in (select FK_EmployeeID from joballocation ) ";

        try {

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                empIDCombo.addItem(rs.getString(1));
            }
            pst.close();
            rs.close();

        } catch (SQLException e) {
            e.getStackTrace();
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

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empNameTxt = new javax.swing.JTextField();
        allocateBtn = new javax.swing.JButton();
        AllocateExitBtn = new javax.swing.JButton();
        vehicleNoCombo = new javax.swing.JComboBox<>();
        jDateChoo = new com.toedter.calendar.JDateChooser();
        empIDCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee ID");
        jPanel.add(jLabel1);
        jLabel1.setBounds(220, 40, 120, 19);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee Name");
        jPanel.add(jLabel2);
        jLabel2.setBounds(220, 80, 140, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Vehicle No");
        jPanel.add(jLabel3);
        jLabel3.setBounds(220, 130, 208, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Issue Date");
        jPanel.add(jLabel4);
        jLabel4.setBounds(220, 180, 100, 20);

        empNameTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        empNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empNameTxtMouseClicked(evt);
            }
        });
        empNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNameTxtActionPerformed(evt);
            }
        });
        jPanel.add(empNameTxt);
        empNameTxt.setBounds(390, 90, 160, 20);

        allocateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        allocateBtn.setText("Allocate");
        allocateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allocateBtnActionPerformed(evt);
            }
        });
        jPanel.add(allocateBtn);
        allocateBtn.setBounds(300, 230, 90, 30);

        AllocateExitBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AllocateExitBtn.setText(" Exit");
        AllocateExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllocateExitBtnActionPerformed(evt);
            }
        });
        jPanel.add(AllocateExitBtn);
        AllocateExitBtn.setBounds(740, 510, 80, 30);

        vehicleNoCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vehicleNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select vehicleno---" }));
        vehicleNoCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehicleNoComboMouseClicked(evt);
            }
        });
        vehicleNoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleNoComboActionPerformed(evt);
            }
        });
        jPanel.add(vehicleNoCombo);
        vehicleNoCombo.setBounds(390, 140, 160, 30);
        jPanel.add(jDateChoo);
        jDateChoo.setBounds(390, 180, 160, 20);

        empIDCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        empIDCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select emID--" }));
        empIDCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empIDComboItemStateChanged(evt);
            }
        });
        empIDCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empIDComboMouseClicked(evt);
            }
        });
        empIDCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empIDComboActionPerformed(evt);
            }
        });
        jPanel.add(empIDCombo);
        empIDCombo.setBounds(390, 40, 160, 30);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CusVehicleNO ", "EmployeeID", "issuedate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        jPanel.add(jScrollPane2);
        jScrollPane2.setBounds(220, 280, 560, 186);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Allocation");
        jPanel.add(jLabel6);
        jLabel6.setBounds(30, 250, 156, 39);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Job ");
        jPanel.add(jLabel7);
        jLabel7.setBounds(40, 190, 86, 52);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/111-1111092_blue-grey-wallpaper-blue-and-grey-gradient.png"))); // NOI18N
        jPanel.add(jLabel5);
        jLabel5.setBounds(0, 0, 160, 600);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Job Alocc.jpg"))); // NOI18N
        jPanel.add(jLabel8);
        jLabel8.setBounds(160, 0, 680, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMouseClicked

    private void empIDComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empIDComboActionPerformed

    }//GEN-LAST:event_empIDComboActionPerformed

//repair
    private void empIDComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empIDComboMouseClicked
     // TODO add your handling code here:

             String n = empIDCombo.getSelectedItem().toString();
        String sql = "select EmployeeName from employeet where EmployeeID = '" + n + "'";
        try {

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {

                empNameTxt.setText(rs.getString(1));
                //JOptionPane.showMessageDialog(rootPane, rs.getInt(1));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_empIDComboMouseClicked

    private void empIDComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_empIDComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_empIDComboItemStateChanged

    private void vehicleNoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleNoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleNoComboActionPerformed

    private void vehicleNoComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehicleNoComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleNoComboMouseClicked

    private void AllocateExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllocateExitBtnActionPerformed
        try {
            // TODO add your handling code here:
            new Menu().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JobAllocation.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_AllocateExitBtnActionPerformed

    private void allocateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allocateBtnActionPerformed
        // TODO add your handling code here:

        //repair
        try
        {
     
        String CusVehicleNO = vehicleNoCombo.getSelectedItem().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String sdate = sdf.format(jDateChoo.getDate());
        //String date = jDateChoo.getDateFormatString();
        String EmployeeID = empIDCombo.getSelectedItem().toString();
        //int  emid=Integer.parseInt(empid.getText());

        
        String qu = "insert into joballocation (FK_CusVehicleNO,FK_EmployeeID,IssueDate) values (?,?,?)";
        try {
            pst = con.prepareStatement(qu);
            pst.setString(1, CusVehicleNO);
            pst.setString(2, EmployeeID);
            pst.setString(3, sdate);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Allready added ");
        }
        tableload();
       
      
        }catch(NullPointerException e )
        {
            JOptionPane.showMessageDialog(rootPane,"enter the all data");
        }
    }//GEN-LAST:event_allocateBtnActionPerformed

    private void empNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNameTxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_empNameTxtActionPerformed

    private void empNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empNameTxtMouseClicked
        // TODO add your handling code here:
          String n = empIDCombo.getSelectedItem().toString();
        String sql = "select EmployeeName from employeet where EmployeeID = '" + n + "'";
        try {

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {

                empNameTxt.setText(rs.getString(1));
                //JOptionPane.showMessageDialog(rootPane, rs.getInt(1));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        
    }//GEN-LAST:event_empNameTxtMouseClicked

    
     
    public void tableload() {
        String sql = "select FK_CusVehicleNO ,FK_EmployeeID  ,IssueDate  from joballocation ";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
    }
    
    
    
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JobAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JobAllocation().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JobAllocation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllocateExitBtn;
    private javax.swing.JButton allocateBtn;
    private javax.swing.JComboBox<String> empIDCombo;
    private javax.swing.JTextField empNameTxt;
    private com.toedter.calendar.JDateChooser jDateChoo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> vehicleNoCombo;
    // End of variables declaration//GEN-END:variables
}
