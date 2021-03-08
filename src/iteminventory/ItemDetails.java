package iteminventory;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class ItemDetails extends javax.swing.JFrame {
    ArrayList<byte[]> list;
    public String fileName=null;
    Connection con=null;
    DefaultTableModel model;
    byte[] item_image;
    
    public ItemDetails() {
        initComponents();
        model=(DefaultTableModel)table.getModel();
        loadDataInTable();
        itemstatus.setText(generateRandomId());
    }
    private String generateRandomId(){
        char data[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        char index[]=new char[10];
        Random r=new Random();
        int i =0;

        for( i=0;i<(index.length);i++)
        {
            int ran=r.nextInt(data.length);
            index[i]=data[ran];
            String captcha=String.valueOf(index);          
        }
        
        return new String(index);
    }
    private void loadDataInTable()
    {
        model.setRowCount(0);
        try {
            con=DBConnect.getConnection();
            Statement statement=con.createStatement();
            ResultSet set=statement.executeQuery("select * from item_schema");
            int i=1;
            while(set.next())
            {
                
                Object[] row = {i++,set.getString(1),set.getBytes(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7)};
                model.addRow(row);    
            }
        } catch (SQLException e) {
            System.out.println("Load Data in table -> "+e);
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        itemstatus = new javax.swing.JTextField();
        itemimage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        itemquantity = new javax.swing.JTextField();
        itemunit = new javax.swing.JTextField();
        itemprice = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        addimage = new javax.swing.JButton();
        additem = new javax.swing.JButton();
        itemcategory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        delate = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        userPage = new javax.swing.JMenuItem();
        userList = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item Inventry Management System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Item Detail");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Item Image :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Item Category  :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Item Quantity  :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Item Unit  :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Item Status    :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Item Unit Price  :");

        itemstatus.setEditable(false);
        itemstatus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        itemstatus.setForeground(java.awt.Color.red);

        itemimage.setBackground(new java.awt.Color(255, 51, 51));
        itemimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Item Status    :");

        itemquantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        itemunit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        itemprice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        itemprice.setMinimumSize(new java.awt.Dimension(10, 23));

        reset.setText("Reset ");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Item Name  :");

        addimage.setText("Add Image");
        addimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addimageActionPerformed(evt);
            }
        });

        additem.setBackground(java.awt.Color.green);
        additem.setForeground(java.awt.Color.white);
        additem.setText("ADD Item");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        itemcategory.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        itemcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Fruit", "Grosary", "Electronic", "Kitchen", "Chieldren", "Woman", "Man" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(additem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(reset))
                    .addComponent(itemname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addimage, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemimage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemquantity, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemunit, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemstatus, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemcategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addimage)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addComponent(itemimage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(itemcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(itemquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(itemunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(itemstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(additem)
                    .addComponent(reset)))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Item Name", "Item Image", "Item Category", "Item Quantity", "Item Unit", "Item Unit Price", "Item Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        delate.setBackground(new java.awt.Color(255, 0, 51));
        delate.setForeground(java.awt.Color.white);
        delate.setText("Delete Item");
        delate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delateActionPerformed(evt);
            }
        });

        update.setText("Update Detail");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        userPage.setText("New User");
        userPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPageActionPerformed(evt);
            }
        });
        jMenu1.add(userPage);

        userList.setText("User List");
        userList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userListActionPerformed(evt);
            }
        });
        jMenu1.add(userList);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Help");

        help.setText("Database Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        jMenu3.add(help);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(update)
                        .addGap(23, 23, 23)
                        .addComponent(delate))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update)
                    .addComponent(delate)))
        );

        setSize(new java.awt.Dimension(1254, 677));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delateActionPerformed
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
                        String query1 = "delete from item_schema where itemName='"+Table_click+"'";
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
        
    }//GEN-LAST:event_delateActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
       resetFields();
    }//GEN-LAST:event_resetActionPerformed
    private void resetFields(){
         itemname.setText("");
        itemcategory.setSelectedItem("Select");
        fileName=null;
        itemimage.setIcon(null);
        itemquantity.setText("");
        itemunit.setText("");
        itemprice.setText("");
        itemstatus.setText("");
    }
    private void userPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPageActionPerformed
        new UserRegistration().setVisible(true);
    }//GEN-LAST:event_userPageActionPerformed

    private void userListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListActionPerformed
        new UserRagistrationList().setVisible(true);
    }//GEN-LAST:event_userListActionPerformed

    private void addimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addimageActionPerformed
        try {
            JFileChooser jfc=new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("image file",".jpeg",".jpg",".png",".gif");
            jfc.addChoosableFileFilter(filter); //add XML file filter
            if(jfc.showOpenDialog(jPanel1)==JFileChooser.APPROVE_OPTION){
                File f=jfc.getSelectedFile();
                fileName=f.getAbsolutePath();
                ImageIcon icon=new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(itemimage.getWidth(), itemimage.getHeight(),Image.SCALE_SMOOTH));
                itemimage.setIcon(icon);
            }
            
            File file=new File(fileName);
            FileInputStream fis=new FileInputStream(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for (int readnum ;(readnum=fis.read(buf))!=-1;) {
             baos.write(buf,0,readnum);
            }
            item_image=baos.toByteArray();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addimageActionPerformed

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        if(itemname.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please Enter Item Name");
        else if(itemcategory.getSelectedItem().toString().equals("Select"))
            JOptionPane.showMessageDialog(null, "Please Select Item Category");
        else if(itemquantity.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please Enter Item Quantity");
        else if(itemunit.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please Enter No of  Items ");
        else if(itemprice.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please Enter 1 Item Price");
        else if(itemstatus.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please Enter Item Status value");
        else if(item_image==null)
            JOptionPane.showMessageDialog(null,"Please Select Item Image");
        else{
            if(FieldValidation.validateName(itemname.getText()))
                JOptionPane.showMessageDialog(null, "Please Enter Valid Item Name ");
            else if(FieldValidation.validateAllPattern(itemquantity.getText()))
                JOptionPane.showMessageDialog(null, "Please Enter valid Item Quantity");
            else if(FieldValidation.validateAllPattern(itemunit.getText()))
                JOptionPane.showMessageDialog(null, "Please Enter Valid item Unit ");
            else if(FieldValidation.validateAllPattern(itemprice.getText()))
                JOptionPane.showMessageDialog(null, "Please Enter Valid item Price");
            else if(FieldValidation.validateAllPattern(itemstatus.getText()))
                JOptionPane.showMessageDialog(null,"Please Enter Valid Item Status ");
            else if(additem.getText().equals("ADD Item"))
                sentToDataBase();
            else if(additem.getText().equals("Update Item"))
                updateDatabase();
        }
        
    }//GEN-LAST:event_additemActionPerformed
    private void updateDatabase(){
        try {
            con=DBConnect.getConnection();
            String sqlUpdate = "update item_schema set itemName=?,itemImage=?,itemCategory=?,itemQuantity=?,itemUnit=?,itemUnitPrice=? where itemStatus='"+itemstatus.getText()+"'";
            PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
            pstmt.setString(1, itemname.getText());
            pstmt.setBytes(2, item_image);
            pstmt.setString(3, itemcategory.getSelectedItem().toString());
            pstmt.setString(4, itemquantity.getText());
            pstmt.setString(5, itemunit.getText());
            pstmt.setString(6, itemprice.getText());
                                  
            if(pstmt.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null, "Your Record is updated Successfully.......");
                resetFields();
                additem.setText("ADD Item");
                loadDataInTable();
                itemstatus.setText(generateRandomId());
            }
        } catch (SQLException e) {
            System.out.println(" SentToUpadateDatabase -> "+e);
        }
    }
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         int row = table.getSelectedRow();
        if(row == -1)
            JOptionPane.showMessageDialog(null, "Please select any row in table");
        else
        {
            additem.setText("Update Item");
            TableModel model=table.getModel();
            itemname.setText(model.getValueAt(row, 1).toString());
            int index=(int) model.getValueAt(row, 0);
            byte[] bs=(byte[]) model.getValueAt(row, 2);
            item_image=bs;
            ImageIcon icon=new ImageIcon(new ImageIcon(bs).getImage().getScaledInstance(itemimage.getWidth(), itemimage.getHeight(),Image.SCALE_SMOOTH));
                itemimage.setIcon(icon);
            itemcategory.setSelectedItem(model.getValueAt(row, 3).toString());
            itemquantity.setText(model.getValueAt(row, 4).toString());
            itemunit.setText(model.getValueAt(row, 5).toString());
            itemprice.setText(model.getValueAt(row, 6).toString());
            itemstatus.setText(model.getValueAt(row, 7).toString());
           
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
       new HelpPage().setVisible(true);
    }//GEN-LAST:event_helpActionPerformed
    
    private void sentToDataBase()
    {
             
        try {
            con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into item_schema values(?,?,?,?,?,?,?)");
            ps.setString(1,itemname.getText());
            ps.setBytes(2,item_image);
            ps.setString(3,itemcategory.getSelectedItem().toString());
            ps.setString(4,itemquantity.getText());
            ps.setString(5,itemunit.getText());
            ps.setString(6,itemprice.getText());
            ps.setString(7,itemstatus.getText());
            if(ps.executeUpdate()==1)
            {
                JOptionPane.showMessageDialog(null, "Your Item has been added successfully ...");
                resetFields();
                loadDataInTable();
                itemstatus.setText(generateRandomId());
            }
        } catch (SQLException e) {
            System.out.println("Item List -> "+e);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItemDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ItemDetails().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addimage;
    private javax.swing.JButton additem;
    private javax.swing.JButton delate;
    private javax.swing.JMenuItem help;
    private javax.swing.JComboBox<String> itemcategory;
    private javax.swing.JLabel itemimage;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemprice;
    private javax.swing.JTextField itemquantity;
    private javax.swing.JTextField itemstatus;
    private javax.swing.JTextField itemunit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton reset;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    private javax.swing.JMenuItem userList;
    private javax.swing.JMenuItem userPage;
    // End of variables declaration//GEN-END:variables
}
