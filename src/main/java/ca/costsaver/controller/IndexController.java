package ca.costsaver.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
//@RequestMapping("/product")
public class IndexController {


    private static final Logger log = getLogger(IndexController.class);


    @GetMapping(value = "/")
    public String index() {

        return "redirect:/product/all";

    }

}
