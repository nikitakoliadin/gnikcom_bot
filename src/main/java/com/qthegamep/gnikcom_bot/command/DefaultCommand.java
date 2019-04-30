package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DefaultCommand implements Command {

    @Override
    public SendMessage buildResponse(Update update) throws TelegramBotException {
        // TODO: Implements
        return null;
    }
}
