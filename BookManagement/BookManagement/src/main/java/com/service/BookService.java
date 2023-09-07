package com.service;

import com.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {


    //    增加操作
    public boolean save(Book book);

    //    更新操作
    public boolean update(Book book);

    //    删除操作
    public boolean delete(Integer id);

    //    按id查找
    public Book getById(Integer id);

    //    查找所有
    public List<Book> getByAll();

    //    名称查找
    public List<Book> getByName(String name);
//    List<Book> getByName();

    // public Book getByName(String name);
}


