package com.qthegamep.gnikcom_bot.command;

import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.val;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

abstract class BaseCommand implements Command {

    SendMessage response = new SendMessage();

    void enableNotification() {
        response.enableNotification();
    }

    void setChatId(Message message) {
        val chatId = message.getChatId();
        response.setChatId(chatId);
    }

    void setReplyToMessageId(Message message) {
        val messageId = message.getMessageId();
        response.setReplyToMessageId(messageId);
    }

    String formatToItalicText(String text) {
        if (!text.contains("_")) {
            enableMarkdown();
            return "_" + text + "_";
        } else if ((!text.contains("<")) && (!text.contains(">"))) {
            enableHtml();
            return "<i>" + text + "</i>";
        } else {
            LogUtil.logWarn("Can not format to italic text! Text: {}", text);
            return text;
        }
    }

    private void enableMarkdown() {
        response.enableMarkdown(true);
    }

    private void enableHtml() {
        response.enableHtml(true);
    }
}
