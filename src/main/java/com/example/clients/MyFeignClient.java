package com.example.clients;

import com.example.clients.messages.Post;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "MyFeignClient",
        url = "https://jsonplaceholder.typicode.com/posts/1",
        configuration = MyFeignClientConfig.class)
public interface MyFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    Post getPost();

}
