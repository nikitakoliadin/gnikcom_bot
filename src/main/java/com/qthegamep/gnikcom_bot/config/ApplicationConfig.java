package com.qthegamep.gnikcom_bot.config;

import com.qthegamep.gnikcom_bot.exception.CouldNotStartApplicationException;
import com.qthegamep.gnikcom_bot.util.ApplicationUtil;
import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ApplicationConfig {

    private static ApplicationConfig instance;

    private ApplicationConfig() throws CouldNotStartApplicationException {
        init();
    }

    public static ApplicationConfig getInstance() throws CouldNotStartApplicationException {
        if (instance == null) {
            instance = new ApplicationConfig();
        }
        return instance;
    }

    private static void init() throws CouldNotStartApplicationException {
        try {
            logInfo();
            val properties = loadProperties();
            loadToSystemProperties(properties);
        } catch (Exception e) {
            LogUtil.logError("ERROR", e);
            throw new CouldNotStartApplicationException(e.getMessage(), e);
        }
    }

    private static void logInfo() {
        LogUtil.logWarn("{} = {}", ApplicationUtil.LOG_PATH, System.getProperty(ApplicationUtil.LOG_PATH));
        LogUtil.logWarn("{} = {}", ApplicationUtil.CONFIG_PATH, System.getProperty(ApplicationUtil.CONFIG_PATH));
        LogUtil.logWarn("{} = {}", ApplicationUtil.COMMAND_TEXTS_PATH, System.getProperty(ApplicationUtil.COMMAND_TEXTS_PATH));
    }

    private static Properties loadProperties() throws IOException {
        val properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(
                System.getProperty(ApplicationUtil.CONFIG_PATH)),
                StandardCharsets.UTF_8
        ));
        properties.load(new InputStreamReader(new FileInputStream(
                System.getProperty(ApplicationUtil.COMMAND_TEXTS_PATH)),
                StandardCharsets.UTF_8
        ));
        return properties;
    }

    private static void loadToSystemProperties(Properties properties) {
        properties.forEach((key, value) -> System.setProperty((String) key, (String) value));
    }
}
