package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigureDataProvider {

    Properties prop;
    FileInputStream fis;
    String filePath="./Config/config.properties";

    public ConfigureDataProvider() {
        // TODO Auto-generated method stub

        File file=new File(filePath);
        try {
            fis=new FileInputStream(file);
            prop=new Properties();
            prop.load(fis);
        }catch(Exception ex) {
            System.out.println("not able to read"+ex.getMessage());
        }


    }

    public String getDataFromConfig(String search) {
        return prop.getProperty(search);

    }
    public String getUserName() {
        return prop.getProperty("UserName");
    }
    public String getPassword() {
        return prop.getProperty("Password");
    }


}
