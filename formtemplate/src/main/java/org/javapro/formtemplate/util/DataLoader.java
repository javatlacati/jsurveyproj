package org.javapro.formtemplate.util;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.QuestionType;
import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.formtemplate.repository.QuestionRepository;
import org.javapro.formtemplate.repository.SectionRepository;
import org.javapro.formtemplate.repository.SurveyTemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/** This class initializes the data for demo purposes */
@Component
public class DataLoader implements CommandLineRunner {

  private final QuestionRepository questionRepository;

  private final SectionRepository sectionRepository;

  private final SurveyTemplateRepository surveyTemplateRepository;

  /**
   * Creates a new data loader object
   *
   * @param questionRepository facade to questions in persistence layer
   * @param sectionRepository facade to sections in persistence layer
   * @param surveyTemplateRepository facade to survey templates in persistence layer
   */
  public DataLoader(
      QuestionRepository questionRepository,
      SectionRepository sectionRepository,
      SurveyTemplateRepository surveyTemplateRepository) {
    this.questionRepository = questionRepository;
    this.sectionRepository = sectionRepository;
    this.surveyTemplateRepository = surveyTemplateRepository;
  }

  @Override
  @Transactional
  public void run(String... args) {

    Question openQuestion =
        questionRepository.save(
            Question.builder()
                .statement("Escribe tu nombre")
                .type(QuestionType.OPEN)
                .required(false)
                .build());
    Question dateQuestion =
        questionRepository.save(
            Question.builder()
                .statement("Escribe la fecha de hoy:")
                .type(QuestionType.DATE)
                .required(true)
                .build());
    MultipleOptionQuestion multipleOptionQuestion =
        questionRepository.save(
            MultipleOptionQuestion.builder()
                .type(QuestionType.MULTIPLE_OPTION)
                .statement("Especifica tu sexo:")
                .answerOptions(new String[] {"M", "F", "prefiero no decir"})
                .required(true)
                .build());
    List<Question> generalQuestions =
        Arrays.asList(openQuestion, dateQuestion, multipleOptionQuestion);
    Section generalInfoSection =
        sectionRepository.save(
            Section.builder().name("datos generales").questions(generalQuestions).build());

    MultipleOptionQuestion afiliationOptionQuestion =
        questionRepository.save(
            MultipleOptionQuestion.builder()
                .statement("Especifica tu afiliacion politica:")
                .type(QuestionType.MULTIPLE_OPTION)
                .answerOptions(new String[] {"PRI", "PAN", "PRD", "MORENA", "prefiero no decir"})
                .required(false)
                .build());
    List<Question> afiliationQuestions = List.of(afiliationOptionQuestion);
    Section afiliationInfoSection =
        sectionRepository.save(
            Section.builder().name("Afiliacion").questions(afiliationQuestions).build());
    List<Section> sections = Arrays.asList(generalInfoSection, afiliationInfoSection);
    SurveyTemplate surveyTemplate1 =
        surveyTemplateRepository.save(
            SurveyTemplate.builder().uuid(UUID.randomUUID().toString()).sections(sections).build());
    System.out.println("loaded template:" + surveyTemplate1);
  }
}
