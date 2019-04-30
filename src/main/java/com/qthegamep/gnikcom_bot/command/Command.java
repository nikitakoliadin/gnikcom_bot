package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

@FunctionalInterface
public interface Command {

    default BotApiMethod<? extends Serializable> execute(Update update) {
        logStartOfCommand(update);
        val response = buildResponse(update);
        logEndOfCommand(update);
        return response;
    }

    BotApiMethod<? extends Serializable> buildResponse(Update update);

    private void logStartOfCommand(Update update) {
        log("Started execution of [{}] from {id: {}, name: {} {}}", update);
    }

    private void logEndOfCommand(Update update) {
        log("Ended execution of [{}] from {id: {}, name: {} {}}", update);
    }

    private void log(String message, Update update) {
        val command = this.getClass().getSimpleName();
        val user = update.getMessage().getFrom();
        val userId = user.getId();
        val firstName = user.getFirstName();
        val lastName = user.getLastName();
        LogUtil.logInfo(message, command, userId, firstName, lastName);
    }
}
