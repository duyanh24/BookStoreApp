
package com.nhom3.views.category;

import com.nhom3.controller.ExportFileExcel;
import com.nhom3.entity.TheLoai;
import com.nhom3.service.TheLoaiService;
import com.nhom3.views.book.BookJPanel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoryJPanel extends javax.swing.JPanel {


    DefaultTableModel defaultTableModel;
    TheLoaiService categoryService;
    ExportFileExcel exportFileExcel;
    TheLoai theLoai;
    
    public CategoryJPanel() {
        initComponents();
        categoryService = new TheLoaiService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        
        categoryTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã thể loại");
        defaultTableModel.addColumn("Tên thể loại");

        
        
        List<TheLoai> categories = categoryService.getAllCategory();
        
        for(TheLoai category : categories){
            defaultTableModel.addRow(new Object[]{category.getMaTheLoai(),category.getTheLoai()});
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        refeshButton = new javax.swing.JButton();
        addCategorybutton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        searchJTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        exportFileButton = new javax.swing.JButton();
        fileNameTextField = new javax.swing.JTextField();

        updateButton.setBackground(new java.awt.Color(0, 153, 0));
        updateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Cập Nhật");
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        refeshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refeshButton.setText("Refesh");
        refeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshButtonActionPerformed(evt);
            }
        });

        addCategorybutton.setBackground(new java.awt.Color(0, 153, 0));
        addCategorybutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addCategorybutton.setForeground(new java.awt.Color(255, 255, 255));
        addCategorybutton.setText("Thêm Thể Loại");
        addCategorybutton.setBorderPainted(false);
        addCategorybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategorybuttonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(addCategorybutton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCategorybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        categoryTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(categoryTable);

        searchJTextField.setText("Nhập từ khóa tìm kiếm.");
        searchJTextField.setToolTipText("");

        searchButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exportFileButton.setBackground(new java.awt.Color(51, 0, 153));
        exportFileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exportFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportFileButton.setText("Xuất File");
        exportFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButtonActionPerformed(evt);
            }
        });

        fileNameTextField.setText("Tên File");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportFileButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(searchJTextField))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(fileNameTextField)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int row = categoryTable.getSelectedRow();
        int maTheLoai = Integer.valueOf(String.valueOf(categoryTable.getValueAt(row, 0)));
        new UpdateJFrame(maTheLoai).setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void refeshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshButtonActionPerformed
        defaultTableModel.setRowCount(0);
        List<TheLoai> categories = categoryService.getAllCategory();
        
        for(TheLoai category : categories){
            defaultTableModel.addRow(new Object[]{category.getMaTheLoai(),category.getTheLoai()});
        }
    }//GEN-LAST:event_refeshButtonActionPerformed

    private void addCategorybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategorybuttonActionPerformed
        new AddJFrame().setVisible(true);
    }//GEN-LAST:event_addCategorybuttonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = categoryTable.getSelectedRow();

        int confirm  = JOptionPane.showConfirmDialog(CategoryJPanel.this, "Bạn có chắc chắn muốn xóa không?");

        if(confirm == JOptionPane.YES_OPTION){
            int maTheLoai = Integer.valueOf(String.valueOf(categoryTable.getValueAt(row, 0)));
            categoryService.deleteCategory(maTheLoai);
            JOptionPane.showMessageDialog(null, "Đã xóa!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        String searchKeyWord;
        searchKeyWord = searchJTextField.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };

        categoryTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã thể loại");
        defaultTableModel.addColumn("Tên thể loại");

        List<TheLoai> categories;
        categories = categoryService.searchFromTitle(searchKeyWord);
        
        for(TheLoai category : categories){
            defaultTableModel.addRow(new Object[]{category.getMaTheLoai(),category.getTheLoai()});
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        exportFileExcel = new ExportFileExcel();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Admin\\Desktop\\");
            path.append(fileNameTextField.getText());
            path.append(".xlsx");
            String path2 = path.toString();

            try {
                exportFileExcel.writeToExcell(categoryTable,path2);
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (IOException ex) {
                Logger.getLogger(CategoryJPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lưu file không thành công!");
            }
    }//GEN-LAST:event_exportFileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategorybutton;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refeshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchJTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
