import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
def class GroovyController {
    @RequestMapping("/groovy1")
    @ResponseBody
    public String hello() {
        return "hello2";
    }
}

beans {

    groovyController(GroovyController)


}


