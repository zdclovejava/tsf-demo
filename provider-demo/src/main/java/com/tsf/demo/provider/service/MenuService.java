package com.tsf.demo.provider.service;


import java.util.List;
import com.github.pagehelper.PageInfo;
import com.tsf.demo.provider.model.PageParam;
import com.tsf.demo.provider.model.SysMenu;

public interface MenuService {
	public List<SysMenu> findMenuByUserId(Integer userId);
	public PageInfo<SysMenu> findMenuPage(SysMenu sysMenu, PageParam pageParam);
	
	public void parseUserMenu(SysMenu rootMenu,List<SysMenu> menuList);
}
