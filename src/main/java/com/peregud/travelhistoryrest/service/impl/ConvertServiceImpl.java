package com.peregud.travelhistoryrest.service.impl;

import com.peregud.travelhistoryrest.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    private ConversionService conversionService;

    @Override
    public <T, E> E convertEntity(T source, Class<E> targetClass) {
        return conversionService.convert(source, targetClass);
    }
}
