package com.github.vaibhavsinha.eighttracks.converter;

import com.github.vaibhavsinha.eighttracks.db.entity.Tag;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 * Created by vaibhav on 15/07/17.
 */
public class TagsConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
        if(source == null) {
            return null;
        }
        if(source instanceof String) {
            return new Tag(source.toString());
        }
        if(source instanceof Tag) {
            return ((Tag)source).getName();
        }
        throw new MappingException("Converter TagsConverter " + "used incorrectly. Arguments passed in were:" + destination + " and " + source);
    }
}
