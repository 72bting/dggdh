/** 
 * <pre>项目名称:ssm_service 
 * 文件名称:BookService.java 
 * 包名:com.jy.service.book 
 * 创建日期:2020年3月30日下午8:05:20 
 * Copyright (c) 2020, bai@bmail.com All Rights Reserved.</pre> 
 */  
package com.jy.service.book;

import java.util.Map;

import com.jy.model.book.Book;

/** 
 * <pre>项目名称：ssm_service    
 * 类名称：BookService    
 * 类描述：    
 * 创建人：小白白 bai@bmail.com    
 * 创建时间：2020年3月30日 下午8:05:20    
 * 修改人：小白白 bai@bmail.com     
 * 修改时间：2020年3月30日 下午8:05:20    
 * 修改备注：       
 * @version </pre>    
 */
public interface BookService {

	/** <pre>selectBookList(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午8:34:14    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午8:34:14    
	 * 修改备注： 
	 * @param book
	 * @return</pre>    
	 */
	Map<String, Object> selectBookList(Book book);

	/** <pre>insertbook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:22:56    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:22:56    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void insertbook(Book book);

	/** <pre>deletebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:38:12    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:38:12    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void deletebook(Book book);

	/** <pre>selectBookByID(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:46:29    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:46:29    
	 * 修改备注： 
	 * @param book
	 * @return</pre>    
	 */
	Book selectBookByID(Book book);

	/** <pre>updatebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年3月30日 下午9:55:47    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年3月30日 下午9:55:47    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void updatebook(Book book);

	/** <pre>deleteonebook(这里用一句话描述这个方法的作用)   
	 * 创建人：小白白 bai@bmail.com    
	 * 创建时间：2020年4月3日 下午2:40:12    
	 * 修改人：小白白 bai@bmail.com     
	 * 修改时间：2020年4月3日 下午2:40:12    
	 * 修改备注： 
	 * @param book</pre>    
	 */
	void deleteonebook(Book book);

}
