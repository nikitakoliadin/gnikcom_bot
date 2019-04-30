package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

@FunctionalInterface
public interface Command {

    default BotApiMethod<? extends Serializable> execute(Update update) {
        logStartOfCommand();
        val response = buildResponse(update);
        logEndOfCommand();
        return response;
    }

    BotApiMethod<? extends Serializable> buildResponse(Update update);

    private void logStartOfCommand() {
        log("Started execution of [{}]");
    }

    private void logEndOfCommand() {
        log("Ended execution of [{}]");
    }

    private void log(String message) {
        val commandName = this.getClass().getSimpleName();
        LogUtil.logInfo(message, commandName);
    }
}
