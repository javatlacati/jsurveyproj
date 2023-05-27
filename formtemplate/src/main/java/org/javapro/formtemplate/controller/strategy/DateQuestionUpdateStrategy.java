package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateQuestionUpdateStrategy implements QuestionUpdateStrategy {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionUpdateStrategyName getStrategyName() {
        return QuestionUpdateStrategyName.UPDATE_DATE_QUESTION;
    }

    @Override
    public Question updateQuestionFields(Question existingQuestion, Question question) {
        existingQuestion.setStatement(question.getStatement());
        existingQuestion.setRequired(question.isRequired());
        existingQuestion.setType(question.getType());
        System.out.println("updated question:" + existingQuestion);
        return questionRepository.save(existingQuestion);
    }
}
