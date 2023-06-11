package org.javapro.formtemplate.repository;

import org.javapro.formtemplate.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {}
