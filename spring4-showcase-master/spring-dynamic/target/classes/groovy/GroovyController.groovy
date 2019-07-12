package groovy

import com.sishuok.spring.Jdbc.CustomizedPropertyConfigurer
import com.sishuok.spring.controller.UserController
import dao.TestDao

//import groovy.TestDao1
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
class GroovyController {
    @Autowired
    private UserController userController;

    @Autowired
    private TestDao testDao;

//    @Autowired
//    private TestDao1 testDao1;

//    @Autowired
//    private TestDao1 testDao1;

    @RequestMapping("/groovy")
    @ResponseBody
    public String hello() {
//        println(userController.hello())
        return testDao.queryList()
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
