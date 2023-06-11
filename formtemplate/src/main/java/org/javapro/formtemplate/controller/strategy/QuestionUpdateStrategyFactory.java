package org.javapro.formtemplate.controller.strategy;

import org.javapro.formtemplate.model.QuestionType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class QuestionUpdateStrategyFactory {
  private Map<QuestionType, QuestionUpdateStrategy> strategies;

  public QuestionUpdateStrategyFactory(Set<QuestionUpdateStrategy> updateStrategySet) {
    strategies = new HashMap<>();
    updateStrategySet.forEach(
        questionUpdateStrategy ->
            strategies.put(
                questionUpdateStrategy.getStrategyName().getType(), questionUpdateStrategy));
  }

  public QuestionUpdateStrategy findByType(QuestionType type) {
    return strategies.get(type);
  }
}
