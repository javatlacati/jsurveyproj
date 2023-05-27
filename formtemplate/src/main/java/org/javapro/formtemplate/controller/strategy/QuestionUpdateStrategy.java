package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.Question;

public interface QuestionUpdateStrategy {
    QuestionUpdateStrategyName getStrategyName();

    Question updateQuestionFields(Question existingQuestion, Question question);
}
