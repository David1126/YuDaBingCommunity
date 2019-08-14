package com.yudabing.community.controller;

import com.yudabing.community.dto.PaginationDTO;
import com.yudabing.community.mapper.UserMapper;
import com.yudabing.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        Model model) {

        PaginationDTO pagination = questionService.getList(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }

}
