package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.ConstantsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class InviteCommand implements Command {

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
        val newChatMembers = message.getNewChatMembers();
        if (containsThisBot(newChatMembers)) {
            // TODO: Implements
            return "_Test bot invite command_";
        }
        if (isOneNewChatMember(newChatMembers)) {
            // TODO: Implements
            return "_Test user invite command_";
        } else {
            // TODO: Implements
            return "_Test users invite command_";
        }
    }

    private boolean containsThisBot(List<User> newChatMembers) {
        val botUserName = System.getProperty(ConstantsUtil.TELEGRAM_BOT_USERNAME);
        return newChatMembers.stream()
                .map(User::getUserName)
                .anyMatch(botUserName::equals);
    }

    private boolean isOneNewChatMember(List<User> newChatMembers) {
        return newChatMembers.size() == 1;
    }
}
