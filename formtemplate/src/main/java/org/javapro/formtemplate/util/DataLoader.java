package org.javapro.formtemplate.util;

import org.javapro.formtemplate.model.DateQuestion;
import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.OpenQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.formtemplate.repository.QuestionRepository;
import org.javapro.formtemplate.repository.SectionRepository;
import org.javapro.formtemplate.repository.SurveyTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SurveyTemplateRepository surveyTemplateRepository;

    @Override
    @Transactional
    public void run(String... args) {

        OpenQuestion openQuestion = questionRepository.save(OpenQuestion.builder().statement("Escribe tu nombre").required(false).build());
        DateQuestion dateQuestion = questionRepository.save(DateQuestion.builder().statement("Escribe la fecha de hoy:").theDate(new Date()).required(true).build());
        MultipleOptionQuestion multipleOptionQuestion = questionRepository.save(MultipleOptionQuestion.builder().statement("Especifica tu sexo:").answerOptions(new String[]{"M","F", "prefiero no decir"}).required(true).build());
        final List<Question> questions = Arrays.asList(openQuestion, dateQuestion, multipleOptionQuestion);
        Section generalInfoSection = sectionRepository.save(Section.builder().name("datos generales").questions(questions).build());
        final List<Section> sections = Collections.singletonList(generalInfoSection);
        SurveyTemplate surveyTemplate = surveyTemplateRepository.save(SurveyTemplate.builder().sections(sections).build());
        System.out.println("loaded template:"+surveyTemplate);
    }

}
