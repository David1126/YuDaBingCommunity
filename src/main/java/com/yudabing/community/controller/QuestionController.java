package com.yudabing.community.controller;

import com.yudabing.community.dto.QuestionDTO;
import com.yudabing.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-14 14:30
 **/
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question (@PathVariable(name = "id") Integer id,
                            Model model) {

        QuestionDTO questionDTO = questionService.getQuestionById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";

    }
}
