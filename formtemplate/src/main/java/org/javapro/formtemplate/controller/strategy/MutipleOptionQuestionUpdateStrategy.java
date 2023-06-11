package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.repository.QuestionRepository;
import org.springframework.stereotype.Component;

@Component
public class MutipleOptionQuestionUpdateStrategy implements QuestionUpdateStrategy {
  private final QuestionRepository questionRepository;

  public MutipleOptionQuestionUpdateStrategy(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  @Override
  public QuestionUpdateStrategyName getStrategyName() {
    return QuestionUpdateStrategyName.UPDATE_MULTIPLE_OPTION_QUESTION;
  }

  @Override
  public Question updateQuestionFields(Question existingQuestion, Question question) {
    MultipleOptionQuestion multipleExistingQuestion = (MultipleOptionQuestion) (existingQuestion);
    MultipleOptionQuestion multipleNewQuestion = (MultipleOptionQuestion) (question);
    if (null != multipleNewQuestion.getAnswerOptions()) {
      multipleExistingQuestion.setAnswerOptions(multipleNewQuestion.getAnswerOptions());
    }
    multipleExistingQuestion.setStatement(multipleNewQuestion.getStatement());
    multipleExistingQuestion.setRequired(question.isRequired());
    multipleExistingQuestion.setType(question.getType());
    System.out.println("updated question:" + multipleExistingQuestion);
    return questionRepository.save(multipleExistingQuestion);
  }
}
