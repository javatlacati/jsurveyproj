package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.QuestionService;
import org.javapro.formtemplate.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

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
}
