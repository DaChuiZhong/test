package com.sishuok.spring.controller;

import MybatisReGenXin.SqlSessionCache;
import com.sishuok.spring.Jdbc.CustomizedPropertyConfigurer;
import com.sishuok.spring.dynamic.*;
import com.sishuok.spring.entity.SysDictionaryEntity;
import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-13
 * <p>Version: 1.0
 */

@Controller
public class UserController {

    @Autowired
    private ApplicationContext ctx;

    @Value("${jdbc.username}")
    public String username;

    @Autowired
    private DynamicDeployBeans dynamicDeployBeans;

    @Autowired
    private DynamicDeployBeans2 dynamicDeployBeans2;

    @Autowired
    private TestDao testDao;

    @Autowired
    private SqlSessionCache sqlSessionCache;

    @RequestMapping("refshMapper")
    @ResponseBody
    public String refshMapper(){
        sqlSessionCache.refreshMapper();
        return "成功";
    }

    @RequestMapping("/load")
    @ResponseBody
    public String read(){
        File[] file =new File("G:\\workspace\\groovy\\spring4-showcase-master\\spring-dynamic\\src\\main\\resources\\groovy").listFiles();
        for(File file1:file){
            if(file1.isFile()){
                if(file1.getName().endsWith(".groovy")){
                    dynamicDeployBeans2.registerGroovyController("classpath:groovy\\"+file1.getName());
                }
            }
        }
//        dynamicDeployBeans2.registerBean("testDao1", TestDao1.class);
        List<SysDictionaryEntity>  a=testDao.queryList();
//        System.out.println(a);
        System.out.println(username);
        System.out.println(CustomizedPropertyConfigurer.getCtxProp("jdbc.url"));
        return "success";
    }

    @RequestMapping("/hello")
    public String hello() {
        DynamicService2 dynamicService2 = null;
        try {
            dynamicService2 = ctx.getBean(DynamicService2.class);
        } catch (Exception e) {
        }

        System.out.println(dynamicService2);
        if (dynamicService2 != null) {
            System.out.println("dynamicService2 : " + dynamicService2.getMessage());
        }
        return "success";
    }

    @RequestMapping("/registerBean")
    public String registerBean() {
        dynamicDeployBeans.registerBean(DynamicService1.class);
        dynamicDeployBeans.registerBean(DynamicService2.class);
        return "success";
    }

    @RequestMapping("/registerController")
    public String registerController() {
        dynamicDeployBeans.registerController(DynamicController.class);
        return "success";
    }

    @RequestMapping("/registerGroovyController")
    public String registerGroovyController() throws IOException {
//        dynamicDeployBeans.registerGroovyController("classpath:com/sishuok/spring/dynamic/GroovyController.groovy");
        dynamicDeployBeans2.registerGroovyController("classpath:com/sishuok/spring/dynamic/GroovyController.groovy");
        return "success";
    }

}
