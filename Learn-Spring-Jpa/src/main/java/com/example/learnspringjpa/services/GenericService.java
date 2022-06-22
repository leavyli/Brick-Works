package com.example.learnspringjpa.services;

import com.example.learnspringjpa.entities.AbstractBaseEntity;

import java.io.Serializable;

public interface GenericService<T extends AbstractBaseEntity, ID extends Serializable> extends AbstractBaseService<T, ID> {
}
