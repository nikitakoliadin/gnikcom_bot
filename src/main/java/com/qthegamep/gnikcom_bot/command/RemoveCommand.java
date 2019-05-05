package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.exception.CommandShouldNotBeExecutedException;
import com.qthegamep.gnikcom_bot.util.CommandTextsUtil;
import com.qthegamep.gnikcom_bot.util.ConstantsUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RemoveCommand extends BaseCommand implements Command {

    @Override
    public SendMessage buildResponse(Update update) throws CommandShouldNotBeExecutedException {
        val message = update.getMessage();
        checkIfThisBotWasRemoved(message);
        enableNotification();
        setChatId(message);
        setText(message);
        return response;
    }

    private void checkIfThisBotWasRemoved(Message message) throws CommandShouldNotBeExecutedException {
        val botUserName = System.getProperty(ConstantsUtil.TELEGRAM_BOT_USERNAME);
        val leftUserName = message.getLeftChatMember().getUserName();
        if (botUserName.equals(leftUserName)) {
            throw new CommandShouldNotBeExecutedException(
                    "Message could not be sent to the chat when the bot was removed!"
            );
        }
    }

    private void setText(Message message) {
        val text = getText(message);
        response.setText(text);
    }

    private String getText(Message message) {
        val leftChatMember = message.getLeftChatMember();
        val firstName = leftChatMember.getFirstName();
        val lastName = leftChatMember.getLastName();
        val text = CommandTextsUtil.getRandomTextFrom(CommandTextsUtil.REMOVE_COMMAND_TEXTS);
        val textWithName = text + " " + firstName + " " + lastName;
        return formatToItalicText(textWithName);
    }
}
