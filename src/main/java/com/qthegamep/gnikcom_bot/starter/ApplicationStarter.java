package com.qthegamep.gnikcom_bot.starter;

import com.qthegamep.gnikcom_bot.config.Config;
import com.qthegamep.gnikcom_bot.exception.CouldNotStartApplicationException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationStarter {

    public void startApplication() throws CouldNotStartApplicationException {
        initConfig();
    }

    private void initConfig() throws CouldNotStartApplicationException {
        Config.getInstance();
    }
}
