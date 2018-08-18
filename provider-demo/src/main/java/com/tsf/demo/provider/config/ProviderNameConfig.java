package com.tsf.demo.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 服务注册的名称
 * 文件名称:     ProviderNameConfig.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月16日下午2:12:51 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "provider.config")
public class ProviderNameConfig {
	private String name = "echo-provider-default-name";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}