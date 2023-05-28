package org.javapro.formtemplate.service;

import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.repository.MultipleOptionQuestionRepository;
import org.javapro.formtemplate.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    MultipleOptionQuestionRepository multipleOptionQuestionRepository;

    public void flush() {
        questionRepository.flush();
    }

    public <S extends Question> S saveAndFlush(S entity) {
        return questionRepository.saveAndFlush(entity);
    }

    public <S extends Question> List<S> saveAllAndFlush(Iterable<S> entities) {
        return questionRepository.saveAllAndFlush(entities);
    }

    @Deprecated
    public void deleteInBatch(Iterable<Question> entities) {
        questionRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch(Iterable<Question> entities) {
        questionRepository.deleteAllInBatch(entities);
    }

    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        questionRepository.deleteAllByIdInBatch(longs);
    }

    public void deleteAllInBatch() {
        questionRepository.deleteAllInBatch();
    }

    @Deprecated
    public Question getOne(Long aLong) {
        return questionRepository.getOne(aLong);
    }

    @Deprecated
    public Question getById(Long aLong) {
        return questionRepository.getById(aLong);
    }

    public Question getReferenceById(Long aLong) {
        return questionRepository.getReferenceById(aLong);
    }

    public <S extends Question> List<S> findAll(Example<S> example) {
        return questionRepository.findAll(example);
    }

    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
        return questionRepository.findAll(example, sort);
    }

    public <S extends Question> List<S> saveAll(Iterable<S> entities) {
        return questionRepository.saveAll(entities);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> findAllById(Iterable<Long> longs) {
        return questionRepository.findAllById(longs);
    }

    public <T extends Question> T save(T entity) {
        if (entity instanceof MultipleOptionQuestion) {
            MultipleOptionQuestion multipleOptionQuestion = (MultipleOptionQuestion) entity;
            System.out.println("saving multiple option question:" + multipleOptionQuestion);
            return (T) multipleOptionQuestionRepository.save(multipleOptionQuestion);
        } else {
            System.out.println("saving regular question");
            return questionRepository.save(entity);
        }
    }

    public Optional<? extends Question> findById(Long aLong) {
        return questionRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return questionRepository.existsById(aLong);
    }

    public long count() {
        return questionRepository.count();
    }

    public void deleteById(Long aLong) {
        questionRepository.deleteById(aLong);
    }

    public void delete(Question entity) {
        questionRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        questionRepository.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends Question> entities) {
        questionRepository.deleteAll(entities);
    }

    public void deleteAll() {
        questionRepository.deleteAll();
    }

    public List<Question> findAll(Sort sort) {
        return questionRepository.findAll(sort);
    }

    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    public <S extends Question> Optional<S> findOne(Example<S> example) {
        return questionRepository.findOne(example);
    }

    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
        return questionRepository.findAll(example, pageable);
    }

    public <S extends Question> long count(Example<S> example) {
        return questionRepository.count(example);
    }

    public <S extends Question> boolean exists(Example<S> example) {
        return questionRepository.exists(example);
    }

    public <S extends Question, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return questionRepository.findBy(example, queryFunction);
    }
}
