package com.qthegamep.gnikcom_bot.factory;

import com.qthegamep.gnikcom_bot.command.*;
import com.qthegamep.gnikcom_bot.util.CommandsUtil;

public class CommandFactory {

    public Command createCommand(String command) {
        switch (command) {
            case CommandsUtil.START_COMMAND: {
                return new StartCommand();
            }
            case CommandsUtil.HELP_COMMAND: {
                return new HelpCommand();
            }
            case CommandsUtil.INVITE_SYSTEM_COMMAND: {
                return new InviteCommand();
            }
            case CommandsUtil.REMOVE_SYSTEM_COMMAND: {
                return new RemoveCommand();
            }
            default: {
                return new DefaultCommand();
            }
        }
    }
}
