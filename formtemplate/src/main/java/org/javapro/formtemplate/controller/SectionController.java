package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.repository.SectionRepository;
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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SectionController {
    private final SectionRepository sectionRepository;

    private final QuestionController questionController;

    public SectionController(@Autowired SectionRepository sectionRepository, @Autowired QuestionController questionController) {
        this.sectionRepository = sectionRepository;
        this.questionController = questionController;
    }

    @GetMapping("/sections")
    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    @GetMapping("/section/{sectionId}")
    public Optional<Section> findById(@PathVariable Long sectionId) {
        return sectionRepository.findById(sectionId);
    }

    @DeleteMapping("/section/{sectionId}")
    public void deleteById(@PathVariable Long sectionId) {
        sectionRepository.deleteById(sectionId);
    }

    @PostMapping("/section")
    @ResponseBody
    public Section createSection(@RequestBody Section section) {
        System.out.println("creating section:" + section);
        List<Question> questions = section.getQuestions();
        if (questions != null && !questions.isEmpty()) {
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                if (question.getQuestionId() == null) {
                    System.out.println("Trying to save question:" + question);
                    Question savedQuestion = questionController.createQuestion(question);
                    if (savedQuestion != null) {
                        questions.set(i, savedQuestion);
                    }
                }
            }
        }
        return sectionRepository.save(section);
    }

    @PatchMapping("/section/{sectionId}")
    public Optional<Section> update(@PathVariable Long sectionId, Section section) {
        Optional<Section> possibleSection = sectionRepository.findById(sectionId);
        if (possibleSection.isPresent()) {
            Section existingSection = possibleSection.get();
            updateQuestions(existingSection, section);
            return Optional.of(sectionRepository.save(existingSection));
        } else {
            return Optional.empty();
        }
    }

    private void updateQuestions(Section existingSection, Section section) {
        System.out.println("updating section:" + existingSection + "\nwith section:" + section);
        if (section.getName() != null) {
            existingSection.setName(section.getName());
        }
        List<Question> questions = section.getQuestions();
        if (questions != null && !questions.isEmpty()) {
            int questionSize = questions.size();
            for (int questionIndex = 0; questionIndex < questionSize; questionIndex++) {
                Question question = questions.get(questionIndex);
                Optional<Long> questionId = Optional.ofNullable(question.getQuestionId());
                if (questionId.isPresent()) {
                    int finalQuestionIndex = questionIndex;
                    questionController.updateQuestion(questionId.get(), question)
                            .ifPresent(question1 -> questions.set(finalQuestionIndex, question1));
                } else {
                    System.out.println("No questionID found proceding to save " + question);
                    questions.set(questionIndex, questionController.createQuestion(question));
                }
            }
        }
        existingSection.setQuestions(questions);
    }
}
