package com.tsf.demo.provider.config;

/**
 * 返回码定义
 * 文件名称:     ResultCodeConfig.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月16日下午2:13:27 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class ResultCodeConfig {
	
	public enum RetCode{
		OK("00","成功"),
		SYS_ERR("01","系统异常"),
		RUN_ERR("02","运行异常"),
		DATA_ERR("03","数据异常"),
		BUSI_ERR("04","业务逻辑异常"),
		VALID_ERR("05","数据校验异常"),
		OTHER_ERR("06","其它异常");
		
		private String ret_code;
		private String ret_desc;
		
		private RetCode(String code,String desc){
			setRet_code(code);
			setRet_desc(desc);
		}

		public String getRet_code() {
			return ret_code;
		}

		public void setRet_code(String ret_code) {
			this.ret_code = ret_code;
		}

		public String getRet_desc() {
			return ret_desc;
		}

		public void setRet_desc(String ret_desc) {
			this.ret_desc = ret_desc;
		}
	}
}
