package org.wangquanchn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wangquanchn.service.RedissonService;

@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private RedissonService redissonService;

    @GetMapping("setBucket")
    public String setBucket() {
        return redissonService.setBucket();
    }

    @GetMapping("getBucket")
    public String getBucket() {
        return redissonService.getBucket();
    }

}
