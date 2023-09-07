package com.dao;

import com.domain.Book;
import com.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from tbl_users where username = #{username}")
    public User getByUsername(String username);

    @Select("select * from tbl_vistors where vistorsname = #{vistorsname}")
    public User getByVistorsname(String vistorsname);
}
