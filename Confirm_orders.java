package com.mycompany.mavenproject2;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author silve
 */
public class Confirm_orders extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;
    //String restid;
    String orderno;
    /**
     * Creates new form Confirm_orders
     */
    public Confirm_orders() {
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
    
    public Confirm_orders(String restid, String orderno) {
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
            this.orderno=orderno;
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Restaurant_home.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        fill();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderSum = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Order_no");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 58, 87, 22));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setFocusable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 58, 215, -1));

        jLabel2.setText("Delivery Address");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 92, -1, 22));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 92, 215, -1));

        jLabel3.setText("Bill Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 126, 87, 22));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFocusable(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 126, 215, -1));

        orderSum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ", "Quantity", "Price", "Rating"
            }
        ));
        orderSum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderSumFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(orderSum);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, 388, 116));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Proceed to payment?");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 276, 156, 24));

        cancel.setText("Cancel Order");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 306, -1, -1));

        confirm.setText("Confirm Order");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 306, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Order Summary");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 14, 154, 26));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-watercolor-background-world-vegetarian-day_23-2149612954.png")); // NOI18N
        jLabel6.setText(".");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -100, 610, 490));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-watercolor-background-world-vegetarian-day_23-2149612954.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -100, 610, 490));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-watercolor-background-world-vegetarian-day_23-2149612954.png")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-watercolor-background-world-vegetarian-day_23-2149612954.png")); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\luxa.org-opacity-changed-watercolor-background-world-vegetarian-day_23-2149612954.png")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    public void fill()
    {
        jTextField1.setText(orderno);
        try
        {
            String sql = "select delv_add from orders_list where order_no like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,orderno);
            rs = ps.executeQuery();
            rs.next();
            jTextField2.setText(rs.getString("delv_add"));
            CallableStatement cstmt = con.prepareCall("{? = call bill(?)}");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, orderno);
            cstmt.execute();
            int total = cstmt.getInt(1);
            cstmt.close();
            jTextField3.setText(String.valueOf(total));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        
        
    }
    private void orderSumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderSumFocusGained
        
        try{
            String sql2 = "select order_details.item_name, qty,price, rating from order_details, menu1, orders_list where menu1.item_name = order_details.item_name and orders_list.order_no = order_details.order_no and orders_list.rest_id = menu1.rest_id and order_details.order_no like ?";
            ps = con.prepareStatement(sql2);
            ps.setString(1, orderno);
            rs = ps.executeQuery();
            DefaultTableModel tblModel2 = (DefaultTableModel)orderSum.getModel();
            tblModel2.setRowCount(0);
            while(rs.next())
            {
                String item_name = rs.getString("item_name");
                String qty = rs.getString("qty");
                String rating = rs.getString("rating");
                String price = rs.getString("price");
                String tbData[] = {item_name, qty, price, rating};
                tblModel2.addRow(tbData);
            }
        }
        catch (SQLException e) {
            Logger.getLogger(Confirm_orders.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_orderSumFocusGained

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Cancel_confirmation cc = new Cancel_confirmation(orderno, this);
        cc.show();
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        try{
            String temp = " select concat('T',substr(concat('00000',cast(count(*)+1 as varchar(10))), -5)) as temp from payments";
            ps = con.prepareStatement(temp);
            rs = ps.executeQuery();
            rs.next();
            String tid = rs.getString("temp");
            
            String sql = "insert into payments values (?, ?, 10)";
            ps = con.prepareStatement(sql);
            ps.setString(1, tid);
            ps.setString(2, orderno);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Payment Successful!");
            //insert code to go back to home page here
            this.dispose();
        }
        catch (SQLException e) {
            Logger.getLogger(Confirm_orders.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmActionPerformed

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
            java.util.logging.Logger.getLogger(Confirm_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirm_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirm_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirm_orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Confirm_orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable orderSum;
    // End of variables declaration//GEN-END:variables
}