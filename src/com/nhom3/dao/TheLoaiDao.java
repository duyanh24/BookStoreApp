
package com.nhom3.dao;

import com.nhom3.entity.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TheLoaiDao {
    public List<TheLoai> getAllCategory(){
        List<TheLoai> categories = new ArrayList<TheLoai>();
       
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.THE_LOAI";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TheLoai category = new TheLoai();
                category.setMaTheLoai(rs.getInt("MaTheLoai"));
                category.setTheLoai(rs.getString("TheLoai"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    public int getCategoryIdByValue(String value){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.THE_LOAI WHERE TheLoai = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TheLoai category = new TheLoai();
                category.setMaTheLoai(rs.getInt("MaTheLoai"));
                
                return category.getMaTheLoai();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String getCategoryById(int maTheLoai){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.THE_LOAI WHERE MaTheLoai = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maTheLoai);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TheLoai category = new TheLoai();
                category.setTheLoai(rs.getString("TheLoai"));
                
                return category.getTheLoai();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<TheLoai> searchFromTitle(String title){
        List<TheLoai> categories = new ArrayList<TheLoai>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.THE_LOAI where TheLoai LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(title);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                TheLoai category = new TheLoai();
                category.setTheLoai(rs.getString("TheLoai"));
                category.setMaTheLoai(rs.getInt("MaTheLoai"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    public void deleteCategory(int maTheLoai){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE dbo.THE_LOAI WHERE MaTheLoai=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maTheLoai);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void addCategory(TheLoai category){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.THE_LOAI(TheLoai) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getTheLoai());
   
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCategory(TheLoai category){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE dbo.THE_LOAI SET TheLoai=? WHERE MaTheLoai=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getTheLoai());
            preparedStatement.setInt(2, category.getMaTheLoai());

            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
