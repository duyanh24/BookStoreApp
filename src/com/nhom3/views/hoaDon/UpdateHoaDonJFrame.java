/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.views.hoaDon;

import com.nhom3.entity.HoaDon;
import com.nhom3.entity.KhachHang;
import com.nhom3.entity.NhanVien;
import com.nhom3.service.HoaDonService;
import com.nhom3.service.KhachHangService;
import com.nhom3.service.NhanVienService;
import java.awt.Font;
import javax.swing.JLabel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Viet
 */
public class UpdateHoaDonJFrame extends javax.swing.JFrame {
    /**
     * Creates new form UpdateHoaDonJFrame
     */
    HoaDonService hoaDonService;
    KhachHangService khachHangService;
    NhanVienService nhanVienService;
    ArrayList<KhachHang> khachHangs;
    ArrayList<NhanVien> nhanViens;
    JLabel label;
    HoaDon hoaDon;
    public UpdateHoaDonJFrame(int maHoaDon) {
        initComponents();
        setLocationRelativeTo(null);
        khachHangService = new KhachHangService();
        khachHangs = khachHangService.getAllKhachHang();
        for (KhachHang khachHang : khachHangs) {
            maKHCombobox.addItem(khachHang.getMaKH());
        }
        nhanVienService = new NhanVienService();
        nhanViens = (ArrayList<NhanVien>) nhanVienService.getAllNhanVien();
        for (NhanVien nhanVien : nhanViens) {
            maNhanVienCombobox.addItem(nhanVien.getMaNV());
        }
        hoaDonService = new HoaDonService();
        HoaDon hoaDon = hoaDonService.getHoaDonById(maHoaDon);
        maHoaDonTextField.setText(hoaDon.getMaHoaDon().toString());
        maKHCombobox.setSelectedItem(hoaDon.getMaKH().toString());
        khachHangService = new KhachHangService();
        KhachHang khachHang = khachHangService.getKhachHangById(Integer.parseInt(hoaDon.getMaKH()));
        tenKHTextField.setText(khachHang.getHoTen());
        maNhanVienCombobox.setSelectedItem(hoaDon.getMaNhanVien().toString());
        nhanVienService = new NhanVienService();
        NhanVien nhanVien = nhanVienService.getNVById(hoaDon.getMaNhanVien());
        tenNhanVienTextField.setText(nhanVien.getHoTen());
        try {
            Date ngayBan = new SimpleDateFormat("yyyy-MM-dd").parse(hoaDon.getNgayBan());
            ngayBanDateChooser.setDate(ngayBan);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateHoaDonJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        tongTienTextField.setText(String.valueOf(hoaDon.getTongTien()));
    }
    
    private HoaDon getData() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon(maHoaDonTextField.getText().toString());
        hoaDon.setMaKH((String) maKHCombobox.getSelectedItem());
        hoaDon.setMaNhanVien((String) maNhanVienCombobox.getSelectedItem());
        Date dateNgayBan = ngayBanDateChooser.getDate();
        DateFormat dateFormatNgayBan = new SimpleDateFormat("yyyy-MM-dd");
        hoaDon.setNgayBan(dateFormatNgayBan.format(dateNgayBan));
        hoaDon.setTongTien(Integer.parseInt(tongTienTextField.getText().toString()));
        return hoaDon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tongTienTextField = new javax.swing.JTextField();
        maKHCombobox = new javax.swing.JComboBox<>();
        maNhanVienCombobox = new javax.swing.JComboBox<>();
        ngayBanDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        maHoaDonTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tenKHTextField = new javax.swing.JTextField();
        tenNhanVienTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        submit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        submit.setBackground(new java.awt.Color(51, 153, 0));
        submit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Cập nhật");
        submit.setBorder(null);
        submit.setBorderPainted(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("...");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Thông tin hóa đơn");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Ngày bán");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Mã KH");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Mã nhân viên");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Tổng tiền");

        maKHCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKHComboboxActionPerformed(evt);
            }
        });

        maNhanVienCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNhanVienComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maKHCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(tongTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maNhanVienCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayBanDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maKHCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maNhanVienCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(ngayBanDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Mã hóa đơn");

        maHoaDonTextField.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Tên KH");

        tenKHTextField.setEditable(false);

        tenNhanVienTextField.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Tên nhân viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenKHTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenNhanVienTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(maHoaDonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maHoaDonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenKHTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenNhanVienTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(35, 35, 35))
        );

        submit1.setBackground(new java.awt.Color(153, 153, 0));
        submit1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        submit1.setForeground(new java.awt.Color(255, 255, 255));
        submit1.setText("Quay lại");
        submit1.setBorder(null);
        submit1.setBorderPainted(false);
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 752, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
          if (tongTienTextField.getText().length() == 0) {
            label = new JLabel("Chưa có thông tin cập nhật");
            label.setFont(new Font("Tahoma", Font.PLAIN, 18));
            JOptionPane.showMessageDialog(UpdateHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                hoaDon = getData();
                hoaDonService = new HoaDonService();
                int check = hoaDonService.updateHoaDon(hoaDon);
                if (check <= 0) {
                    label = new JLabel("Thông tin cập nhật không chính xác");
                    label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    JOptionPane.showMessageDialog(UpdateHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    label = new JLabel("Cập nhật thành công");
                    label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    JOptionPane.showMessageDialog(UpdateHoaDonJFrame.this, label, "NOTE", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } catch (Exception e) {
                label = new JLabel("Thông tin cập nhật không chính xác");
                label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                JOptionPane.showMessageDialog(UpdateHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_submitActionPerformed

    private void maKHComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKHComboboxActionPerformed
        // TODO add your handling code here:
        String maKH = (String) maKHCombobox.getSelectedItem();
        khachHangService = new KhachHangService();
        KhachHang khachHang = khachHangService.getKhachHangById(Integer.parseInt(maKH));
        tenKHTextField.setText(khachHang.getHoTen());
    }//GEN-LAST:event_maKHComboboxActionPerformed

    private void maNhanVienComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNhanVienComboboxActionPerformed
        // TODO add your handling code here:
        String maNhanVien = (String) maNhanVienCombobox.getSelectedItem();
        nhanVienService = new NhanVienService();
        NhanVien nhanVien = nhanVienService.getNVById(maNhanVien);
        tenNhanVienTextField.setText(nhanVien.getHoTen());
    }//GEN-LAST:event_maNhanVienComboboxActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_submit1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new UpdateHoaDonJFrame().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField maHoaDonTextField;
    private javax.swing.JComboBox<String> maKHCombobox;
    private javax.swing.JComboBox<String> maNhanVienCombobox;
    private com.toedter.calendar.JDateChooser ngayBanDateChooser;
    private javax.swing.JButton submit;
    private javax.swing.JButton submit1;
    private javax.swing.JTextField tenKHTextField;
    private javax.swing.JTextField tenNhanVienTextField;
    private javax.swing.JTextField tongTienTextField;
    // End of variables declaration//GEN-END:variables
}
