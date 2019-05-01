package com.qthegamep.gnikcom_bot.exception;

public class CommandShouldNotBeExecutedException extends RuntimeException {

    public CommandShouldNotBeExecutedException(String message) {
        super(message);
    }
}
