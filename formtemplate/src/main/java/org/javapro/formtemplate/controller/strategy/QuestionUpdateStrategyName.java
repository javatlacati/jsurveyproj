package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.QuestionType;

public enum QuestionUpdateStrategyName {
    UPDATE_DATE_QUESTION(QuestionType.DATE),
    UPDATE_OPEN_QUESTION(QuestionType.OPEN),
    UPDATE_MULTIPLE_OPTION_QUESTION(QuestionType.MULTIPLE_OPTION);
    private QuestionType questionType;

    QuestionUpdateStrategyName(QuestionType questionType) {
        this.questionType = questionType;
    }

    public QuestionType getType() {
        return questionType;
    }
}
