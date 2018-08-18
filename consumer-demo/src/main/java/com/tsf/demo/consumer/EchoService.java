package com.tsf.demo.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.PageParam;



@FeignClient(name = "provider-demo")
public interface EchoService {
	@RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
	String echo(@PathVariable("str") String str);
	
	@RequestMapping(value = "/rb/menus", method = RequestMethod.POST)
	String menus(@RequestBody PageParam pageParam);
}