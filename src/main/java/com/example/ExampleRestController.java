package com.example;

import com.example.clients.MyFeignClient;
import com.example.clients.messages.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

    @Autowired
    private MyFeignClient myFeignClient;

    @RequestMapping(value = "/getPost", method = RequestMethod.GET)
    public Post getPost() {
        return myFeignClient.getPost();
    }

}
