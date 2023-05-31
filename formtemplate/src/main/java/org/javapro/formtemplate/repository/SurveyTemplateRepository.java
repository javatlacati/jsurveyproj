package org.javapro.formtemplate.repository;

import org.javapro.formtemplate.model.SurveyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyTemplateRepository  extends JpaRepository<SurveyTemplate, Long> {
    Optional<SurveyTemplate> findByUuid(String uuid);
}
