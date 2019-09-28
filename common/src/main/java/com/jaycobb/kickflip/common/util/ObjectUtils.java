package com.jaycobb.kickflip.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.jaycobb.kickflip.common.dto.BaseDto;
import com.jaycobb.kickflip.common.dto.EntityField;
import com.jaycobb.kickflip.common.model.AbstractEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Collections.emptyList;

public class ObjectUtils {

    private static final Logger log = LoggerFactory.getLogger(ObjectUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public static <T> T jsonToObject(final String json, final Class<T> type) {

        try {
            if (String.class.isAssignableFrom(type)) { return (T) json; }
            return mapper.readValue(json, type);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> jsonToObjectList(final String json, final Class<T> type) {

        try {
            final TypeFactory t = TypeFactory.defaultInstance();
            return mapper.readValue(json, t.constructCollectionType(List.class, type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static <T> String objectToJson(final T object) {

        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Copy bean properties.
     * @param src source object
     * @param dest target object
     * @param <T>
     */
    public static <T> void copyProperties(final T src, final T dest) {

        BeanUtils.copyProperties(src, dest);
    }

    /**
     * Copy bean properties.
     * @param src source object
     * @param dest target object
     * @param propertiesToIgnore ignored properties
     * @param <T>
     */
    public static <T> void copyPropertiesWithIgnore(final T src, final T dest, final List<String> propertiesToIgnore) {

        if (src != null && dest != null) { BeanUtils.copyProperties(src, dest, propertiesToIgnore.toArray(new String[0])); }
    }

    /**
     * Copy specified bean properties.
     * @param src source object
     * @param dest target object
     * @param properties names of properties to be copied
     * @param <T>
     */
    public static <T> void copyProperties(final T src, final T dest, final List<String> properties) {

        final BeanWrapper srcWrapper = PropertyAccessorFactory.forBeanPropertyAccess(src);
        final BeanWrapper destWrapper = PropertyAccessorFactory.forBeanPropertyAccess(dest);
        properties.forEach(property -> destWrapper.setPropertyValue(property, srcWrapper.getPropertyValue(property)));
    }

    /**
     * Return true of class contains the given <code>property</code>, else false.
     */
    public static Boolean containsProperty(final Class c, final String property) {

        return Arrays.stream(c.getDeclaredFields()).anyMatch(field -> field.getName().equals(property));
    }

    /**
     * Find if class has dependency instance based on the getter. If none, instantiate the dependency and set on the class.
     * <p>
     * Shorthand for below example. <br /><br />
     * <code>
     * Person person = relocatee.getPerson(); <br />
     * if (person == null) { person = new Person(); }
     * relocatee.setPerson(person);
     * </code>
     * </p>
     * @param getter the getter method to get the dependency
     * @param setter the setter method to set the dependency
     * @param type the dependency class type
     * @param <T>
     * @return the dependency instance
     */
    public static <T> T initEntity(final Supplier<T> getter, final Consumer<T> setter, final Class<T> type) {

        try {
            final T t = getter.get() != null ? getter.get() : type.getDeclaredConstructor().newInstance();
            setter.accept(t);
            return t;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert Object/LinkedHashMap to specified type.
     * @param o
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T convert(final Object o, final Class<T> c) {

        return mapper.convertValue(o, c);
    }

    public static <T> void setIfNotNull(final Supplier<T> getter, final Consumer<T> setter) {

        final T t = getter.get();
        if (t != null) {
            setter.accept(t);
        }
    }

    public static <T> void setIfNotEmpty(final String t, final Consumer<String> setter) {

        if (t != null && t.trim().length() > 0) {
            setter.accept(t);
        }
    }

    @SuppressWarnings("unused")
    public static <T> void setValueIfNotNull(final T t, final Consumer<T> setter) {

        if (t != null) {
            setter.accept(t);
        }
    }

    @SuppressWarnings("unused")
    public static <T> void setValueIfNotEmpty(final String t, final Consumer<String> setter) {

        if (t != null && t.trim().length() > 0) {
            setter.accept(t);
        }
    }

    public static <T> void setIfPresent(final Optional<T> o, final Consumer<T> setter) {

        if (o != null && o.isPresent()) {
            setter.accept(o.get());
        }
    }

    public static <T> void setDefaultIfNull(final Supplier<T> getter, final T defaultValue, final Consumer<T> setter) {

        if (getter.get() == null && defaultValue != null) {
            setter.accept(defaultValue);
        }
    }

    public static <T> void setDefaultIfEmpty(final Supplier<String> getter, final T defaultValue, final Consumer<T> setter) {

        if ((getter.get() == null || StringUtils.isEmpty(getter.get())) && defaultValue != null) {
            setter.accept(defaultValue);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getPropertyValue(final Object object, final String propertyName) {

        try {
            final BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(object);
            return (T) wrapper.getPropertyValue(propertyName);
        } catch (NullValueInNestedPathException ignored) { return null; }
    }

    public static <T> T getPropertyValueOrDefault(final Object object, final String propertyName, final T defaultValue) {

        try {
            final T value = getPropertyValue(object, propertyName);
            return value != null ? value : defaultValue;
        } catch (NotReadablePropertyException ignored) {
            return defaultValue;
        }
    }

    public static void setPropertyValue(final Object object, final String propertyName, final Object value) {

        final BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(object);
        try {
            wrapper.setPropertyValue(propertyName, value);
        } catch (NullValueInNestedPathException ignored) { /* ignore */ }
    }

    public static Boolean valuesAreSame(final Object a, final Object b) {
        if (a == null && b == null) { return true; }
        else if (a == null || b == null) { return false; }
        return a.equals(b);
    }

    public static <T extends AbstractEntity> void populateEntity(final BaseDto dto, final T model) {

        populateEntity(dto, model, emptyList());
    }

    public static <T extends AbstractEntity> void populateEntity(final BaseDto dto, final T model, final List<String> inclusiveFields) {

        getFields(dto.getClass()).stream()
                .filter(field ->
                        (!field.isAnnotationPresent(EntityField.class) || !field.getAnnotation(EntityField.class).readOnly()) &&
                        (CollectionUtils.isEmpty(inclusiveFields) || inclusiveFields.contains(field.getName())))
                .forEach(field -> {

                    final EntityField annotation = field.isAnnotationPresent(EntityField.class) ? field.getAnnotation(EntityField.class) : null;
                    final String entityProperty = annotation != null && StringUtils.isNotBlank(annotation.entityProperty()) ?
                            annotation.entityProperty() : field.getName();
                    setPropertyValue(model, entityProperty, getPropertyValue(dto, field.getName()));
                });
    }

    public static List<Field> getFields(Class<?> type) {
        final List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

}
