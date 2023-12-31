package com.dao;

import com.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

    //    @Insert("insert into tbl_book values(null,#{type},#{name},#{description}")
    @Insert("insert into tbl_book (type,name,description,price) values(#{type},#{name},#{description},#{price})")
    public int save(Book book);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description}, price = #{price} where id = #{id}")
    public int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getAll();

    @Select("select * from tbl_book where name like #{name}")
    public List<Book> getByName(String name);

//    List<Book> getByName(String name);

//    public Book getByName(String name);
}
