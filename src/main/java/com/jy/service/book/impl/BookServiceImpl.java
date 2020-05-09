/** 
 * <pre>项目名称:ssm_service 
 * 文件名称:BookServiceImpl.java 
 * 包名:com.jy.service.book.impl 
 * 创建日期:2020年3月30日下午8:06:37 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.service.book.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jy.mapper.book.BookMapper;
import com.jy.model.book.Book;
import com.jy.service.book.BookService;

/** 
 * <pre>项目名称：ssm_service    
 * 类名称：BookServiceImpl    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月30日 下午8:06:37    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月30日 下午8:06:37    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper;

	/* (non-Javadoc)    
	 * @see com.jy.service.book.BookService#selectBookList(com.jy.model.book.Book)    
	 */
	public Map<String, Object> selectBookList(Book book) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap();
		//开启分页
		PageHelper.startPage(book.getPage(), book.getLimit());
		List<Book> list = bookMapper.selectBookList(book);
		//转化
		Page page = (Page) list;
		//获取总条数
		long total = page.getTotal();
		
		map.put("code", 0);
		map.put("msg","");
		map.put("data", list);
		map.put("count", total);
		return map;
	}

	/* (non-Javadoc)    
	 * @see com.jy.service.BookService#insertbook(com.jy.model.Book)    
	 */
	public void insertbook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.insertbook(book);
	}

	/* (non-Javadoc)    
	 * @see com.jy.service.BookService#deletebook(com.jy.model.Book)    
	 */
	//四种批量删除方式：
	public void deletebook(Book book) {
		// TODO Auto-generated method stub
		
		//1.直接传数据在sql中$取值 
//		bookMapper.deletebook(book);
		
		
		//2.将数组作为参数传到sql
//		String arr = book.getBookStr();
//		String[] split = arr.split(",");
//		book.setBookArr(split);
		
		
		//3.将集合作为参数传到sql
//		String arr = book.getbookStr();
//		String[] split = arr.split(",");
//		List<Integer> bookIDList = new ArrayList<>();
//		for (String string : split) {
//			bookIDList.add(Integer.parseInt(string));
//		}
//		book.setBookIDList(bookIDList);

		//4.直接传字符串在sql中分隔
		bookMapper.deletebook(book);
	}

	/* (non-Javadoc)    
	 * @see com.jy.service.BookService#selectBookByID(com.jy.model.Book)    
	 */
	public Book selectBookByID(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.selectBookByID(book);
	}

	/* (non-Javadoc)    
	 * @see com.jy.service.BookService#updatebook(com.jy.model.Book)    
	 */
	public void updatebook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.updatebook(book);
	}

	/* (non-Javadoc)    
	 * @see com.jy.service.book.BookService#deleteonebook(com.jy.model.book.Book)    
	 */
	@Override
	public void deleteonebook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.deleteonebook(book);
	}
}
