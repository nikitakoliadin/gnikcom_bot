package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    @Override
    public SendMessage execute(Update update) throws TelegramBotException {
        logStartOfCommand();
        // TODO: Implements
        logEndOfCommand();
        return null;
    }
}
