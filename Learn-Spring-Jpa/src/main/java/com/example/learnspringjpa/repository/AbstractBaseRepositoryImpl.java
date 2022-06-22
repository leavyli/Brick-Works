package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.AbstractBaseEntity;
import com.example.learnspringjpa.services.AbstractBaseService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 13:32
 */
@Service
public class AbstractBaseRepositoryImpl<T extends AbstractBaseEntity, ID extends Serializable> implements AbstractBaseService<T, ID> {
    private final AbstractBaseRepository<T, ID> abstractBaseRepository;

    public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public T save(T entity) {
        return abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return abstractBaseRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        return abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            return abstractBaseRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }
}
