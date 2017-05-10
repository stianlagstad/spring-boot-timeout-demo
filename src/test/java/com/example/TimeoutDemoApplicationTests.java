package com.example;

import com.example.clients.MyFeignClient;
import com.netflix.config.ConfigurationManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeoutDemoApplicationTests {

    @Autowired
    private MyFeignClient myFeignClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void requestShouldTimeout() {

	    // Attempt to set the timeout to 1 millisecond so that the request further down fails
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.MyFeignClient#getPost().execution.isolation.thread.timeoutInMilliseconds",
                1);

        boolean exceptionThrown = false;
        try {
            // I want this to timeout after 1 millisecond
            myFeignClient.getPost();
        } catch (Exception e) {
            exceptionThrown = true;
        }
        assertTrue("Expected to see an exception thrown.", exceptionThrown);
	}

}
