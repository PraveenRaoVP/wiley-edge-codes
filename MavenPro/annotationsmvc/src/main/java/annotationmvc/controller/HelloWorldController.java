package annotationmvc.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import annotationmvc.model.HelloWorld;

@Controller
//@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(value = "/helloworld")
    public String handler(Model model) {

        HelloWorld hw = new HelloWorld();

        hw.setMessage("Hello I am here");
        hw.setDateTime(LocalDateTime.now().toString());

        model.addAttribute("hw", hw);
        return "helloworld";
    }
}