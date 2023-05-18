package org.javapro.formtemplate.service;

import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.formtemplate.repository.SurveyTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyTemplateService {
    @Autowired
    private SurveyTemplateRepository surveyTemplateRepository;

    public List<SurveyTemplate> findAll() {
        return surveyTemplateRepository.findAll();
    }

    public Optional<SurveyTemplate> findById(Long aLong) {
        return surveyTemplateRepository.findById(aLong);
    }

    public void deleteTemplateById(Long aLong) {
        surveyTemplateRepository.deleteById(aLong);
    }

    public <S extends SurveyTemplate> S save(S entity) {
        return surveyTemplateRepository.save(entity);
    }
}
