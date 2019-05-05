package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.CommandsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DefaultCommand extends BaseCommand implements Command {

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
        if (message.hasText()) {
            val text = CommandsUtil.getRandomTextFrom(CommandsUtil.DEFAULT_NOT_FOUND_COMMAND_TEXTS);
            return formatToItalicText(text);
        } else {
            val text = CommandsUtil.getRandomTextFrom(CommandsUtil.DEFAULT_CREATE_GROUP_COMMAND_TEXTS);
            return formatToItalicText(text);
        }
    }
}
