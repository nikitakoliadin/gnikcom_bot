package com.qthegamep.gnikcom_bot.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MainControllerImpl extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return System.getProperty("telegram.bot.username");
    }

    @Override
    public String getBotToken() {
        return System.getProperty("telegram.bot.token");
    }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO: Implements
        System.out.println(update.toString());
    }
}
