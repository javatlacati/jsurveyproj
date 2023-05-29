package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.formtemplate.service.SurveyTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyTemplateController {
    @Autowired
    private SurveyTemplateService surveyTemplateService;

    @Autowired
    private SectionController sectionController;

    @GetMapping("/templates")
    @ResponseBody
    public List<SurveyTemplate> findAll() {
        return surveyTemplateService.findAll();
    }

    @GetMapping("/template/{id}")
    @ResponseBody
    public Optional<SurveyTemplate> findById(@PathVariable Long id) {
        return surveyTemplateService.findById(id);
    }

    @DeleteMapping("/template/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        surveyTemplateService.deleteTemplateById(id);
    }

    @PostMapping("/template")
    @ResponseBody
    public SurveyTemplate createTemplate(@RequestBody SurveyTemplate surveyTemplate) {
        System.out.println("creating template:" + surveyTemplate);
        List<Section> sections = surveyTemplate.getSections();
        if (sections != null && !sections.isEmpty()) {
            for (int i = 0; i < sections.size(); i++) {
                Section section = sections.get(i);
                if (section.getSectionId() == null) {
                    System.out.println("Trying to save question:" + section);
                    Section savedQuestion = sectionController.createSection(section);
                    if (savedQuestion != null) {
                        sections.set(i, savedQuestion);
                    }
                }
            }
        }
        return surveyTemplateService.save(surveyTemplate);
    }

    /**
     * Updates a survey template by ID with the provided survey template object.
     * If the template exists, the sections are updated and the updated template is saved and returned.
     * If the template does not exist, an empty optional is returned.
     *
     * @param id             the ID of the survey template
     * @param surveyTemplate the updated survey template object
     * @return an optional containing the updated survey template if it exists, or an empty optional otherwise
     */
    @PatchMapping("/template/{id}")
    @ResponseBody
    public Optional<SurveyTemplate> update(@PathVariable Long id, @RequestBody SurveyTemplate surveyTemplate) {
        // Retrieve the existing survey template by its ID
        Optional<SurveyTemplate> possibleTemplate = surveyTemplateService.findById(id);
        if (possibleTemplate.isPresent()) {
            System.out.println("Template is present, trying to update with template:" + surveyTemplate);
            SurveyTemplate existingTemplate = possibleTemplate.get();
            updateSections(existingTemplate, surveyTemplate);
            // Save and return the updated survey template
            return Optional.of(surveyTemplateService.save(existingTemplate));
        } else {
            // Return empty optional if the survey template does not exist
            return Optional.empty();
        }
    }

    /**
     * Updates the sections of the survey template.
     * If a section ID exists, it updates the existing section.
     * If a section ID is null, it creates a new section and replaces the old one in the list.
     *
     * @param surveyTemplate the survey template to update the sections for
     */
    private void updateSections(SurveyTemplate existingTemplate, SurveyTemplate surveyTemplate) {
        List<Section> sections = surveyTemplate.getSections();
        if (sections != null && !sections.isEmpty()) {
            int sectionsSize = sections.size();
            for (int sectionIndex = 0; sectionIndex < sectionsSize; sectionIndex++) {
                Section section = sections.get(sectionIndex);
                Optional<Long> sectionId = Optional.ofNullable(section.getSectionId());
                if (sectionId.isPresent()) {
                    // If the section ID exists, update the existing section
                    int finalIndex = sectionIndex;
                    sectionController.update(sectionId.get(), section)
                            .ifPresent(section1 -> sections.set(finalIndex, section1));
                } else {
                    // If the section ID is null, create a new section and replace the old one in the list
                    sections.set(sectionIndex, sectionController.createSection(section));
                }
            }
            // Set the updated sections list in the survey template
            existingTemplate.setSections(sections);
        } else {
            existingTemplate.setSections(new ArrayList<>());
        }
    }
}
