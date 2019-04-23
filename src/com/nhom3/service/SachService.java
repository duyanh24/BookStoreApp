
package com.nhom3.service;

import com.nhom3.dao.SachDao;
import com.nhom3.entity.Sach;
import java.util.List;

public class SachService {
    private SachDao sachDao;

    public SachService() {
        sachDao = new SachDao();
    }
    
    public List<Sach> getAllBook(){
        return sachDao.getAllBook();
    }
    
    public void addBook(Sach book){
        sachDao.addBook(book);
    }
    
    public Sach getBookById(int book_id){
        return sachDao.getBookById(book_id);
    }
    
    public void updateBook(Sach book){
        sachDao.updateBook(book);
    }
    
    public List<Sach> searchBookFromTitle(String title){
        return sachDao.searchBookFromTitle(title);
    }
    
    public List<Sach> searchBookFromAuthor(String author){
        return sachDao.searchBookFromAuthor(author);
    }
    
    public List<Sach> searchBookFromNhaXB(String nhaXB){
        return sachDao.searchBookFromNhaXB(nhaXB);
    }
    
    public void deleteBook(int book_id){
        sachDao.deleteBook(book_id);
    }
}
