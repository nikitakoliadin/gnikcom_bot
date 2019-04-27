package com.qthegamep.gnikcom_bot.testhelper.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigUtil {

    public void setPathToTestProperties() {
        System.setProperty("config.path", "src/main/resources/properties/config.properties");
    }
}
