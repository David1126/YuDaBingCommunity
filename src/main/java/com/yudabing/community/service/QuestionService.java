package com.yudabing.community.service;

import com.github.pagehelper.PageHelper;
import com.yudabing.community.dto.PaginationDTO;
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

    public PaginationDTO getList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Question> questions = questionMapper.findAll();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        int count = questionMapper.getCount();
        Integer totalPage;
        if (count % size == 0) {
            totalPage = count / size;
        } else {
            totalPage = count / size + 1;
        }
        if (page < 1) {
            page = 1;
        }

        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO getListByUser(User user, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Question> questions = questionMapper.findByUser(user);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        int count = questionMapper.getCountByUser(user);
        Integer totalPage;
        if (count % size == 0) {
            totalPage = count / size;
        } else {
            totalPage = count / size + 1;
        }
        if (page < 1) {
            page = 1;
        }

        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
