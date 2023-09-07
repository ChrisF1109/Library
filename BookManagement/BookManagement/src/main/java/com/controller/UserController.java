package com.controller;


import com.domain.Book;
import com.domain.User;
import com.service.BookService;
import com.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{username}")
    public Result getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @RequestMapping(value = "/getByVistorsname")
    public Result getByVistorsname(@RequestParam("vistorsname") String vistorsname) {
        System.out.println("==============");
        User user = userService.getByVistorsname(vistorsname);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }
}
