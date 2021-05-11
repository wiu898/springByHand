package com.gupao.spring.framework.aop.support;

import com.gupao.spring.framework.beans.config.GPBeanDefinition;
import com.gupao.spring.framework.core.GPBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-25 22:30
 */
public class GPDefaultListableBeanFactory implements GPBeanFactory {

    public Map<String, GPBeanDefinition> beanDefinitionMap = new HashMap<String, GPBeanDefinition>();

    @Override
    public Object getBean(Class beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }


    /*
     * 缓存Map格式的BeanDefinition
     */
    public void doRegistBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception{
        for(GPBeanDefinition beanDefinition : beanDefinitions){
            if(this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + " is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }


}
