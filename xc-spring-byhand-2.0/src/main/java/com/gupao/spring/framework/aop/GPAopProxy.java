package com.gupao.spring.framework.aop;

import com.sun.istack.internal.Nullable;

/**
 * description
 *
 * @author lichao chao.li07@hand-china.com 2021-01-28 23:43
 */
public interface GPAopProxy {

    Object getProxy();

    Object getProxy(@Nullable ClassLoader classLoader);

}
