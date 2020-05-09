/** 
 * <pre>项目名称:ssm_model 
 * 文件名称:Books.java 
 * 包名:com.jy.model 
 * 创建日期:2020年3月30日下午5:39:07 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */
package com.jy.model.book;

import java.io.Serializable;
import java.util.List;

import com.jy.common.PageUtil;

/**
 * <pre>
 * 项目名称：ssm_model    
 * 类名称：Books    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月30日 下午5:39:07    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月30日 下午5:39:07    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
public class Book extends PageUtil implements Serializable {
	private int bookID;

	private String bookName;

	private String bookAuthor;

	private int bookType;

	private float bookPrice;

	private String bookDesc;

	private String bookDateStr;
	
	private String bookStr;
	
	private String[] bookArr;
	
	private List<Integer> bookIDList;

	public List<Integer> getBookIDList() {
		return bookIDList;
	}

	public void setBookIDList(List<Integer> bookIDList) {
		this.bookIDList = bookIDList;
	}

	

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookType() {
		return bookType;
	}

	public void setBookType(int bookType) {
		this.bookType = bookType;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getBookDateStr() {
		return bookDateStr;
	}

	public void setBookDateStr(String bookDateStr) {
		this.bookDateStr = bookDateStr;
	}

	public String getBookStr() {
		return bookStr;
	}

	public void setBookStr(String bookStr) {
		this.bookStr = bookStr;
	}

	public String[] getBookArr() {
		return bookArr;
	}

	public void setBookArr(String[] bookArr) {
		this.bookArr = bookArr;
	}
	
	

}
