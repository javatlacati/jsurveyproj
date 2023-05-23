package org.javapro.jsurveyforms.repository;

import org.javapro.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
