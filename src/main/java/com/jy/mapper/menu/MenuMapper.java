/** 
 * <pre>项目名称:layui-demo 
 * 文件名称:MenuMapper.java 
 * 包名:com.jy.mapper.menu 
 * 创建日期:2020年4月3日上午11:06:55 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.mapper.menu;

import java.util.List;

import com.jy.model.menu.Menu;
import com.jy.model.user.User;

/** 
 * <pre>项目名称：layui-demo    
 * 类名称：MenuMapper    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年4月3日 上午11:06:55    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年4月3日 上午11:06:55    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuMapper {

	/** <pre>selectIndexMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年4月3日 上午11:27:53    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年4月3日 上午11:27:53    
	 * 修改备注： 
	 * @param menu
	 * @return</pre>    
	 */
	List<Menu> selectIndexMenuList(Menu menu);

}
