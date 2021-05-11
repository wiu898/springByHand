package com.gupao.spring.framework.aop.aspect;

import com.gupao.spring.framework.aop.intercept.GPMethodInterceptor;
import com.gupao.spring.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 22:21
 */
public class GPMethodBeforeAdviceInterceptor extends GPAbstractAspectJAdvice implements GPMethodInterceptor {

    private GPJoinPoint jp;

    public GPMethodBeforeAdviceInterceptor(Object aspect, Method adviceMethod) {
         super(aspect, adviceMethod);
    }

    public void before(Method method, Object[] arguments, Object aThis) throws Throwable{
        invokeAdviceMethod(this.jp,null,null);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        jp = mi;
        this.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        return mi.proceed();
    }


}
