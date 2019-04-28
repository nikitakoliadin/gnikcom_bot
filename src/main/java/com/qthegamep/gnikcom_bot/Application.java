package com.qthegamep.gnikcom_bot;

import com.qthegamep.gnikcom_bot.exception.CouldNotStartApplicationException;
import com.qthegamep.gnikcom_bot.starter.ApplicationStarter;

import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Application {

    public static void main(String[] args) throws CouldNotStartApplicationException, TelegramApiRequestException {
        ApplicationStarter.startApplication();
    }
}
