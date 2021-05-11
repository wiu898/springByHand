package com.gupao.spring.framework.aop.intercept;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 20:18
 */
public interface GPMethodInterceptor {

    Object invoke(GPMethodInvocation invocation) throws Throwable;
}
