package bot.api.handler.proffesion.firstyear

import bot.api.*
import bot.api.handler.CallbackHandler
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class StartPayFirstyearHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.BUY_FIRSTYEAR_START_PAY

    override fun processCallbackData(
        absSender: AbsSender,
        callbackQuery: CallbackQuery,
        arguments: List<String>
    ) {

        val chatId = callbackQuery.message.chatId.toString()
        if (arguments.first() == "back") {
            absSender.execute(
                createMessageWithInlineButtons(
                    chatId,
                    getTextMessageForBuy(arguments.first()),
                    getWorksName(arguments.first())
                )
            )
        } else {
            absSender.execute(
                createMessage(
                    chatId,
                    "Начать диалог по покупке ${arguments.last().split("_")} работы c id ${arguments.get(1)}"
                )
            )
        }

        absSender.execute(
            EditMessageReplyMarkup(
                chatId,
                callbackQuery.message.messageId,
                callbackQuery.inlineMessageId,
                getInlineKeyboard(emptyList())
            )
        )
    }
}