package com.controller;


import com.domain.Book;
import com.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        System.out.println("新建");
        boolean flag = bookService.save(book);
        System.out.println("新建222");
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试！";
        return new Result(code, book, msg);
    }


    @RequestMapping(value = "/getByName")
    public Result getByName(@RequestParam("name") String name) {
        System.out.print(name);
        List<Book> book = bookService.getByName("%" + name + "%");
        System.out.print("name1");
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试！";
        return new Result(code, book, msg);
    }

//    @GetMapping("/getByName")
//    public Result getByName(@RequestParam ("name")String name) {
//        List<Book> bookListName = bookService.getByName("%"+name+"%");
//        Integer code = bookListName != null ? Code.GET_OK : Code.GET_ERR;
//        String msg = bookListName != null ? "" : "数据查询失败，请重试！";
//        return new Result(code,bookListName,msg);
//    }


    @GetMapping
    public Result getByAll() {
        //System.out.print("name");
        List<Book> bookList = bookService.getByAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bookList, msg);
    }


}
