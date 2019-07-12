package groovy

import com.sishuok.spring.Jdbc.CustomizedPropertyConfigurer
import dao.Test1Dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import groovy.sql.Sql

/**
 *
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-18
 * <p>Version: 1.0
 */
@RestController
class GroovyController1 {

    @Autowired
    private Test1Dao test1Dao;

//    @Autowired
//    private TestDao1 testDao1;

//    @Autowired
//    private TestDao1 testDao1;

    @RequestMapping("/groovy1")
    @ResponseBody
    public String hello() {
//        println(userController.hello())
        return test1Dao.queryList()
    }



    String url =CustomizedPropertyConfigurer.getCtxProp("jdbc.url")
    String username =CustomizedPropertyConfigurer.getCtxProp("jdbc.username")
    String passowrd =CustomizedPropertyConfigurer.getCtxProp("jdbc.password")
    String driver ='com.mysql.jdbc.Driver'

    void select(){
        def sql = Sql.newInstance(url, username,
                passowrd, driver)
        sql.eachRow('select * from project_user') {
            tp ->
                println([tp.user_name,tp.person_id,tp.status])
        }
        sql.close()
    }

}
