package com.yudabing.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-11 19:40
 **/

@Controller
public class IndexController {

    @GetMapping("/")
    public String index () {
        return "index";
    }

}
