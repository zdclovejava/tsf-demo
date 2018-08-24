package com.tsf.demo.provider.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域访问
 * 文件名称:     CrossOriginConfig.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2018年8月18日上午9:26:37 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2018年8月18日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   深圳市至高通信技术发展有限公司
 */
//@Configuration
public class CrossOriginConfig extends WebMvcConfigurerAdapter{
	//GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
	@Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
       .allowedOrigins("*")
       .allowedMethods("GET", "POST","PUT","DELETE")
       .allowCredentials(false).maxAge(3600);
    }
}
