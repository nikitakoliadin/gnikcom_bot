package com.qthegamep.gnikcom_bot.service;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;
import com.qthegamep.gnikcom_bot.util.CommandsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;
import java.util.Objects;

public class CommandService {

    public String getTextCommand(Update update) throws TelegramBotException {
        val message = getMessage(update);
        if (hasTextMessage(message)) {
            return getCleanCommand(message);
        } else {
            return getSystemCommand(message);
        }
    }

    private Message getMessage(Update update) throws TelegramBotException {
        checkMessageExist(update);
        return update.getMessage();
    }

    private void checkMessageExist(Update update) throws TelegramBotException {
        if (!update.hasMessage()) {
            throw new TelegramBotException("Message not exists!");
        }
    }

    private boolean hasTextMessage(Message message) {
        return message.hasText();
    }

    private String getCleanCommand(Message message) {
        val command = message.getText();
        if (command.contains("@")) {
            val endIndex = command.indexOf("@");
            return command.substring(0, endIndex).trim();
        }
        return command.trim();
    }

    private String getSystemCommand(Message message) {
        val newChatMembers = message.getNewChatMembers();
        if (hasNewChatMembers(newChatMembers)) {
            return CommandsUtil.INVITE_SYSTEM_COMMAND;
        }
        val leftChatMember = message.getLeftChatMember();
        if (hasLeftChatMember(leftChatMember)) {
            return CommandsUtil.REMOVE_SYSTEM_COMMAND;
        }
        return CommandsUtil.DEFAULT_COMMAND;
    }

    private boolean hasNewChatMembers(List<User> newChatMembers) {
        return !newChatMembers.isEmpty();
    }

    private boolean hasLeftChatMember(User leftChatMember) {
        return Objects.nonNull(leftChatMember);
    }
}
