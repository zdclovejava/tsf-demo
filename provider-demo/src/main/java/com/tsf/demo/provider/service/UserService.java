package com.tsf.demo.provider.service;
import com.github.pagehelper.PageInfo;
import com.tsf.demo.provider.model.PageParam;
import com.tsf.demo.provider.model.SysUser;

public interface UserService {
	
	public PageInfo<SysUser> findUserPage(SysUser sysUser,PageParam pageParam);
	
	public SysUser findUserByLoginName(String loginName);
	
	public boolean addUser(SysUser user);
	
	public SysUser getUser(Integer userId);
	
	public boolean updUser(SysUser user);
	
	public boolean delUser(Integer userId);
}
