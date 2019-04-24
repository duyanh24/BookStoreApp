
package com.nhom3.views.book;

import com.nhom3.controller.ExportFileExcel;
import com.nhom3.views.book.AddBookJFrame;
import com.nhom3.entity.Sach;
import com.nhom3.service.SachService;
import com.nhom3.service.TheLoaiService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookJPanel extends javax.swing.JPanel {

    SachService bookService;
    DefaultTableModel defaultTableModel;
    TheLoaiService categoryService;
    ExportFileExcel exportFileExcel;
    
    public BookJPanel() {
        initComponents();
        bookService = new SachService();
        categoryService = new TheLoaiService();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        
        bookTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã sách");
        defaultTableModel.addColumn("Tên sách");
        defaultTableModel.addColumn("Nhà xuất bản");
        defaultTableModel.addColumn("Tác giả");
        defaultTableModel.addColumn("Thể loại");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Giá nhập");
        defaultTableModel.addColumn("Giá bán");
        
        
        List<Sach> books = bookService.getAllBook();
        
        for(Sach book : books){
            defaultTableModel.addRow(new Object[]{book.getMaSach(),book.getTieuDe(),book.getNhaXB(),book.getTenTacGia(),categoryService.getCategoryById(book.getMaTheLoai()),book.getSoLuong(),book.getGiaNhap(),book.getGiaBan()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        typeSearchJCombobox = new javax.swing.JComboBox<>();
        searchJTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        exportFileButton = new javax.swing.JButton();
        fileNameTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        updateBookButton = new javax.swing.JButton();
        refeshButton = new javax.swing.JButton();
        addBookbutton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        bookTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(bookTable);

        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchJTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchJTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(fileNameTextField)))
        );

        updateBookButton.setBackground(new java.awt.Color(0, 153, 0));
        updateBookButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateBookButton.setForeground(new java.awt.Color(255, 255, 255));
        updateBookButton.setText("Sửa Sách");
        updateBookButton.setBorderPainted(false);
        updateBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookButtonActionPerformed(evt);
            }
        });

        refeshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refeshButton.setText("Refesh");
        refeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshButtonActionPerformed(evt);
            }
        });

        addBookbutton.setBackground(new java.awt.Color(0, 153, 0));
        addBookbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addBookbutton.setForeground(new java.awt.Color(255, 255, 255));
        addBookbutton.setText("Thêm Sách");
        addBookbutton.setBorderPainted(false);
        addBookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookbuttonActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(updateBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBookbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBookbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
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
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookbuttonActionPerformed
        new AddBookJFrame().setVisible(true);
    }//GEN-LAST:event_addBookbuttonActionPerformed

    private void refeshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshButtonActionPerformed
        defaultTableModel.setRowCount(0);
        List<Sach> books = bookService.getAllBook();
        
        for(Sach book : books){
            defaultTableModel.addRow(new Object[]{book.getMaSach(),book.getTieuDe(),book.getNhaXB(),book.getTenTacGia(),categoryService.getCategoryById(book.getMaTheLoai()),book.getSoLuong(),book.getGiaNhap(),book.getGiaBan()});
        }
    }//GEN-LAST:event_refeshButtonActionPerformed

    private void updateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookButtonActionPerformed
        int row = bookTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(BookJPanel.this, "Vui lòng chọn sách trước!","Lỗi",JOptionPane.ERROR);
        }
        else{
            int bookId = Integer.valueOf(String.valueOf(bookTable.getValueAt(row, 0)));
            new UpdateBookJFrame(bookId).setVisible(true);
        }
    }//GEN-LAST:event_updateBookButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        String searchKeyWord;
        searchKeyWord = searchJTextField.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
         
        bookTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã sách");
        defaultTableModel.addColumn("Tên sách");
        defaultTableModel.addColumn("Nhà xuất bản");
        defaultTableModel.addColumn("Tác giả");
        defaultTableModel.addColumn("Thể loại");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Giá nhập");
        defaultTableModel.addColumn("Giá bán");
        
        String typeSearch = String.valueOf(typeSearchJCombobox.getSelectedItem());
        List<Sach> books;
        if(typeSearch.equals("Theo tên")){
            books = bookService.searchBookFromTitle(searchKeyWord);
        }
        else if(typeSearch.equals("Theo tác giả")){
            books = bookService.searchBookFromAuthor(searchKeyWord);
        }
        else{
            books = bookService.searchBookFromNhaXB(searchKeyWord);
        }
            
        for(Sach book : books){
            defaultTableModel.addRow(new Object[]{book.getMaSach(),book.getTieuDe(),book.getNhaXB(),book.getTenTacGia(),categoryService.getCategoryById(book.getMaTheLoai()),book.getSoLuong(),book.getGiaNhap(),book.getGiaBan()});
        }
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = bookTable.getSelectedRow();
//        if(row == -1){
//            JOptionPane.showMessageDialog(BookJPanel.this, "Vui lòng chọn sách trước!","Lỗi",JOptionPane.ERROR);
//        }
//        else{
//            int bookId = Integer.valueOf(String.valueOf(bookTable.getValueAt(row, 0)));
//            bookService.deleteBook(bookId);
//        }
        int confirm  = JOptionPane.showConfirmDialog(BookJPanel.this, "Bạn có chắc chắn muốn xóa không?");
        
        if(confirm == JOptionPane.YES_OPTION){
            int bookId = Integer.valueOf(String.valueOf(bookTable.getValueAt(row, 0)));
            bookService.deleteBook(bookId);
            JOptionPane.showMessageDialog(null, "Đã xóa sách!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        exportFileExcel = new ExportFileExcel();
        StringBuffer path = new StringBuffer();
        path.append("C:\\Users\\Hoang Viet\\Desktop\\");
        path.append(fileNameTextField.getText());
        path.append(".xlsx");
        String path2 = path.toString();
        
        try {
            exportFileExcel.writeToExcell(bookTable,path2);
            JOptionPane.showMessageDialog(null, "Lưu file thành công!");
        } catch (IOException ex) {
            Logger.getLogger(BookJPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lưu file không thành công!");
        }
    }//GEN-LAST:event_exportFileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookbutton;
    private javax.swing.JTable bookTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refeshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchJTextField;
    private javax.swing.JComboBox<String> typeSearchJCombobox;
    private javax.swing.JButton updateBookButton;
    // End of variables declaration//GEN-END:variables
}
