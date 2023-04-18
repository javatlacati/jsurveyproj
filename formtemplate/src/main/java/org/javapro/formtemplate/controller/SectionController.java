package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SectionController {
    private final SectionRepository sectionRepository;

    public SectionController(@Autowired SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @GetMapping("/sections")
    public List<Section> getSections() {
        return sectionRepository.findAll();
    }
    @GetMapping("/section/{sectionId}")
    public Optional<Section> findById(@PathVariable Long sectionId) {
        return sectionRepository.findById(sectionId);
    }
}