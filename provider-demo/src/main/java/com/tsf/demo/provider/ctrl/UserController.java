package com.tsf.demo.provider.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tsf.demo.provider.common.BaseResult;
import com.tsf.demo.provider.config.EnumConfig.ErrCode;
import com.tsf.demo.provider.config.EnumConfig.RetCode;
import com.tsf.demo.provider.config.EnumConfig.UserStatus;
import com.tsf.demo.provider.model.SysMenu;
import com.tsf.demo.provider.model.SysUser;
import com.tsf.demo.provider.service.MenuService;
import com.tsf.demo.provider.service.UserService;
import com.tsf.demo.provider.utils.CommonUtil;

/**
 * 用户相关API
 * 文件名称:     UserController.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月23日上午9:51:29 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月23日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 用户登录
	 * @param jsonParam
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public BaseResult userLogin(@RequestBody JSONObject jsonParam){
		LOG.info("------------recv param={}",jsonParam);
		//查找用户信息
		SysUser user = userService.findUserByLoginName(jsonParam.getString("username"));
		if(user==null){
			return new BaseResult(RetCode.VALID_ERR,ErrCode.VALID_NAMEPWD_ERR);
		}
		//密码校验
		String encrpyPwd = CommonUtil.encrypUserPwd(jsonParam.getString("password"), user.getPwdSalt());
		if(!encrpyPwd.equals(user.getLoginPwd())){
			return new BaseResult(RetCode.VALID_ERR,ErrCode.VALID_NAMEPWD_ERR);
		}
		//用户状态校验
		if(user.getUserStatus().equals(UserStatus.InActive)){
			return BaseResult.getDesignErr(RetCode.BUSI_ERR, ErrCode.COM_BUSI_ERR, "该用户状态异常");
		}
		//获取用户菜单列表
		List<SysMenu> menuList = menuService.findMenuByUserId(user.getUserId());
		user.setMenuList(menuList);
		//将用户信息保存至session
		super.setSession("user", user);
		//校验通过后返回用户信息
		return new BaseResult(user);
	}
}
