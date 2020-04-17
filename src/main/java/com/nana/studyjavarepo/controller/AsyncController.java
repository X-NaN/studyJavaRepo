package com.nana.studyjavarepo.controller;

import com.nana.studyjavarepo.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试异步
 *
 * @author xingnana
 * @create 2020-04-17
 */
@RestController
public class AsyncController {

    @Resource
    private AsyncService asyncService;

    @GetMapping("/async/test")
    public String testAsync() {
        try {
            asyncService.doTaskA();
            asyncService.doTaskB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
