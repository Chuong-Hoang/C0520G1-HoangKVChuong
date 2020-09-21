package di;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    HelloWorld helloWorld1;
    @Autowired
    HelloWorld helloWorld2;

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg1", helloWorld1.print());
        model.addAttribute("msg2", helloWorld2.print());

        System.out.println( helloWorld1.print());
        System.out.println( helloWorld2.print());
        return "/index";
    }
}
