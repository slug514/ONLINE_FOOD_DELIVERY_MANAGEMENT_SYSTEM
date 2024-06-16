package com.mycompany.mavenproject2;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author silve
 */
public class DelPartner_signup extends javax.swing.JFrame {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form DelPartner_signup
     */
    public DelPartner_signup() {
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
            //this.restid="R00001";
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

        signupEmpname = new javax.swing.JTextField();
        signupEmpph = new javax.swing.JTextField();
        signupEmpdob = new javax.swing.JTextField();
        signupEmploc = new javax.swing.JTextField();
        signupEmplic = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(signupEmpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, -1));
        getContentPane().add(signupEmpph, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 150, -1));
        getContentPane().add(signupEmpdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 150, -1));
        getContentPane().add(signupEmploc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));
        getContentPane().add(signupEmplic, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, -1));

        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 61, 30));

        jLabel2.setText("Phone");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 61, 22));

        jLabel3.setText("DOB");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 61, 22));

        jLabel4.setText("Location");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 61, 22));

        jLabel5.setText("License_no.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 22));

        signup.setText("Sign up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 262, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 150, -1));

        jLabel6.setText("Join Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\advantage20.f8afd8d.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, -100, 800, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        try {
            String sql = " select concat('E',substr(concat('0000',cast(count(*)+1 as varchar(10))), -4)) as temp from del_partners1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            String temp = rs.getString("temp");
            String joinyear = jTextField1.getText();
            CallableStatement cstmt = con.prepareCall("{? = call base_sal(TO_DATE(?,'DD-MM-YYYY'))}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, joinyear);
            cstmt.execute();
            int basesal = cstmt.getInt(1);
            JOptionPane.showMessageDialog(this, basesal);
            cstmt.close();
            
            String sql1 = "insert into del_partners2 values(?,?)";
            ps = con.prepareStatement(sql1);
            ps.setString(1, joinyear);
            ps.setInt(2, basesal);
            ps.execute();
            String sql2 = "insert into del_partners1 values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql2);
            ps.setString(1, temp);
            ps.setString(2, signupEmpname.getText());
            ps.setString(4, signupEmpdob.getText());
            ps.setString(3, signupEmpph.getText());
            ps.setString(5, signupEmploc.getText());
            ps.setString(6, signupEmplic.getText());
            ps.setString(7,joinyear);
            ps.execute();
            
            

            JOptionPane.showMessageDialog(this,"Inserted!");
            Del_home dh = new Del_home(temp);
            dh.show();
            this.dispose();

        }
        catch (SQLException ex) {
            Logger.getLogger(Restaurant_signup.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_signupActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(DelPartner_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DelPartner_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DelPartner_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DelPartner_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DelPartner_signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton signup;
    private javax.swing.JTextField signupEmpdob;
    private javax.swing.JTextField signupEmplic;
    private javax.swing.JTextField signupEmploc;
    private javax.swing.JTextField signupEmpname;
    private javax.swing.JTextField signupEmpph;
    // End of variables declaration//GEN-END:variables
}
