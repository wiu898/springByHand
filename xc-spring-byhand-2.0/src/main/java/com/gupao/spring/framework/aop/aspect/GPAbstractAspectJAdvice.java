package com.gupao.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 22:27
 */
public class GPAbstractAspectJAdvice implements GPAdvice {

    private Object aspect;      //切面类

    private Method adviceMethod;  //消息通知方法

    private String throwName;   //异常方法名


    public GPAbstractAspectJAdvice(Object aspect, Method adviceMethod) {
        this.aspect = aspect;
        this.adviceMethod = adviceMethod;
    }

    public Object invokeAdviceMethod(GPJoinPoint joinPoint, Object returnValue, Throwable ex)
            throws Throwable {

        Class<?> [] paramTypes = this.adviceMethod.getParameterTypes();
        if(paramTypes == null || paramTypes.length == 0){
            return this.adviceMethod.invoke(aspect);
        }else{
            Object args[] = new Object[paramTypes.length];
            for(int i = 0; i < paramTypes.length; i++){
                if(paramTypes[i] == GPJoinPoint.class){
                    args[i] = joinPoint;
                }else if(paramTypes[i] == Throwable.class){
                    args[i] = ex;
                }else if(paramTypes[i] == Object.class){
                    args[i] = returnValue;
                }
            }
            return this.adviceMethod.invoke(aspect,args);
        }
    }

}
