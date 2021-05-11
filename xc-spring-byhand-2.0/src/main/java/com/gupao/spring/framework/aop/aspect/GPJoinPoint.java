package com.gupao.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 22:34
 */
public interface GPJoinPoint {

    Object getThis();

    Object[] getArguments();

    Method getMethod();

    void setUserAttribute(String key, Object value );

    Object getUserAttribute(String key);



}
