package com.sishuok.spring.dynamic;

import groovy.lang.GroovyClassLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-3
 * <p>Version: 1.0
 */
@Controller
public class DynamicController {

    @RequestMapping("/controller")
    @ResponseBody
    public String controller() throws Exception{
        System.out.println(123);
//        File file =new File("classpath:groovy\\GroovyController.groovy");
//        Class clazz= new GroovyClassLoader().parseClass(file);
//        DynamicDeployBeans dynamicDeployBeans=new DynamicDeployBeans();
//        dynamicDeployBeans.registerController(clazz);
        return "success";
    }


}
