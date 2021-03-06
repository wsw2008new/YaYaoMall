package com.yayao.service;

import java.util.List;

import com.yayao.bean.User;
/**
 * 账户业务接口
 * @author yy
 *
 */
public interface UserService {
	/** 账户登录 */
	public User userLogin(String userName,String userPassword) ;	
	/** 检测登录账户是否有效 */	
	public boolean chkLoginName(String userName) ;
	/** 找回账户 */	
	public User RetrieveAccount(String userName) ;
	/** 新增注册账户 */	
	public boolean addUser(User user) ;
	/** 修改注册账户 */	
	public void updateUser(User user) ;
	/** 查询注册账户  */
	public List<User> searchUser(String hql) ;
	/** 浏览注册账户*/
	public List<User> browseUser() ;
	/** 管理员浏览注册会员*/
	public List<User> adminBrowseUser() ;
	/** 删除注册账户 */	
	public void delUser(Integer id) ;
	/**装载注册账户 */	
	public User loadUser(Integer id) ;	
}
