package org.javapro.formtemplate.repository;

import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleOptionQuestionRepository extends JpaRepository<MultipleOptionQuestion, Long> {
}
