package com.spring.mpvue.springbootmpvue.controller;

import com.spring.mpvue.springbootmpvue.util.ParamConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Test {

    @RequestMapping("select")
    public void test(){
        System.out.println("楼层："+ParamConfig.getPcgDegree("1","1"));
        System.out.println("户型："+ParamConfig.getPmDegree("1"));
        System.out.println("朝向："+ParamConfig.getChaoxiangDegree("东南"));
        System.out.println("面积："+ParamConfig.getAreaDegree("123"));
        System.out.println("装修："+ParamConfig.getDecorationDegree("毛坯"));
    }
}
