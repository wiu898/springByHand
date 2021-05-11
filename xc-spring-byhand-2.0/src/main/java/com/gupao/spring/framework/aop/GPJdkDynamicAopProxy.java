package com.gupao.spring.framework.aop;

import com.gupao.spring.framework.aop.intercept.GPMethodInvocation;
import com.gupao.spring.framework.aop.support.GPAdvisedSupport;
import com.gupao.spring.framework.aop.aspect.GPAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-21 17:07
 */
public class GPJdkDynamicAopProxy implements GPAopProxy,InvocationHandler {

    private GPAdvisedSupport advised;

    public GPJdkDynamicAopProxy(GPAdvisedSupport config) {
        this.advised = config;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取可以应用到此方法上的Interceptor列表
        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, this.advised.getTargetClass());

        GPMethodInvocation mi = new GPMethodInvocation(proxy, this.advised.getTarget(),
                method, args, this.advised.getTargetClass() , chain);

        return mi.proceed();
    }

//    private void invokeAdvice(GPAdvice advice) {
//        try {
//            advice.getAdviceMethod().invoke(advice.getAspect());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }

    public Object getProxy() {
        return getProxy(this.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader , this.advised.getTargetClass().getInterfaces(),this);
    }
}
