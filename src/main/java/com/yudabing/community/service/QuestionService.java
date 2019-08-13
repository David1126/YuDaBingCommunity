package com.yudabing.community.service;

import com.yudabing.community.dto.QuestionDTO;
import com.yudabing.community.mapper.QuestionMapper;
import com.yudabing.community.mapper.UserMapper;
import com.yudabing.community.model.Question;
import com.yudabing.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuBing
 * @package com.yudabing.community.service
 * @create 2019-08-13 18:52
 **/
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> getList() {
        List<Question> questions = questionMapper.findAll();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
