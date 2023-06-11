package org.javapro.formtemplate.service;

import org.javapro.formtemplate.model.Section;
import org.javapro.formtemplate.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
  private final SectionRepository sectionRepository;

  public SectionService(SectionRepository sectionRepository) {
    this.sectionRepository = sectionRepository;
  }

  public List<Section> findAll() {
    return sectionRepository.findAll();
  }

  public Optional<Section> findById(Long aLong) {
    return sectionRepository.findById(aLong);
  }
}
