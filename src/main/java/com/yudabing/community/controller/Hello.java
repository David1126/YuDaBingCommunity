package com.yudabing.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-11 19:40
 **/

@Controller
public class Hello {

    @GetMapping("/hello")
    public String hello (@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

}
