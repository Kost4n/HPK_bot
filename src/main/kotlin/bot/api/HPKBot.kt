package bot.api

import bot.api.*
import bot.api.handler.CallbackHandler
import bot.enums.HandlerName
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class HPKBot (
    commands: Set<BotCommand>,
    callbackHandlers: Set<CallbackHandler>,
    @Value("\${telegram.token}")
    token: String,
) : TelegramLongPollingCommandBot(token) {
    private var handlerMapping: Map<String, CallbackHandler>

    init {
        registerAll(*commands.toTypedArray())
        handlerMapping = callbackHandlers.associateBy { it.name.text }
    }

    @Value("\$telegram.botName")
    private val botName: String = ""

    override fun getBotUsername(): String = botName


    override fun processNonCommandUpdate(update: Update) {
        if (update.hasMessage()) {
            val chatId = update.message.chatId.toString()
            if (update.message.hasText()) {
                if (update.message.text == "Разрешите обратиться товарищ") {
                    val callback = HandlerName.SELECT_BUY_OR_SELL.text
                    execute(
                        createSelectCategoryMessage(chatId, callback)
                    )
                }
            } else {
                execute(createMessage(chatId, "Я понимаю только текст!"))
            }
        } else if (update.hasCallbackQuery()) {
            val callbackQuery = update.callbackQuery
            val callbackData = callbackQuery.data

            val callbackQueryId = callbackQuery.id
            execute(AnswerCallbackQuery(callbackQueryId))

            val callbackArguments = callbackData.split("|")
            val callbackHandlerName = callbackArguments.first()

            handlerMapping.getValue(callbackHandlerName)
                .processCallbackData(
                    this,
                    callbackQuery,
                    callbackArguments.subList(1, callbackArguments.size)
                )
        }
    }
}