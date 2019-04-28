package com.qthegamep.gnikcom_bot.starter;

import com.qthegamep.gnikcom_bot.controller.MainControllerImpl;
import com.qthegamep.gnikcom_bot.util.ConstantsUtil;
import com.qthegamep.gnikcom_bot.util.LogUtil;

import lombok.experimental.UtilityClass;
import lombok.val;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@UtilityClass
class TelegramBotStarter {

    void start() throws TelegramApiRequestException {
        initBot();
        logSuccessStart();
    }

    private void initBot() throws TelegramApiRequestException {
        ApiContextInitializer.init();
        val telegramBotsApi = createTelegramBotsApi();
        val bot = createBot();
        telegramBotsApi.registerBot(bot);
    }

    private TelegramBotsApi createTelegramBotsApi() {
        return new TelegramBotsApi();
    }

    private MainControllerImpl createBot() {
        return new MainControllerImpl();
    }

    private void logSuccessStart() {
        LogUtil.logInfo("Telegram bot \"{}\" was started!", System.getProperty(ConstantsUtil.TELEGRAM_BOT_NAME));
    }
}
