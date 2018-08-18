package com.tsf.demo.provider.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.tsf.demo.provider.common.BaseResult;
import com.tsf.demo.provider.common.PageResult;
import com.tsf.demo.provider.config.ProviderNameConfig;
import com.tsf.demo.provider.config.ResultCodeConfig.RetCode;
import com.tsf.demo.provider.model.PageParam;
import com.tsf.demo.provider.model.SysMenu;
import com.tsf.demo.provider.model.SysUser;
import com.tsf.demo.provider.service.MenuService;
import com.tsf.demo.provider.service.UserService;

/**
 * 测试注册到服务中心的API
 * 文件名称:     ApiController.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月16日下午2:14:04 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
@RestController
public class ApiController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private ProviderNameConfig providerNameConfig;
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	/**
	 * 测试远程调用
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
	public BaseResult echo(@PathVariable String param) {
		LOG.info("provider-demo -- request param: [" + param + "]");
		String result = "request param: " + param + ", response from " + providerNameConfig.getName();
		LOG.info("provider-demo -- provider config name: [" + providerNameConfig.getName() + ']');
		LOG.info("provider-demo -- response info: [" + result + "]");
		return new BaseResult(RetCode.OK,result);
	}
	
	/**
	 * 远程调用users
	 * @return
	 */
	@RequestMapping(value = "/users/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public PageResult users(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
		PageParam pageParam = new PageParam(pageNum,pageSize);
		PageInfo<SysUser> pageUser= userService.findUserPage(null,pageParam);
		return new PageResult(pageUser);
	}
	
	/**
	 * 远程调用menus
	 * @return
	 */
	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	public PageResult menus(PageParam pageParam){
		PageInfo<SysMenu> pageMenu= menuService.findMenuPage(null,pageParam);
		return new PageResult(pageMenu);
	}
	
	/**
	 * 远程调用menus
	 * @return
	 */
	@RequestMapping(value = "/rb/menus", method = RequestMethod.POST)
	public PageResult rbmenus(@RequestBody PageParam pageParam){
		PageInfo<SysMenu> pageMenu= menuService.findMenuPage(null,pageParam);
		return new PageResult(pageMenu);
	}
	
	/**
	 * 远程调用menus
	 * @return
	 */
	@RequestMapping(value = "/rp/menus", method = RequestMethod.POST)
	public PageResult rpmenus(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
		PageParam pageParam = new PageParam(pageNum,pageSize);
		PageInfo<SysMenu> pageMenu= menuService.findMenuPage(null,pageParam);
		return new PageResult(pageMenu);
	}
}