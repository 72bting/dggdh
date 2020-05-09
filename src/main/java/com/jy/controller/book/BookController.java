/** 
 * <pre>项目名称:ssm_controller 
 * 文件名称:BookController.java 
 * 包名:com.jy.controller.book 
 * 创建日期:2020年3月30日下午8:03:13 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.controller.book;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.model.book.Book;
import com.jy.service.book.BookService;

/** 
 * <pre>项目名称：ssm_controller    
 * 类名称：BookController    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月30日 下午8:03:13    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月30日 下午8:03:13    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("book/toList")
	String toList() {
		return "book/list";
	}
	
	@RequestMapping("book/list")
	@ResponseBody
	Map<String, Object> selectBookList(Book book) {
		Map<String, Object> map = bookService.selectBookList(book);
		return map;
	}
	
	@RequestMapping("book/toAddPage")
	String toAddBookPage(Book book){
		return "book/add";
	}
	
	@RequestMapping("book/insert")
	@ResponseBody
	String bookinsert(Book book){
		bookService.insertbook(book);
		return "{}";
	}
	
	@RequestMapping("book/delete")
	@ResponseBody
	String bookdelete(Book book){
		bookService.deletebook(book);
		return "{}";
	}
	
	@RequestMapping("book/deleteOne")
	@ResponseBody
	String onebookdelete(Book book){
		bookService.deleteonebook(book);
		return "{}";
	}

	@RequestMapping("book/edit")
	String selectBookByID(Book book,ModelMap mm){
		Book bk = bookService.selectBookByID(book);
		mm.addAttribute("book",bk);
		return "book/edit";
	}
	@RequestMapping("book/update")
	String updatebook(Book book){
		bookService.updatebook(book);
		return "{}";
	}
}
