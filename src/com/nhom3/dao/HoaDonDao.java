/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.dao;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Viet
 */
public class HoaDonDao {
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();
            //query statement
            String sql = "SELECT * FROM HOA_DON";
            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //ResultSet to store data from database after getting
            ResultSet rs = preparedStatement.executeQuery();
            //pointer before first data
            rs.beforeFirst();

            while (rs.next()) {
                //Create NhanVien object to save data
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setMaKH(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("MaNhanVien"));
                Date dateNgayBan = rs.getDate("NgayBan");
                DateFormat dateFormatNgayMuon = new SimpleDateFormat("yyyy-MM-dd");
                hoaDon.setNgayBan(dateFormatNgayMuon.format(dateNgayBan));
                hoaDon.setTongTien(rs.getInt("TongTien"));
                //add NhanVien into arrayList
                hoaDons.add(hoaDon);
            }
            //close Object and free Resource
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

        return hoaDons;
    }

    public void addHoaDon(HoaDon hoaDon) throws SQLException, ParseException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();
            //query statement
            String sql = "INSERT INTO dbo.HOA_DON (MaKH,MaNhanVien,NgayBan,TongTien) "
                    + "VALUES (?,?,?,?)";
            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //pass param
            preparedStatement.setString(1, hoaDon.getMaKH());
            preparedStatement.setString(2, hoaDon.getMaNhanVien());
            //get String data
            String date = hoaDon.getNgayBan();
            //Convert String to Date
            java.util.Date dateNgayBan = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            //Convert Date to longTime and pass param by sql.Date
            java.sql.Date dateSqlNgayBan = new java.sql.Date(dateNgayBan.getTime());
            preparedStatement.setDate(3, dateSqlNgayBan);
            preparedStatement.setInt(4, hoaDon.getTongTien());
            //INSERT INTO must use 
            preparedStatement.executeUpdate();
            //close Object and free Resource
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

    public void deleteHoaDon(String maHoaDon) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();
            //SQL statement to execute
            String sql = "DELETE FROM HOA_DON WHERE MaHoaDon LIKE ?";
            //complie sql and pass param use prepareStatement
            preparedStatement = connection.prepareStatement(sql);
            //Pass Param
            preparedStatement.setString(1, maHoaDon);
            int affect = preparedStatement.executeUpdate();
            //close object and free resource
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

    public int updateHoaDon(HoaDon hoaDon) throws ParseException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int check = 0;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();
            //query statement
            String sql = "UPDATE HOA_DON SET MaKH = ?, MaNhanVien = ?, NgayBan = ?, TongTien = ? "
                    + "WHERE MaHoaDon = ?";
            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //pass param
            preparedStatement.setString(1, hoaDon.getMaKH());
            preparedStatement.setString(2, hoaDon.getMaNhanVien());
            //get String data
            String date = hoaDon.getNgayBan();
            //Convert String to Date
            java.util.Date dateNgayBan = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            //Convert Date to longTime and pass param by sql.Date
            java.sql.Date dateSqlNgayBan = new java.sql.Date(dateNgayBan.getTime());
            preparedStatement.setDate(3, dateSqlNgayBan);
            preparedStatement.setInt(4, hoaDon.getTongTien());
            preparedStatement.setString(5, hoaDon.getMaHoaDon());
            //INSERT INTO must use executeUpdate
            check = preparedStatement.executeUpdate();
            
            //close Object and free Resource
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
    
    public ArrayList<HoaDon> searchHoaDon(String comboBox, String textField) {
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();
            //SQL query
            String sql = "SELECT * FROM HOA_DON WHERE " + comboBox + " LIKE \'%"+textField+"%\'";
            //Create PreparedStatement Object from Connection
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //preparedStatement.setString(1, textField);
            //Save result into ResultSet
            ResultSet rs = preparedStatement.executeQuery();
            rs.beforeFirst();

            while (rs.next()) {
                //Create NhanVien object to save data
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setMaKH(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("MaNhanVien"));
                Date dateNgayBan = rs.getDate("NgayBan");
                DateFormat dateFormatNgayMuon = new SimpleDateFormat("yyyy-MM-dd");
                hoaDon.setNgayBan(dateFormatNgayMuon.format(dateNgayBan));
                hoaDon.setTongTien(rs.getInt("TongTien"));
                //add NhanVien into arrayList
                hoaDons.add(hoaDon);
            }

            //close object and free resource
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

        return hoaDons;
    }
    
    public ArrayList<HoaDon> thongKeHoaDon(String comboBox) {
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();
            //SQL query
            String sql = "SELECT " + comboBox+", COUNT("+comboBox+") AS 'SoLuong' FROM HOA_DON GROUP BY "+comboBox+"\n" 
                    +"ORDER BY COUNT("+comboBox+");";
            //Create PreparedStatement Object from Connection
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Save result into ResultSet
            ResultSet rs = preparedStatement.executeQuery();
            rs.beforeFirst();

            if (comboBox.equals("MaKH")) {
                //do-sonething
                while (rs.next()) {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setMaKH(rs.getString("MaKH"));
                    hoaDon.setSoLuong(rs.getInt("SoLuong"));
                    hoaDons.add(hoaDon);
                }
            } else if (comboBox.equals("MaNhanVien")) {
                //do-sonething
                while (rs.next()) {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setMaNhanVien(rs.getString("MaNhanVien"));
                    hoaDon.setSoLuong(rs.getInt("SoLuong"));
                    hoaDons.add(hoaDon);
                }
            } else if (comboBox.equals("")) {
                //do-sonething
            }
            //close object and free resource
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

        return hoaDons;
    }
    
    public HoaDon getHoaDonById(int maHoaDon) {
        HoaDon hoaDon = new HoaDon();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();

            //query statement
            String sql = "SELECT * FROM HOA_DON WHERE MaHoaDon = ?";

            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, maHoaDon);
            //ResultSet to store data from database after getting
            ResultSet rs = preparedStatement.executeQuery();

            //pointer before first data
            rs.beforeFirst();

            while (rs.next()) {
                //Create NhanVien object to save data
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setMaKH(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("MaNhanVien"));

                Date dateNgayBan = rs.getDate("NgayBan");
                DateFormat dateFormatNgayMuon = new SimpleDateFormat("yyyy-MM-dd");
                hoaDon.setNgayBan(dateFormatNgayMuon.format(dateNgayBan));

                hoaDon.setTongTien(rs.getInt("TongTien"));
            }

            //close Object and free Resource
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

        return hoaDon;
    }
}
