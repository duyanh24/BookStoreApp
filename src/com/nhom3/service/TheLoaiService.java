
package com.nhom3.service;

import com.nhom3.dao.TheLoaiDao;
import com.nhom3.entity.TheLoai;
import java.util.List;

public class TheLoaiService {
    
    private TheLoaiDao theLoaiDao;

    public TheLoaiService() {
        theLoaiDao = new TheLoaiDao();
    }
    
    public List<TheLoai> getAllCategory(){
        return theLoaiDao.getAllCategory();
    }
    
    public int getCategoryIdByValue(String value){
        return theLoaiDao.getCategoryIdByValue(value);
    }
    
    public String getCategoryById(int maTheLoai){
        return theLoaiDao.getCategoryById(maTheLoai);
    }
    
    public List<TheLoai> searchFromTitle(String title){
        return theLoaiDao.searchFromTitle(title);
    }
    
    public void deleteCategory(int maTheLoai){
        theLoaiDao.deleteCategory(maTheLoai);
    }
    
    public void addCategory(TheLoai category){
        theLoaiDao.addCategory(category);
    }
    
    public void updateCategory(TheLoai category){
        theLoaiDao.updateCategory(category);
    }
}
