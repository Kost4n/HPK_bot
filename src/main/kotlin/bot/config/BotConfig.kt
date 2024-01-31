package bot.config

import bot.api.HPKBot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
public open class BotConfig public constructor() {
    @Bean
    public open fun telegramBotsApi(bot: HPKBot): TelegramBotsApi =
        TelegramBotsApi(DefaultBotSession::class.java).apply {
            registerBot(bot)
        }

}