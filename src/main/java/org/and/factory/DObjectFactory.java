package org.and.factory;

import org.apache.ibatis.reflection.factory.ObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 10:47
 */
public class DObjectFactory implements ObjectFactory {
    /**
     * Sets configuration properties.
     *
     * @param properties configuration properties
     */
    public void setProperties(Properties properties) {

    }

    /**
     * Creates a new object with default constructor.
     *
     * @param type Object type
     * @return
     */
    public <T> T create(Class<T> type) {
        return null;
    }

    /**
     * Creates a new object with the specified constructor and params.
     *
     * @param type                Object type
     * @param constructorArgTypes Constructor argument types
     * @param constructorArgs     Constructor argument values
     * @return
     */
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return null;
    }

    /**
     * Returns true if this object can have a set of other objects.
     * It's main purpose is to support non-java.util.Collection objects like Scala collections.
     *
     * @param type Object type
     * @return whether it is a collection or not
     * @since 3.1.0
     */
    public <T> boolean isCollection(Class<T> type) {
        return false;
    }
}
