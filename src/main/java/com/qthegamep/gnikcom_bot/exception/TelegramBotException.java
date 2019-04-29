package com.qthegamep.gnikcom_bot.exception;

public class TelegramBotException extends RuntimeException {

    public TelegramBotException(String message) {
        super(message);
    }

    public TelegramBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
