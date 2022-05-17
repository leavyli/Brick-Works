package com.example.springannation.config.typeFilter;

import com.example.springannation.Service.CustomExcludeService;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Author saino
 * LastModify 11:44
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
        var classMetadata = metadataReader.getClassMetadata();
        return classMetadata.getClassName().equals(CustomExcludeService.class.getName());
    }
}
