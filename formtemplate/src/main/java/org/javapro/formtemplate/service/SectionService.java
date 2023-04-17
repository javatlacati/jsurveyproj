package org.javapro.formtemplate.service;

import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Optional<Section> findById(Long aLong) {
        return sectionRepository.findById(aLong);
    }
}
