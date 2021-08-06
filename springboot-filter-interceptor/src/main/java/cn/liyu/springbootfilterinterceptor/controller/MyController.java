package cn.liyu.springbootfilterinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyu
 * @date 2019/12/25 15:11
 * @description
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/hello")
    public String getHello(@RequestParam String name) throws InterruptedException {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}
