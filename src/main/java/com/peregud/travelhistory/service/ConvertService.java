package com.peregud.travelhistory.service;

import org.springframework.stereotype.Service;

@Service
public interface ConvertService {

    <T, E> E convertEntity(T source, Class<E> targetClass);
}
