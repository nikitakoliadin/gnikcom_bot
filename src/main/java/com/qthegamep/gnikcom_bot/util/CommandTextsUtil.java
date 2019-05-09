package com.qthegamep.gnikcom_bot.util;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class CommandTextsUtil {

    public final List<? extends String> START_USER_COMMAND_TEXTS = fillTexts("start.user.command");
    public final List<? extends String> START_GROUP_COMMAND_TEXTS = fillTexts("start.group.command");
    public final List<? extends String> HELP_COMMAND_TEXTS = fillTexts("help.command");
    public final List<? extends String> INVITE_BOT_COMMAND_TEXTS = fillTexts("invite.bot.command");
    public final List<? extends String> INVITE_USER_COMMAND_TEXTS = fillTexts("invite.user.command");
    public final List<? extends String> INVITE_USERS_COMMAND_TEXTS = fillTexts("invite.users.command");
    public final List<? extends String> REMOVE_COMMAND_TEXTS = fillTexts("remove.command");
    public final List<? extends String> DEFAULT_NOT_FOUND_COMMAND_TEXTS = fillTexts("default.not.found.command");
    public final List<? extends String> DEFAULT_CREATE_GROUP_COMMAND_TEXTS = fillTexts("default.create.group.command");

    public String getRandomTextFrom(List<? extends String> texts) {
        val size = texts.size();
        val index = getIndex(size);
        return texts.get(index);
    }

    private List<? extends String> fillTexts(String prefix) {
        val texts = new ArrayList<String>();
        val properties = System.getProperties();
        properties.forEach((key, value) -> {
            if (key.toString().startsWith(prefix)) {
                texts.add((String) value);
            }
        });
        return texts;
    }

    private int getIndex(int size) {
        val random = new Random();
        return random.nextInt(size);
    }
}
