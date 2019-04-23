
package com.nhom3.dao;

import com.nhom3.entity.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SachDao {
    public List<Sach> getAllBook(){
        List<Sach> books = new ArrayList<Sach>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.SACH";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Sach book = new Sach();
                book.setMaSach(rs.getInt("MaSach"));
                book.setMaTheLoai(rs.getInt("MaTheLoai"));
                book.setTieuDe(rs.getString("TieuDe"));
                book.setTenTacGia(rs.getString("TenTacGia"));
                book.setNhaXB(rs.getString("NhaXB"));
                book.setSoLuong(rs.getInt("SoLuong"));
                book.setGiaNhap(rs.getInt("GiaNhap"));
                book.setGiaBan(rs.getInt("GiaBan"));
                book.setGioiThieuNgan(rs.getString("GioiThieuNgan"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public void addBook(Sach book){
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO dbo.SACH(MaTheLoai, TieuDe,  TenTacGia, NhaXB, GioiThieuNgan, SoLuong, GiaNhap, GiaBan) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getMaTheLoai());
            preparedStatement.setString(2, book.getTieuDe());
            preparedStatement.setString(3, book.getTenTacGia());
            preparedStatement.setString(4, book.getNhaXB());
            preparedStatement.setString(5, book.getGioiThieuNgan());
            preparedStatement.setInt(6, book.getSoLuong());
            preparedStatement.setInt(7, book.getGiaNhap());
            preparedStatement.setInt(8, book.getGiaBan());
            
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Sach getBookById(int MaSach){
         
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.SACH WHERE MaSach = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, MaSach);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Sach book = new Sach();
                book.setMaSach(rs.getInt("MaSach"));
                book.setMaTheLoai(rs.getInt("MaTheLoai"));
                book.setTieuDe(rs.getString("TieuDe"));
                book.setTenTacGia(rs.getString("TenTacGia"));
                book.setNhaXB(rs.getString("NhaXB"));
                book.setSoLuong(rs.getInt("SoLuong"));
                book.setGiaNhap(rs.getInt("GiaNhap"));
                book.setGiaBan(rs.getInt("GiaBan"));
                book.setGioiThieuNgan(rs.getString("GioiThieuNgan"));
                return book;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateBook(Sach book){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE dbo.SACH SET MaTheLoai=?,TieuDe=?,TenTacGia=?,NhaXB=?,SoLuong=?,GiaNhap=?,GiaBan=?,GioiThieuNgan=? WHERE MaSach=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getMaTheLoai());
            preparedStatement.setString(2, book.getTieuDe());
            preparedStatement.setString(3, book.getTenTacGia());
            preparedStatement.setString(4, book.getNhaXB());
            preparedStatement.setInt(5, book.getSoLuong());
            preparedStatement.setInt(6, book.getGiaNhap());
            preparedStatement.setInt(7, book.getGiaBan());
             preparedStatement.setString(8, book.getGioiThieuNgan());
            preparedStatement.setInt(9, book.getMaSach());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Sach> searchBookFromTitle(String title){
        List<Sach> books = new ArrayList<Sach>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.SACH where TieuDE LIKE ?";    
        
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
                Sach book = new Sach();
                book.setMaSach(rs.getInt("MaSach"));
                book.setMaTheLoai(rs.getInt("MaTheLoai"));
                book.setTieuDe(rs.getString("TieuDe"));
                book.setTenTacGia(rs.getString("TenTacGia"));
                book.setNhaXB(rs.getString("NhaXB"));
                book.setSoLuong(rs.getInt("SoLuong"));
                book.setGiaNhap(rs.getInt("GiaNhap"));
                book.setGiaBan(rs.getInt("GiaBan"));
                book.setGioiThieuNgan(rs.getString("GioiThieuNgan"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Sach> searchBookFromAuthor(String author){
        List<Sach> books = new ArrayList<Sach>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.SACH where TenTacGia LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(author);
        stringBufferTile.append("%");
        String authorLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, authorLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Sach book = new Sach();
                book.setMaSach(rs.getInt("MaSach"));
                book.setMaTheLoai(rs.getInt("MaTheLoai"));
                book.setTieuDe(rs.getString("TieuDe"));
                book.setTenTacGia(rs.getString("TenTacGia"));
                book.setNhaXB(rs.getString("NhaXB"));
                book.setSoLuong(rs.getInt("SoLuong"));
                book.setGiaNhap(rs.getInt("GiaNhap"));
                book.setGiaBan(rs.getInt("GiaBan"));
                book.setGioiThieuNgan(rs.getString("GioiThieuNgan"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Sach> searchBookFromNhaXB(String nhaXB){
        List<Sach> books = new ArrayList<Sach>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM dbo.SACH where NhaXB LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(nhaXB);
        stringBufferTile.append("%");
        String nhaXBLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaXBLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Sach book = new Sach();
                book.setMaSach(rs.getInt("MaSach"));
                book.setMaTheLoai(rs.getInt("MaTheLoai"));
                book.setTieuDe(rs.getString("TieuDe"));
                book.setTenTacGia(rs.getString("TenTacGia"));
                book.setNhaXB(rs.getString("NhaXB"));
                book.setSoLuong(rs.getInt("SoLuong"));
                book.setGiaNhap(rs.getInt("GiaNhap"));
                book.setGiaBan(rs.getInt("GiaBan"));
                book.setGioiThieuNgan(rs.getString("GioiThieuNgan"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public void deleteBook(int book_id){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE dbo.SACH WHERE MaSach=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
