package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.Question;

/**
 * Contract for defining question update strategies. The idea is to have a strategy per question
 * type
 */
public interface QuestionUpdateStrategy {
  /**
   * Specifies the name for this strategy
   *
   * @return the name for this strategy
   */
  QuestionUpdateStrategyName getStrategyName();

  /**
   * Defines the actual steps to update each and every question fields.
   *
   * @param existingQuestion question as retrieves from database
   * @param question target changes
   * @return updates made to the existing question using question
   */
  Question updateQuestionFields(Question existingQuestion, Question question);
}
