package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.QuestionService;
import org.javapro.formtemplate.controller.strategy.QuestionUpdateStrategyFactory;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.QuestionType;
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
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @DeleteMapping("/question/{questionId}")
    public void deleteById(@PathVariable Long questionId) {
        questionService.deleteById(questionId);
    }

    @GetMapping("/question/{questionId}")
    public Optional<Question> findById(@PathVariable Long questionId) {
        return questionService.findById(questionId);
    }

    @PostMapping("/question")
    @ResponseBody
    public Question createQuestion(@RequestBody Question question) {
        System.out.println("Saving question:" + question);
        return questionService.save(question);
    }

    @PatchMapping("/question/{questionId}")
    public Optional<Question> updateQuestion(@PathVariable Long questionId, @RequestBody Question question) {
        Optional<Question> possibleQuestion = questionService.findById(questionId);
        if (possibleQuestion.isPresent()) {
            Question existingQuestion = possibleQuestion.get();
            return Optional.ofNullable(updateQuestionFields(existingQuestion, question));
        } else {
            return Optional.of(createQuestion(question));
        }
    }

    private Question updateQuestionFields(Question existingQuestion, Question question) {
        System.out.println("updating question:" + existingQuestion + "\nwith question:" + question);
        QuestionType existingQuestionType = existingQuestion.getType();
        return questionUpdateStrategyFactory.findByType(existingQuestionType).updateQuestionFields(existingQuestion, question);
    }
}
