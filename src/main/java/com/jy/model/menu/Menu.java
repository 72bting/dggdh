/** 
 * <pre>项目名称:ssm_model 
 * 文件名称:Menu.java 
 * 包名:com.jy.model 
 * 创建日期:2020年4月3日上午10:36:28 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */
package com.jy.model.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 项目名称：ssm_model    
 * 类名称：Menu    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年4月3日 上午10:36:28    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年4月3日 上午10:36:28    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
public class Menu {

	private int menuID;
	
	private String menuText;
	
	private String menuHref;
	
	private int menuPid;

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	private String menuType;
	
	private List<Menu> menuList = new ArrayList();

	//添加业务字段
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getMenuText() {
		return menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public int getMenuPid() {
		return menuPid;
	}

	public void setMenuPid(int menuPid) {
		this.menuPid = menuPid;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
