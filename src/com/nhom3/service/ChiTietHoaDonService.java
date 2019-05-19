/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.service;

import com.nhom3.dao.ChiTietHoaDonDao;
import com.nhom3.entity.ChiTietHoaDon;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Hoang Viet
 */
public class ChiTietHoaDonService {
    ChiTietHoaDonDao chiTietHoaDonDao;

    public ChiTietHoaDonService() {
        chiTietHoaDonDao = new ChiTietHoaDonDao();
    }
    
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon(int maHoaDon) {
        return chiTietHoaDonDao.getAllChiTietHoaDon(maHoaDon);
    }
    
    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException, ParseException{
        chiTietHoaDonDao.addChiTietHoaDon(chiTietHoaDon);
    }
    
    public void deleteChiTietHoaDon(int maHoaDon,int maSach) throws SQLException{
        chiTietHoaDonDao.deleteChiTietHoaDon(maHoaDon, maSach);
    }
    
    public int updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, int maSachCu) throws ParseException{
        return chiTietHoaDonDao.updateChiTietHoaDon(chiTietHoaDon, maSachCu);
    }
    
    public ArrayList<ChiTietHoaDon> searchChiTietHoaDon(String comboBox, String textField) {
        return chiTietHoaDonDao.searchChiTietHoaDon(comboBox, textField);
    }
}
