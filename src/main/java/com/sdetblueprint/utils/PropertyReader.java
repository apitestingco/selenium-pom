package com.sdetblueprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    public void loadAllProperties() {
        properties = new Properties();
        try {
            String propertyfilepath=System.getProperty("user.dir")+"/src/main/resources/prod_config.properties";
            // System.out.println(propertyfilepath);
            properties.load(new FileInputStream(propertyfilepath));
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public static String readItem(String propertyName) {
        return properties.getProperty(propertyName);
    }

}
