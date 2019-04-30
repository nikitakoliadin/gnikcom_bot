package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.TelegramBotException;
import com.qthegamep.gnikcom_bot.util.ConstantsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class RemoveCommand implements Command {

    private SendMessage response = new SendMessage();

    @Override
    public SendMessage buildResponse(Update update) throws TelegramBotException {
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

    private void setText(Message message) throws TelegramBotException {
        val text = getText(message);
        response.setText(text);
    }

    private String getText(Message message) throws TelegramBotException {
        val leftChatMember = message.getLeftChatMember();
        checkBotRemoved(leftChatMember);
        val firstName = leftChatMember.getFirstName();
        val lastName = leftChatMember.getLastName();
        // TODO: Implements
        return "_Test remove command " + firstName + " " + lastName + "_";
    }

    private void checkBotRemoved(User leftChatMember) throws TelegramBotException {
        val botUserName = System.getProperty(ConstantsUtil.TELEGRAM_BOT_USERNAME);
        val leftUserName = leftChatMember.getUserName();
        if (botUserName.equals(leftUserName)) {
            throw new TelegramBotException("Could not send message to chat when bot removed!");
        }
    }
}
