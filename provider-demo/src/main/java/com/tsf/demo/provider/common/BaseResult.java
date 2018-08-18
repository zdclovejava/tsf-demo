package com.tsf.demo.provider.common;

import com.tsf.demo.provider.config.ResultCodeConfig.RetCode;

/**
 * 常规信息返回
 * 文件名称:     BaseResult.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月16日下午2:10:12 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
public final class BaseResult {
	//返回码
	private String ret_code;
	//结果提示
	private String ret_msg;
	//返回数据
	private Object ret_obj;
	
	
	public BaseResult(RetCode retCode){
		this.setRet_code(retCode.getRet_code());
		this.setRet_msg(retCode.getRet_desc());
	}
	public BaseResult(RetCode retCode,Object retObj){
		this.setRet_code(retCode.getRet_code());
		this.setRet_msg(retCode.getRet_desc());
		this.setRet_obj(retObj);
	}
	
	public BaseResult(String retCode,String retMsg){
		this.setRet_code(retCode);
		this.setRet_msg(retMsg);
	}
	
	public BaseResult(String retCode,String retMsg,Object retObj){
		this.setRet_code(retCode);
		this.setRet_msg(retMsg);
		this.setRet_obj(retObj);
	}
	
	public BaseResult(Object retObj){
		this.setRet_code(RetCode.OK.getRet_code());
		this.setRet_msg(RetCode.OK.getRet_desc());
		this.setRet_obj(retObj);
	}

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}

	public Object getRet_obj() {
		return ret_obj;
	}

	public void setRet_obj(Object ret_obj) {
		this.ret_obj = ret_obj;
	}

	
	
}
