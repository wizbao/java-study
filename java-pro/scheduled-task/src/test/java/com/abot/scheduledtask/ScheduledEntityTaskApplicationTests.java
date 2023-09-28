package com.abot.scheduledtask;

import com.abot.scheduledtask.service.ScheduledService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ScheduledEntityTaskApplicationTests {

	@Resource
	private ScheduledService scheduledService;

	@Test
	void test1(){
		scheduledService.startMyTask(1);
	}

}
