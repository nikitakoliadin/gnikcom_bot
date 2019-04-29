package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

public interface Command {

    BotApiMethod<? extends Serializable> execute(Update update) throws TelegramBotException;
}
