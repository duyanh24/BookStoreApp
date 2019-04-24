/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.service;

import com.nhom3.dao.KhachHangDao;
import com.nhom3.entity.KhachHang;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hoang Viet
 */
public class KhachHangService {
    KhachHangDao khachHangDao;
    public KhachHangService() {
        khachHangDao = new KhachHangDao();
    }
    
    public ArrayList<KhachHang> getAllKhachHang() {
        return khachHangDao.getAllKhachHang();
    }
    
    public void addKhachHang(KhachHang khachHang)throws SQLException{
        khachHangDao.addKhachHang(khachHang);
    }
    
    public void deleteKhachHang(int maKH){
        khachHangDao.deleteKhachHang(maKH);
    }
    
    public int updateKhachHang(KhachHang khachHang) {
        return khachHangDao.updateKhachHang(khachHang);
    }
    
    public ArrayList<KhachHang> searchKhachHang(String comboBox, String textField) {
        return khachHangDao.searchKhachHang(comboBox, textField);
    }
    
    public ArrayList<KhachHang> thongKeKhachHang(String comboBox) {
        return khachHangDao.thongKeKhachHang(comboBox);
    }
    
    public KhachHang getKhachHangById(int maKH) {
        return khachHangDao.getKhachHangById(maKH);
    }
}
