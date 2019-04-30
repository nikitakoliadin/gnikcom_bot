package com.qthegamep.gnikcom_bot.command;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {

    private SendMessage response = new SendMessage();

    @Override
    public SendMessage buildResponse(Update update) {
        val message = update.getMessage();
        setFlags();
        setChatId(message);
        setText();
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

    private void setText() {
        val text = getText();
        response.setText(text);
    }

    private String getText() {
        // TODO: Implements
        return "_Test help command_";
    }
}
