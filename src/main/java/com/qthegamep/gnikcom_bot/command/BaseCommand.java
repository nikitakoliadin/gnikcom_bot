package com.qthegamep.gnikcom_bot.command;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

abstract class BaseCommand implements Command {

    SendMessage response = new SendMessage();

    void enableMarkdown() {
        response.enableMarkdown(true);
    }

    void enableNotification() {
        response.enableNotification();
    }

    void setChatId(Message message) {
        val chatId = message.getChatId();
        response.setChatId(chatId);
    }

    void setReplyToMessageId(Message message) {
        val messageId = message.getMessageId();
        response.setReplyToMessageId(messageId);
    }
}
