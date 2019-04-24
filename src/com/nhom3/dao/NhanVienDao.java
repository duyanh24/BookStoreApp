/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.dao;

import com.nhom3.entity.nhanvien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class NhanVienDao {
    public List<nhanvien> getAllNhanVien(){
        List<nhanvien> NVs = new ArrayList<nhanvien>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.NHAN_VIEN";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getString("ChucVu"));
                NVs.add(nv);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NVs;
    }
    public void addNhanVien(nhanvien NV){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.NHAN_VIEN(MaNhanVien, HoTen,  SoDT, Email, TaiKhoan, MatKhau, ChucVu) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, NV.getMaNV());
            preparedStatement.setString(2, NV.getHoTen());
            preparedStatement.setString(3, NV.getSoDT());
            preparedStatement.setString(4, NV.getEmail());
            preparedStatement.setString(5, NV.getTaiKhoan());
            preparedStatement.setString(6, NV.getMatKhau());
            preparedStatement.setString(7, NV.getChucVu());
            
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public nhanvien getNVById(String MaNhanVien){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.NHAN_VIEN WHERE MaNhanVien = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MaNhanVien);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getString("ChucVu"));
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void updateNhanVien(nhanvien nv){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE dbo.NHAN_VIEN SET HoTen=?,SoDT=?,Email=?,TaiKhoan=?,MatKhau=?,ChucVu=? WHERE MaNhanVien=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nv.getHoTen());
            preparedStatement.setString(2, nv.getSoDT());
            preparedStatement.setString(3, nv.getEmail());
            preparedStatement.setString(4, nv.getTaiKhoan());
            preparedStatement.setString(5, nv.getMatKhau());
            preparedStatement.setString(6, nv.getChucVu());
            
            preparedStatement.setString(7, nv.getMaNV());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<nhanvien> searchNVFromChucVu(String ChucVu){
        List<nhanvien> NVs = new ArrayList<nhanvien>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.NHAN_VIEN where ChucVu LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(ChucVu);
        stringBufferTile.append("%");
        String chucVuLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chucVuLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getString("ChucVu"));
                NVs.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NVs;
    }
    public List<nhanvien> searchNVFromName(String Name){
        List<nhanvien> NVs = new ArrayList<nhanvien>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.NHAN_VIEN where HoTen LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(Name);
        stringBufferTile.append("%");
        String nameLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                nhanvien nv = new nhanvien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setChucVu(rs.getString("ChucVu"));
                NVs.add(nv);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NVs;
    }
    public void deleteNhanVien(String MaNhanVien){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE dbo.NHAN_VIEN WHERE MaNhanVien=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, MaNhanVien);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
