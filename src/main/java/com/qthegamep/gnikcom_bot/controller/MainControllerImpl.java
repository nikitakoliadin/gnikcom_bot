package com.qthegamep.gnikcom_bot.controller;

import com.qthegamep.gnikcom_bot.command.Command;
import com.qthegamep.gnikcom_bot.exception.TelegramBotException;
import com.qthegamep.gnikcom_bot.factory.CommandFactory;
import com.qthegamep.gnikcom_bot.util.ConstantsUtil;
import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

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
    public void onUpdateReceived(Update update) throws TelegramBotException {
        logRequestInfo(update);
        val command = getCommand(update);
        // TODO: Implements
    }

    private void logRequestInfo(Update update) {
        LogUtil.logInfo("Request: {}", update);
    }

    private Command getCommand(Update update) throws TelegramBotException {
        val commandFactory = new CommandFactory();
        return commandFactory.getCommand(update);
    }
}
