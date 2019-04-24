/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.service;

import com.nhom3.dao.NhanVienDao;
import com.nhom3.entity.nhanvien;
import java.util.List;

/**
 *
 * @author User
 */
public class NhanVienService {
    private NhanVienDao NvDao;

    public NhanVienService() {
        NvDao = new NhanVienDao();
    }
    
    public List<nhanvien> getAllNhanVien(){
        return NvDao.getAllNhanVien();
    }
    
    public void addNhanVien(nhanvien nv){
        NvDao.addNhanVien(nv);
    }
    
    public nhanvien getNVById(String MaNhanVien){
        return NvDao.getNVById(MaNhanVien);
    }
    
    public void updateNhanVien(nhanvien nv){
        NvDao.updateNhanVien(nv);
    }
    
    public List<nhanvien> searchNVFromChucVu(String ChucVu){
        return NvDao.searchNVFromChucVu(ChucVu);
    }
    
    public List<nhanvien> searchNVFromName(String Name){
        return NvDao.searchNVFromName(Name);
    }
    
    
    public void deleteNhanVien(String MaNhanVien){
        NvDao.deleteNhanVien(MaNhanVien);
    }
}
