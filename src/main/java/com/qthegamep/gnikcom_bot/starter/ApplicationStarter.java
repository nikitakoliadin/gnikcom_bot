package com.qthegamep.gnikcom_bot.starter;

import com.qthegamep.gnikcom_bot.config.Config;
import com.qthegamep.gnikcom_bot.exception.CouldNotStartApplicationException;

import lombok.experimental.UtilityClass;

import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@UtilityClass
public class ApplicationStarter {

    public void startApplication() throws CouldNotStartApplicationException, TelegramApiRequestException {
        initConfig();
        startTelegramBot();
    }

    private void initConfig() throws CouldNotStartApplicationException {
        Config.getInstance();
    }

    private void startTelegramBot() throws TelegramApiRequestException {
        TelegramBotStarter.start();
    }
}
