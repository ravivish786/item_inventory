/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteminventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ravi
 */
public class UserRagistrationList extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection con=null;
    public UserRagistrationList() {
        initComponents();
        model=(DefaultTableModel)table.getModel();
        loadDataInTable();
    }
   
    private void loadDataInTable()
    {
         model.setRowCount(0);
        try {
            con=DBConnect.getConnection();
            Statement statement=con.createStatement();
            ResultSet set=statement.executeQuery("select * from user_schema");
            int i=1;
            while(set.next())
            {
                Object[] row = {i++,set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getString(9)};
                model.addRow(row);    
            }
        } catch (SQLException e) {
            System.out.println("Load Data in table -> "+e);
        } finally{
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(UserRagistrationList.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Ragistraion List");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Salution", "First Name", "Last Name", "Gender", "Mobile No.", "Email", "Address", "Role", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Ragistration List ");

        jButton1.setBackground(java.awt.Color.red);
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItem(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItem(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton3.setText("Load Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTable(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton3))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1069, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItem
    int row = table.getSelectedRow();
        if(row == -1)
            JOptionPane.showMessageDialog(null, "Please select any row in table");
        else
        {
            UserRegistration ur=new UserRegistration();
            ur.setVisible(true);
            TableModel model=table.getModel();
           
            int index=(int) model.getValueAt(row, 0);
            ur.setTitle("Update User Detail");
            ur.jLabel1.setText("Update Customer Registration");
            ur.jButton1.setText("Update Item");
            ur.id.setText(model.getValueAt(row, 1).toString());
            ur.firstname.setText(model.getValueAt(row,2).toString());
            ur.lastname.setText(model.getValueAt(row,3).toString());
            ur.gender.setSelectedItem(model.getValueAt(row,4).toString());
            ur.mobilenumber.setText(model.getValueAt(row,5).toString());
            ur.email.setText(model.getValueAt(row,6).toString());
            ur.address.setText(model.getValueAt(row,7).toString());
            ur.role.setText(model.getValueAt(row,8).toString());
            ur.status.setSelectedItem(model.getValueAt(row,9).toString());
           
        }
    }//GEN-LAST:event_updateItem

    private void deleteItem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItem
        int returnVlaue=0;
       
       int row = table.getSelectedRow();
        if(row == -1)
            JOptionPane.showMessageDialog(null, "Please select any row in table");
        else
        {
            String Table_click = (table.getModel().getValueAt(row, 1).toString());
            returnVlaue=JOptionPane.showConfirmDialog(null, "Are you sure ? \nYou want to delete this row", "Comfirm Message ", JOptionPane.YES_NO_OPTION);
                if(returnVlaue==JOptionPane.YES_OPTION)
                {
                    try {
                        con=DBConnect.getConnection();
                        Statement stmt = con.createStatement();
                        String query1 = "delete from user_schema where salutation='"+Table_click+"'";
                        if(stmt.executeUpdate(query1)==1)
                        {
                            JOptionPane.showMessageDialog(null,"Record is deleted from the table successfully...........");
                            loadDataInTable();
                        }
                    } catch (SQLException ex) {
                        System.out.println(""+ex);
                    }
                }        
        }
        
    }//GEN-LAST:event_deleteItem

    private void loadTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTable
        loadDataInTable(); 
    }//GEN-LAST:event_loadTable

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
            java.util.logging.Logger.getLogger(UserRagistrationList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRagistrationList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRagistrationList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRagistrationList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRagistrationList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
