package com.tsf.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.tsf.core.TsfContext;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import model.PageParam;

@RestController
public class Controller {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	@Autowired
	private EchoService echoService;

	@RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
	public String rest(@PathVariable String str, @RequestParam String user) {
		TsfContext.putTag("user", user);
		return restTemplate.getForObject("http://provider-demo/echo/" + str, String.class);
	}

	@RequestMapping(value = "/echo-async-rest/{str}", method = RequestMethod.GET)
	public String asyncRest(@PathVariable String str, @RequestParam String user) throws Exception {
		TsfContext.putTag("user", user);
		ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate
				.getForEntity("http://provider-demo/echo/" + str, String.class);
		return future.get().getBody();
	}

	@RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
	public String feign(@PathVariable String str, @RequestParam String user) {
		TsfContext.putTag("user", user);
		return echoService.echo(str);
	}
	
	/**
	 * Feign方式传递对象有效
	 * @param pageParam
	 * @return
	 */
	@RequestMapping(value = "/echo-menus", method = RequestMethod.POST)
	public String echomenus(PageParam pageParam) {
		return echoService.menus(pageParam);
	}
	
	/**
	 * 传递对象有效
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/echo-rp-menus", method = RequestMethod.POST)
	public String echorbmenus(@RequestBody PageParam pageParam) throws Exception {
		ResponseEntity<String> postForEntity = restTemplate.postForEntity("http://provider-demo/rb/menus/", pageParam, String.class);
		return postForEntity.getBody();
	}
	
	
	/**
	 * 异步返回，传递对象有效
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/echo-async-menus", method = RequestMethod.POST)
	public String echoasyncmenus(@RequestBody PageParam pageParam) throws Exception {
		HttpEntity<PageParam> request = new HttpEntity<PageParam>(pageParam);
		ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.postForEntity("http://provider-demo/rb/menus/", request, String.class);
		return future.get().getBody();
	}
}