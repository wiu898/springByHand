package com.gupao.spring.framework.aop;

import com.gupao.spring.framework.aop.support.GPAdvisedSupport;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-29 23:42
 */
public class GPDefaultAopProxyFactory {

    public GPAopProxy createAopProxy(GPAdvisedSupport config) throws Exception {
        Class targetClass = config.getTargetClass();
        if(targetClass.getInterfaces().length > 0){
            return new GPJdkDynamicAopProxy(config);
        }
        return new GPCglibAopProxy();
    }

}
