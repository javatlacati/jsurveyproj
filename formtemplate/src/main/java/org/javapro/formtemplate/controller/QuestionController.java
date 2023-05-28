package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.controller.strategy.QuestionUpdateStrategyFactory;
import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.QuestionType;
import org.javapro.formtemplate.service.QuestionService;
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
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionUpdateStrategyFactory questionUpdateStrategyFactory;

    @GetMapping("/questions")
    public List<? extends Question> findAll() {
        return questionService.findAll();
    }

    @DeleteMapping("/question/{questionId}")
    public void deleteById(@PathVariable Long questionId) {
        questionService.deleteById(questionId);
    }

    @GetMapping("/question/{questionId}")
    public Optional<? extends Question> findById(@PathVariable Long questionId) {
        return questionService.findById(questionId);
    }

    @PostMapping("/question")
    @ResponseBody
    public Question createQuestion(@RequestBody Question question) {
        System.out.println("Saving question:" + question);
        return questionService.save(question);
    }

    @PostMapping("/multiple-option-question")
    @ResponseBody
    public MultipleOptionQuestion createQuestion(@RequestBody MultipleOptionQuestion question) {
        System.out.println("Saving question:" + question);
        return questionService.save(question);
    }

    @PatchMapping("/question/{questionId}")
    public Optional<? extends Question> updateQuestion(@PathVariable Long questionId, @RequestBody Question question) {
        System.out.println("updating question:" + question);
        Optional<? extends Question> possibleQuestion = questionService.findById(questionId);
        if (possibleQuestion.isPresent()) {
            Question existingQuestion = possibleQuestion.get();
            return Optional.ofNullable(updateQuestionFields(existingQuestion, question));
        } else {
            return Optional.of(createQuestion(question));
        }
    }

    @PatchMapping("/multiple-option-question/{questionId}")
    public Optional<MultipleOptionQuestion> updateQuestion(@PathVariable Long questionId, @RequestBody MultipleOptionQuestion question) {
        System.out.println("updating question:" + question);
        Optional<MultipleOptionQuestion> possibleQuestion = (Optional<MultipleOptionQuestion>) questionService.findById(questionId);
        if (possibleQuestion.isPresent()) {
            MultipleOptionQuestion existingQuestion = possibleQuestion.get();
            return Optional.ofNullable(updateQuestionFields(existingQuestion, question));
        } else {
            return Optional.of(createQuestion(question));
        }
    }

    private <T extends Question> T updateQuestionFields(T existingQuestion, T question) {
        System.out.println("updating question:" + existingQuestion + "\nwith question:" + question);
        QuestionType existingQuestionType = existingQuestion.getType();
        return (T) questionUpdateStrategyFactory.findByType(existingQuestionType).updateQuestionFields(existingQuestion, question);
    }
}
