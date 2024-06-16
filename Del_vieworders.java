/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Del_vieworders extends javax.swing.JFrame {
    String emp_id;
    String assigned;
    String cust_add_final;
    int flag=0;
    Del_home dh;
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    PreparedStatement ps1;
    ResultSet rs1;
    DefaultTableModel tblModel2;
    /**
     * Creates new form Del_vieworders
     */
    public Del_vieworders(){}
    public Del_vieworders(Del_home dh, String emp_id) {
        this.emp_id = emp_id;
        this.dh = dh;
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
        show_table();
        /*if(flag==0)
        {
            
           this.dispose();
        }*/
    }
    public void show_table()
    {
        try
        {
            con.setAutoCommit(false);
            con.commit();
            con.setAutoCommit(true);
            int count=0;
            String sql = "select starting_add from del_partners1 where emp_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,emp_id);
            rs = ps.executeQuery();
            rs.next();
            String temp = rs.getString("starting_add");
            String pincode_del = temp.substring(temp.length()-6,temp.length());
            //JOptionPane.showMessageDialog(this,pincode_del);
            sql = "select name, order_no, orders_list.rest_id, rest_name, ord_time, delv_add from orders_list,users,restaurants1 where delv_time is null and orders_list.emp_id is null and restaurants1.rest_id = orders_list.rest_id and users.user_id = orders_list.user_id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //if(rs.next()==true)
            //{
                while(rs.next())
                {
                    //JOptionPane.showMessageDialog(this,rs.getString("rest_id")+rs.getString("order_no"));
                    String sql1 = "select rest_add from restaurants1 where restaurants1.rest_id = ?";
                    ps1 = con.prepareStatement(sql1);
                    ps1.setString(1,rs.getString("rest_id"));
                    rs1 = ps1.executeQuery();
                    rs1.next();
                    String add = rs1.getString("rest_add");
                    String pincode_rest = add.substring(add.length()-6,add.length());
                    //JOptionPane.showMessageDialog(this,pincode_rest);
                    if(pincode_rest.equals(pincode_del))
                    {
                        flag=1;
                        tblModel2 = (DefaultTableModel)jTable1.getModel();
                        String order_no = rs.getString("order_no");
                        assigned = order_no;
                        String cust_name = rs.getString("name");
                        String cust_add = rs.getString("delv_add");
                        cust_add_final = cust_add;
                        String rest_name = rs.getString("rest_name");
                        String ord_time = rs.getString("ord_time");

                        String tb[] = {order_no,cust_name,cust_add,rest_name,add,ord_time};
                        tblModel2.addRow(tb);
                        String sql2 = "update orders_list set emp_id = ? where order_no like ?";
                        ps = con.prepareStatement(sql2);
                        ps.setString(1,emp_id);
                        ps.setString(2,order_no);
                        ps.executeQuery();
                        JOptionPane.showMessageDialog(this,"Assigned");
                        break;
                    }
                        
         
                 }
                
                    
             //}
            
            if(flag==0)
            {
                JOptionPane.showMessageDialog(this,"No orders available in your current location!!");
                JOptionPane.showMessageDialog(this,"Please click delivered button to continue");
                
            }
        }
        catch(Exception e)
        {
           
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No", "Cust Name", "Cust Address", "Rest Name", "Rest Address", "Order Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Delivered");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(flag==1)
        {
        try
        {
        String sql = "update orders_list set delv_time = systimestamp where order_no like ?";
        ps = con.prepareStatement(sql);
        ps.setString(1,assigned);
        ps.executeQuery();
        sql = "update del_partners1 set starting_add = ? where emp_id like ?";
        ps = con.prepareStatement(sql);
        ps.setString(1,cust_add_final);
        ps.setString(2,emp_id);
        ps.executeQuery();
        JOptionPane.showMessageDialog(this,"Order delivered successfully!!");
        con.setAutoCommit(false);
            con.commit();
            con.setAutoCommit(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        }
        else
        {
            
            
        }
        dh.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Del_vieworders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Del_vieworders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Del_vieworders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Del_vieworders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Del_vieworders().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
