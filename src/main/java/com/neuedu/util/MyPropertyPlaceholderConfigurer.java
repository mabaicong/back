package com.neuedu.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by mabaicong on 2019/4/6.
 */
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(propertyName.equals("username")||propertyName.equals("password")) {
            return DESUTIL.decode(propertyValue);
        }
        return propertyValue;
    }
}
