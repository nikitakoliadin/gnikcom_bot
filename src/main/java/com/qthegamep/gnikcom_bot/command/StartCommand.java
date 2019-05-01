package com.qthegamep.gnikcom_bot.command;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand extends BaseCommand implements Command {

    @Override
    public SendMessage buildResponse(Update update) {
        enableMarkdown();
        enableNotification();
        val message = update.getMessage();
        setChatId(message);
        setText(message);
        return response;
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
}
