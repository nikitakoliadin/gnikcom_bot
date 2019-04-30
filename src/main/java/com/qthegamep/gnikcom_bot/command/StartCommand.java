package com.qthegamep.gnikcom_bot.command;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private SendMessage response = new SendMessage();

    @Override
    public SendMessage buildResponse(Update update) {
        val message = update.getMessage();
        setFlags();
        setChatId(message);
        setText(message);
        return response;
    }

    private void setFlags() {
        response.enableMarkdown(true);
        response.enableNotification();
    }

    private void setChatId(Message message) {
        val chatId = message.getChatId();
        response.setChatId(chatId);
    }

    private void setText(Message message) {
        val text = getText(message);
        response.setText(text);
    }

    private String getText(Message message) {
        if (message.isUserMessage()) {
            // TODO: Implements
            return "_Test user start command_";
        } else {
            setReplyToMessageId(message);
            // TODO: Implements
            return "_Test group start command_";
        }
    }

    private void setReplyToMessageId(Message message) {
        val messageId = message.getMessageId();
        response.setReplyToMessageId(messageId);
    }
}
