/**
 * <pre>项目名称:layui-demo
 * 文件名称:MenuServiceImpl.java
 * 包名:com.jy.service.impl
 * 创建日期:2020年4月3日上午10:51:37
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre>
 */
package com.jy.service.menu.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jy.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.mapper.menu.MenuMapper;
import com.jy.model.menu.Menu;
import com.jy.service.menu.MenuService;

/**
 * <pre>项目名称：layui-demo
 * 类名称：MenuServiceImpl
 * 类描述：
 * 创建人：小白白 bai@bmail.com
 * 创建时间：2020年4月3日 上午10:51:37
 * 修改人：小白白 bai@bmail.com
 * 修改时间：2020年4月3日 上午10:51:37
 * 修改备注：
 * @version </pre>
 */
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;

	/* (non-Javadoc)
	 * @see com.jy.service.menu.MenuService#selectIndexMenuList(com.jy.model.menu.Menu)
	 */
	@Override
	public List<Menu> selectIndexMenuList(Menu menu) {
		// TODO Auto-generated method stub
		//查询回来所有父项
		List<Menu> list = menuMapper.selectIndexMenuList(menu);
		if(null != list && 0 < list.size()){
			for (Menu menu2 : list) {
				//new对象
				Menu m = new Menu();
				//将父项的ID作为子项的PID赋值
				m.setMenuPid(menu2.getMenuID());
				m.setUserID(menu.getUserID());
				//递归调用自己(原来的方法)得到所有子项
				List<Menu> list2 = selectIndexMenuList(m);
				//判断子项是否为空
				if(null != list2 && 0 < list2.size()){
					//若不为空将子项赋给父项
					menu2.setMenuList(list2);
				}
			}
		}

		//返回父项(一级菜单)
		return list;
	}
}
