package com.tsf.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LocalService {
	private static final Logger LOG = LoggerFactory.getLogger(LocalService.class);

	@Autowired
	private EchoService echoService;

//	@Scheduled(fixedDelayString = "${consumer.auto.test.interval:1000}")
//	public void doWork() throws InterruptedException {
//		String response = echoService.echo("auto-test");
//		LOG.info("consumer-demo auto test, response: [" + response + "]");
//	}
}