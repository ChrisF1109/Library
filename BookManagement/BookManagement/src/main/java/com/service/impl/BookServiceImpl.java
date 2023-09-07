package com.service.impl;

import com.controller.Code;
import com.dao.BookDao;
import com.domain.Book;
import com.exception.BusinessException;
import com.exception.SystemException;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {


//        异常测试
//        if(id == 1){
//            throw new BusinessException(Code.BUSINESS_ERR,"请不要使用你的技术挑战我的耐性!");
//        }
//
//        try {
//            int i = 1/0;
//        }catch (Exception ex){
//
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试!",ex);
//
//        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getByAll() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getByName(String name) {
        return bookDao.getByName(name);
    }

    //    @Override
//    public Book getByName(String name) {
//        return bookDao.getByName(name);
//    }


}
