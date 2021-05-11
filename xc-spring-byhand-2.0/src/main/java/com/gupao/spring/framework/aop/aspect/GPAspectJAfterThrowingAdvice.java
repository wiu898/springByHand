package com.gupao.spring.framework.aop.aspect;

import com.gupao.spring.framework.aop.intercept.GPMethodInterceptor;
import com.gupao.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 22:23
 */
public class GPAspectJAfterThrowingAdvice extends GPAbstractAspectJAdvice implements GPMethodInterceptor {

    private String throwName;

    public GPAspectJAfterThrowingAdvice(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        }
        catch (Throwable ex) {
            invokeAdviceMethod(mi , null, ex);
            throw ex;
        }
    }


    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }
}
