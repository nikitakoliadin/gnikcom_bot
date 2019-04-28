package com.qthegamep.gnikcom_bot.controller;

import com.qthegamep.gnikcom_bot.util.ConstantsUtil;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MainControllerImpl extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return System.getProperty(ConstantsUtil.TELEGRAM_BOT_USERNAME);
    }

    @Override
    public String getBotToken() {
        return System.getProperty(ConstantsUtil.TELEGRAM_BOT_TOKEN);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO: Implements
        System.out.println(update.toString());
    }
}
