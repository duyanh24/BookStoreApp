/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.service;

import com.nhom3.dao.HoaDonDao;
import com.nhom3.entity.HoaDon;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Hoang Viet
 */
public class HoaDonService {
    HoaDonDao hoaDonDao;
    
    public HoaDonService() {
        hoaDonDao = new HoaDonDao();
    }
    
    public ArrayList<HoaDon> getAllHoaDon() {
        return hoaDonDao.getAllHoaDon();
    }
    
    public void addHoaDon(HoaDon hoaDon) throws SQLException, ParseException {
        hoaDonDao.addHoaDon(hoaDon);
    }
    
    public void deleteHoaDon(String maHoaDon) throws SQLException {
        hoaDonDao.deleteHoaDon(maHoaDon);
    }
    
    public int updateHoaDon(HoaDon hoaDon) throws ParseException{
        return hoaDonDao.updateHoaDon(hoaDon);
    }
    
    public ArrayList<HoaDon> searchHoaDon(String comboBox, String textField) {
        return hoaDonDao.searchHoaDon(comboBox, textField);
    }
    
    public ArrayList<HoaDon> thongKeHoaDon(String comboBox){
        return hoaDonDao.thongKeHoaDon(comboBox);
    }
    
    public HoaDon getHoaDonById(int maHoaDon){
        return hoaDonDao.getHoaDonById(maHoaDon);
    }
}
