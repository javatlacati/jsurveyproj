package org.javapro.formtemplate.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.formtemplate.service.SurveyTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SurveyTemplateController {
    @Autowired
    private SurveyTemplateService surveyTemplateService;

    @GetMapping("/templates")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<SurveyTemplate> findAll() {
        return surveyTemplateService.findAll();
    }

    @GetMapping("/template/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Optional<SurveyTemplate> findById(@PathVariable Long id) {
        return surveyTemplateService.findById(id);
    }

    @DeleteMapping("/template/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        surveyTemplateService.deleteTemplateById(id);
    }

    @PostMapping("/template")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public SurveyTemplate createTemplate(@RequestBody SurveyTemplate surveyTemplate) {
        return surveyTemplateService.save(surveyTemplate);
    }
}
