package com.qthegamep.gnikcom_bot.controller;

import com.qthegamep.gnikcom_bot.command.Command;
import com.qthegamep.gnikcom_bot.exception.TelegramBotException;
import com.qthegamep.gnikcom_bot.factory.CommandFactory;
import com.qthegamep.gnikcom_bot.service.CommandService;
import com.qthegamep.gnikcom_bot.util.ConstantsUtil;
import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

public class BotController extends TelegramLongPollingBot {

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
        val textCommand = getTextCommand(update);
        val command = getCommand(textCommand);
        val response = command.execute(update);
        sendResponse(response);
    }

    private void logRequestInfo(Update update) {
        LogUtil.logInfo("Request: {}", update);
    }

    private String getTextCommand(Update update) throws TelegramBotException {
        val commandService = new CommandService();
        return commandService.getTextCommand(update);
    }

    private Command getCommand(String textCommand) {
        val commandFactory = new CommandFactory();
        return commandFactory.createCommand(textCommand);
    }

    private void sendResponse(BotApiMethod<? extends Serializable> response) throws TelegramBotException {
        try {
            val responseResult = execute(response);
            LogUtil.logInfo("Response: {}", responseResult);
        } catch (TelegramApiException e) {
            LogUtil.logError("ERROR", e);
            throw new TelegramBotException(e.getMessage(), e);
        }
    }
}
