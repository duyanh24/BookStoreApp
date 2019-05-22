/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.dao;

import com.nhom3.entity.ChiTietHoaDon;
import com.nhom3.entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hoang Viet
 */
public class ChiTietHoaDonDao {
    public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon(int maHoaDon) {
        ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM CHI_TIET_HOA_DON WHERE MaHoaDon LIKE ?";
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, maHoaDon);
            ResultSet rs = preparedStatement.executeQuery();
            rs.beforeFirst();
            
            while (rs.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setMaHoaDon(rs.getInt("MaHoaDon"));
                chiTietHoaDon.setMaSach(rs.getInt("MaSach"));
                chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDon.setLaiSuat(rs.getFloat("LaiSuat"));
                chiTietHoaDons.add(chiTietHoaDon);
            }
            connection.close();
            preparedStatement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return chiTietHoaDons;
    }

    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException, ParseException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO dbo.CHI_TIET_HOA_DON (MaHoaDon,MaSach,SoLuong,LaiSuat) "
                    + "VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(2, chiTietHoaDon.getMaSach());
            preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
            preparedStatement.setFloat(4, chiTietHoaDon.getLaiSuat());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void deleteChiTietHoaDon(int maHoaDon,int maSach) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "DELETE FROM CHI_TIET_HOA_DON WHERE MaHoaDon LIKE ? AND MaSach LIKE ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maHoaDon);
            preparedStatement.setInt(2, maSach);
            int affect = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public int updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon, int maSachCu) throws ParseException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int check = 0;
        
        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE CHI_TIET_HOA_DON SET MaSach = ?, SoLuong = ?, LaiSuat = ?"
                    + " WHERE MaHoaDon = ? AND MaSach = ?";
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, chiTietHoaDon.getMaSach());
            preparedStatement.setInt(2, chiTietHoaDon.getSoLuong());
            preparedStatement.setFloat(3, chiTietHoaDon.getLaiSuat());
            preparedStatement.setInt(4, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(5, maSachCu);
            check = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return check;
    }
    
    public ArrayList<ChiTietHoaDon> searchChiTietHoaDon(int maHoaDon, String comboBox, String textField) {
        ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM CHI_TIET_HOA_DON WHERE " + comboBox + " LIKE \'%"+textField+"%\' AND MaHoaDon LIKE ?";
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //preparedStatement.setString(1, textField);
            //Save result into ResultSet
            preparedStatement.setInt(1, maHoaDon);
            ResultSet rs = preparedStatement.executeQuery();
            rs.beforeFirst();
            
            while (rs.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setMaHoaDon(rs.getInt("MaHoaDon"));
                chiTietHoaDon.setMaSach(rs.getInt("MaSach"));
                chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDon.setLaiSuat(rs.getFloat("LaiSuat"));
                chiTietHoaDons.add(chiTietHoaDon);
            }
            
            connection.close();
            preparedStatement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return chiTietHoaDons;
    }
    
}
