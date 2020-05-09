/** 
 * <pre>项目名称:ssm_controller 
 * 文件名称:IndexController.java 
 * 包名:IndexController 
 * 创建日期:2020年3月30日下午5:18:45 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */
package com.jy.controller.index;

import java.util.List;
import java.util.Map;

import com.jy.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.model.menu.Menu;
import com.jy.service.menu.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * 项目名称：ssm_controller    
 * 类名称：IndexController    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月31日 下午5:03:45    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月31日 下午5:03:45    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("")
	String toIndexPage(HttpServletRequest request, ModelMap mm, Menu menu) {
		HttpSession session = request.getSession();
		Object suserInfo = session.getAttribute("suserInfo");
		if (null != suserInfo){
			Map<String,Object> map = (Map<String,Object>)suserInfo;
			User u = (User)map.get("userInfo");
			menu.setUserID(u.getUserID());
		}
		List<Menu> menulist = menuService.selectIndexMenuList(menu);
		//将左侧菜单树存到session中
		session.setAttribute("menulist",menulist);
		mm.addAttribute("list",menulist);
		return "index";
	}

	@RequestMapping("toNoPermision")
	String toNoPermisionPage() {
		return "405";
	}
}
