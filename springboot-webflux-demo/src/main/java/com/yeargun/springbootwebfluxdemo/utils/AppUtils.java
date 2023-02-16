package com.yeargun.springbootwebfluxdemo.utils;

import com.yeargun.springbootwebfluxdemo.dto.QuestionDTO;
import com.yeargun.springbootwebfluxdemo.entity.Question;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static QuestionDTO entityToDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        return questionDTO;
    }

    public static Question dtoToEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO, question);
        return question;
    }

}
