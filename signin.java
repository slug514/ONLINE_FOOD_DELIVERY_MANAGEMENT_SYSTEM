package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author abhis
 */
public class signin extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form signin
     */
    public signin() {
        initComponents();
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            //JOptionPane.showMessageDialog(this,"Driver Loaded!");
            try{
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##deepak","barca10118");
                //JOptionPane.showMessageDialog(this,"Connected to Oracle Database!");
            }
            catch(SQLException ex){
                Logger.getLogger(Restaurant_home.class.getName()).log(Level.SEVERE,null,ex);
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
            //this.restid=restid;
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Restaurant_home.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
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

        jLabel3 = new javax.swing.JLabel();
        usernametxtfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordtextfield = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Delivery Partners");
        jLabel3.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jLabel3ComponentRemoved(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernametxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtfieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernametxtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 78, 113, -1));

        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 56, -1, -1));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 112, -1, -1));

        passwordtextfield.setForeground(new java.awt.Color(102, 102, 102));
        passwordtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtextfieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 134, 113, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Delivery Partners");
        jLabel4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jLabel4ComponentRemoved(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 140, -1));

        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Not already a partner? ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 75, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-carousel-1-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 50, 660, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordtextfieldActionPerformed

    private void usernametxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtfieldActionPerformed

    private void jLabel3ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel3ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3ComponentRemoved

    private void jLabel4ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel4ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4ComponentRemoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            String emp_user = usernametxtfield.getText();
            String emp_pwd = passwordtextfield.getText();
            String sql = "select license_no from del_partners1 where emp_id like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,emp_user);
            rs = ps.executeQuery();
            int count=0;
            while(rs.next())
            {
                if(emp_pwd.equals(emp_user+rs.getString("license_no").substring(11)))
                {
                    JOptionPane.showMessageDialog(this,"Logged in");
                    count++;
                    Del_home dh = new Del_home(emp_user);
                    dh.show();
                    this.setVisible(false);
                }
                
            }
            if(count==0)
            {
                JOptionPane.showMessageDialog(this,"Invalid credentials");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DelPartner_signup ds = new DelPartner_signup();
        ds.show();
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField passwordtextfield;
    private javax.swing.JTextField usernametxtfield;
    // End of variables declaration//GEN-END:variables
}
