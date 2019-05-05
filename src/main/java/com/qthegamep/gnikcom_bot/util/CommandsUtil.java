package com.qthegamep.gnikcom_bot.util;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class CommandsUtil {

    public final String START_COMMAND = "/start";
    public final String HELP_COMMAND = "/help";
    public final String INVITE_SYSTEM_COMMAND = "INVITE";
    public final String REMOVE_SYSTEM_COMMAND = "REMOVE";
    public final String DEFAULT_COMMAND = "DEFAULT";

    // TODO: Implements
    public final List<? extends String> START_USER_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test user start command");
    }};

    // TODO: Implements
    public final List<? extends String> START_GROUP_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test group start command");
    }};

    // TODO: Implements
    public final List<? extends String> HELP_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test help command");
    }};

    // TODO: Implements
    public final List<? extends String> INVITE_BOT_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test bot invite command");
    }};

    // TODO: Implements
    public final List<? extends String> INVITE_USER_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test user invite command");
    }};

    // TODO: Implements
    public final List<? extends String> INVITE_USERS_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test users invite command");
    }};

    // TODO: Implements
    public final List<? extends String> REMOVE_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test remove command");
    }};

    // TODO: Implements
    public final List<? extends String> DEFAULT_NOT_FOUND_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test not found default command");
    }};

    // TODO: Implements
    public final List<? extends String> DEFAULT_CREATE_GROUP_COMMAND_TEXTS = new ArrayList<>() {{
        add("Test create group default command");
    }};

    public String getRandomTextFrom(List<? extends String> texts) {
        val size = texts.size();
        val index = getIndex(size);
        return texts.get(index);
    }

    private int getIndex(int size) {
        val random = new Random();
        return random.nextInt(size);
    }
}
