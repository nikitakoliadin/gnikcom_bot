package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;
import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

@FunctionalInterface
public interface Command {

    BotApiMethod<? extends Serializable> execute(Update update) throws TelegramBotException;

    default void logStartOfCommand() {
        val commandName = this.getClass().getSimpleName();
        LogUtil.logInfo("Started execution of [{}]", commandName);
    }

    default void logEndOfCommand() {
        val commandName = this.getClass().getSimpleName();
        LogUtil.logInfo("Ended execution of [{}]", commandName);
    }
}
