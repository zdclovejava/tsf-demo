package com.tsf.demo.provider.dao;
import java.util.List;

import com.tsf.demo.provider.model.SysMenu;

public interface SysMenuMapper {

    int deleteByPrimaryKey(Integer menuId);
    
    List<SysMenu> findByUserId(Integer userId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByPageNumSize(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}