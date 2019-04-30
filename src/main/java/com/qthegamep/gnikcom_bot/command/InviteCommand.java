package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.ConstantsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

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
        val newUser = getNewUser(message);
        if (isBot(newUser)) {
            // TODO: Implements
            return "_Test bot invite command_";
        } else {
            val firstName = newUser.getFirstName();
            val lastName = newUser.getLastName();
            // TODO: Implements
            return "_Test user invite command " + firstName + " " + lastName + "_";
        }
    }

    private User getNewUser(Message message) {
        val newChatMembers = message.getNewChatMembers();
        return newChatMembers.get(0);
    }

    private boolean isBot(User newUser) {
        val botUserName = System.getProperty(ConstantsUtil.TELEGRAM_BOT_USERNAME);
        val newUserName = newUser.getUserName();
        return botUserName.equals(newUserName);
    }
}
