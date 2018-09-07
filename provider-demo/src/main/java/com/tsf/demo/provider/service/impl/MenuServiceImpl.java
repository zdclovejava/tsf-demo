package com.tsf.demo.provider.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsf.demo.provider.dao.SysMenuMapper;
import com.tsf.demo.provider.model.PageParam;
import com.tsf.demo.provider.model.SysMenu;
import com.tsf.demo.provider.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private SysMenuMapper menuMapper;
	
	@Override
	public List<SysMenu> findMenuByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return menuMapper.findByUserId(userId);
	}

	@Override
	public PageInfo<SysMenu> findMenuPage(SysMenu sysMenu, PageParam pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
		return  new PageInfo<SysMenu>(menuMapper.selectByPageNumSize(sysMenu));
	}

	@Override
	public void parseUserMenu(SysMenu rootMenu,List<SysMenu> menuList) {
		List<SysMenu> childList = this.getChildList(rootMenu.getMenuId(), menuList);
		rootMenu.setChildList(childList);
		if(childList!=null && childList.size()>0){
			for(SysMenu menu : rootMenu.getChildList()){
				this.parseUserMenu(menu,menuList);
				System.out.println("我遍历了----");
			}
		}
	}
	
	private List<SysMenu> getChildList(Integer menuId,List<SysMenu> menuList){
		List<SysMenu> childList = new ArrayList<SysMenu>();
		for(SysMenu sysMenu : menuList){
			if(sysMenu.getParentId()==menuId){
				childList.add(sysMenu);
				System.out.println("我遍历了----");
			}
		}
		return childList;
	}

}
