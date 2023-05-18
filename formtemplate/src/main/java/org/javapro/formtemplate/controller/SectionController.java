package org.javapro.formtemplate.controller;

import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @DeleteMapping("/section/{sectionId}")
    public void deleteById(@PathVariable Long sectionId) {
        sectionRepository.deleteById(sectionId);
    }

    @PostMapping("/section")
    @ResponseBody
    public Section createSection(@RequestBody Section section) {
        return sectionRepository.save(section);
    }
}
