package com.qthegamep.gnikcom_bot.testhelper.util;

import com.qthegamep.gnikcom_bot.util.ApplicationUtil;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigUtil {

    public void setPathToTestProperties() {
        System.setProperty(ApplicationUtil.LOG_PATH, "C:/opt/logs/gnikcom_bot");
        System.setProperty(ApplicationUtil.CONFIG_PATH, "src/main/resources/properties/config.properties");
        System.setProperty(ApplicationUtil.COMMAND_TEXTS_PATH, "src/main/resources/texts/commandTexts.properties");
    }
}
