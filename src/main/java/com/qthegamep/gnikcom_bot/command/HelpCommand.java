package com.qthegamep.gnikcom_bot.command;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand extends BaseCommand implements Command {

    @Override
    public SendMessage buildResponse(Update update) {
        enableMarkdown();
        enableNotification();
        val message = update.getMessage();
        setChatId(message);
        setText();
        return response;
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
