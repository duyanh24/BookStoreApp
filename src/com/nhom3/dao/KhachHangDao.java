/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.dao;

import com.nhom3.entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Viet
 */
public class KhachHangDao {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();

            //query statement
            String sql = "SELECT * FROM KHACH_HANG";

            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //ResultSet to store data from database after getting
            ResultSet rs = preparedStatement.executeQuery();

            //pointer before first data
            rs.beforeFirst();

            while (rs.next()) {
                //Create NhanVien object to save data
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setHoTen(rs.getString("HoTen"));
                khachHang.setSoDT(rs.getString("SoDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));

                //add NhanVien into arrayList
                khachHangs.add(khachHang);
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

        return khachHangs;
    }

    public void addKhachHang(KhachHang khachHang) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();

            //query statement
            String sql = "INSERT INTO KHACH_HANG(HoTen,SoDT,DiaChi) "
                    + "VALUES (?,?,?)";

            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //pass param
            preparedStatement.setString(1, khachHang.getHoTen());
            preparedStatement.setString(2, khachHang.getSoDT());
            preparedStatement.setString(3, khachHang.getDiaChi());

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

    public void deleteKhachHang(int maKH) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();

            //SQL statement to execute
            String sql = "DELETE FROM KHACH_HANG WHERE MaKH LIKE ?";

            //complie sql and pass param use prepareStatement
            preparedStatement = connection.prepareStatement(sql);

            //Pass Param
            preparedStatement.setInt(1, maKH);

            preparedStatement.executeUpdate();

            //close object and free resource
            connection.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
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

    public int updateKhachHang(KhachHang khachHang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int check = 0;
        try {
            //Create Connnection object to connect MySql server and create Prestatement object
            connection = JDBCConnection.getJDBCConnection();

            //query statement
            String sql = "UPDATE KHACH_HANG SET HoTen = ?, SoDT = ?, DiaChi = ? "
                    + "WHERE MaKH = ?";

            //Create Prestatement object to execute query
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //pass param
            preparedStatement.setString(1, khachHang.getHoTen());
            preparedStatement.setString(2, khachHang.getSoDT());
            preparedStatement.setString(3, khachHang.getDiaChi());
            preparedStatement.setString(4, khachHang.getMaKH());

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

    public ArrayList<KhachHang> searchKhachHang(String comboBox, String textField) {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();

            //SQL query
            String sql = "SELECT * FROM KHACH_HANG WHERE " + comboBox + " LIKE \'%" + textField + "%\'";

            //Create PreparedStatement Object from Connection
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //preparedStatement.setString(1, textField);
            //Save result into ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            rs.beforeFirst();

            while (rs.next()) {
                //Create NhanVien object to save data
                KhachHang khachHang = new KhachHang();

                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setHoTen(rs.getString("HoTen"));
                khachHang.setSoDT(rs.getString("SoDT"));
                khachHang.setDiaChi(rs.getString("DiaChi"));

                //add NhanVien into arrayList
                khachHangs.add(khachHang);
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
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return khachHangs;
    }

    public ArrayList<KhachHang> thongKeKhachHang(String comboBox) {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();

            //SQL query
            String sql = "SELECT " + comboBox + ", COUNT(" + comboBox + ") AS 'SoKH' FROM KHACH_HANG GROUP BY " + comboBox + "\n"
                    + "ORDER BY COUNT(" + comboBox + ");";
            //Create PreparedStatement Object from Connection
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Save result into ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            rs.beforeFirst();

            if (comboBox.equals("DiaChi")) {
                while (rs.next()) {
                    KhachHang khachHang = new KhachHang();

                    khachHang.setDiaChi(rs.getString("DiaChi"));
                    khachHang.setSoKH(rs.getInt("SoKH"));

                    khachHangs.add(khachHang);
                }

            } else if (comboBox.equals("")) {
                //do-sonething
            } else if (comboBox.equals("")) {
                //do-sonething
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
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return khachHangs;
    }

    public KhachHang getKhachHangById(int maKH) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        KhachHang khachHang = new KhachHang();

        try {
            //Create Connection Object
            connection = JDBCConnection.getJDBCConnection();

            //SQL query
            String sql = "SELECT * FROM KHACH_HANG WHERE MaKH = ?";

            //Create PreparedStatement Object from Connection
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, maKH);
            ;

            //Use executeUpdate when DELETE
            rs = preparedStatement.executeQuery();

            rs.beforeFirst();

            while (rs.next()) {
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setHoTen(rs.getString("HoTen"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setSoDT(rs.getString("SoDT"));
            }

            //close object and free resource
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return khachHang;
    }
}
