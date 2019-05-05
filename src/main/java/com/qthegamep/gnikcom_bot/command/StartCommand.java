package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.CommandsUtil;

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
            val text = CommandsUtil.getRandomTextFrom(CommandsUtil.START_USER_COMMAND_TEXTS);
            return formatToItalicText(text);
        } else {
            setReplyToMessageId(message);
            val text = CommandsUtil.getRandomTextFrom(CommandsUtil.START_GROUP_COMMAND_TEXTS);
            return formatToItalicText(text);
        }
    }
}
