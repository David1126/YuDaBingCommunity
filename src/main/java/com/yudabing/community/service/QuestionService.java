package com.yudabing.community.service;

import com.github.pagehelper.PageHelper;
import com.yudabing.community.dto.PaginationDTO;
import com.yudabing.community.dto.QuestionDTO;
import com.yudabing.community.mapper.QuestionMapper;
import com.yudabing.community.mapper.UserMapper;
import com.yudabing.community.model.Question;
import com.yudabing.community.model.QuestionExample;
import com.yudabing.community.model.QuestionExample.Criteria;
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
        QuestionExample example = new QuestionExample();
        List<Question> questions = questionMapper.selectByExample(example);
        //System.out.println(questions);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        int count = (int) questionMapper.countByExample(example);
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
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        //System.out.println(questionDTOList);
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO getListByUser(User user, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        QuestionExample example = new QuestionExample();
        Criteria criteria = example.createCriteria();
        criteria.andCreatorEqualTo(user.getId());
        List<Question> questions = questionMapper.selectByExample(example);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        int count = (int) questionMapper.countByExample(example);
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

    public QuestionDTO getQuestionById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            // 创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            // 更新
            question.setGmtModified(question.getGmtCreate());
            questionMapper.updateByPrimaryKey(question);
        }
    }
}
