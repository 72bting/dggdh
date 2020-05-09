/** 
 * <pre>项目名称:layui-demo 
 * 文件名称:MenuService.java 
 * 包名:com.jy.service 
 * 创建日期:2020年4月3日上午10:49:15 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.service.menu;

import java.util.List;
import java.util.Map;

import com.jy.model.menu.Menu;
import com.jy.model.user.User;

/** 
 * <pre>项目名称：layui-demo    
 * 类名称：MenuService    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年4月3日 上午10:49:15    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年4月3日 上午10:49:15    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuService {

	/** <pre>selectIndexMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年4月3日 上午11:27:30    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年4月3日 上午11:27:30    
	 * 修改备注： 
	 * @param menu
	 * @return</pre>    
	 */
	List<Menu> selectIndexMenuList(Menu menu);


}
