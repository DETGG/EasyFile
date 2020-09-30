package com.wzx.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {

    /***
     * put param to bean
     * rely on the setXxx method
     * using map can reduce coupling on Web layer
     * @param map
     * @param bean
     */
    public static <T>T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
