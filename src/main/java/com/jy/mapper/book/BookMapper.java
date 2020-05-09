/** 
 * <pre>项目名称:ssm_mapper 
 * 文件名称:BookMapper.java 
 * 包名:com.jy.mapper.book 
 * 创建日期:2020年3月30日下午8:11:59 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.mapper.book;

import java.util.List;
import java.util.Map;

import com.jy.model.book.Book;

/** 
 * <pre>项目名称：ssm_mapper    
 * 类名称：BookMapper    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月30日 下午8:11:59    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月30日 下午8:11:59    
 * 修改备注：       
 * @version </pre>    
 */
public interface BookMapper {

	/** <pre>selectBookList(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午8:37:58    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午8:37:58    
	 * 修改备注： 
	 * @param book
	 * @return</pre>    
	 */
	List<Book> selectBookList(Book book);

	/** <pre>insertbook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:23:40    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:23:40    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void insertbook(Book book);

	/** <pre>deletebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:38:36    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:38:36    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void deletebook(Book book);

	/** <pre>selectBookByID(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:47:36    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:47:36    
	 * 修改备注： 
	 * @param book
	 * @return</pre>    
	 */
	Book selectBookByID(Book book);

	/** <pre>updatebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:56:17    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:56:17    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void updatebook(Book book);

	/** <pre>deleteonebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年4月3日 下午2:41:13    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年4月3日 下午2:41:13    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void deleteonebook(Book book);
	
}
