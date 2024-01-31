package bot.api.handler

import bot.api.*
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class SelectBuyOrSellHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.SELECT_BUY_OR_SELL

    override fun processCallbackData(
        absSender: AbsSender,
        callbackQuery: CallbackQuery,
        arguments: List<String>
    ) {
        val chatId = callbackQuery.message.chatId.toString()
        val callback = HandlerName.SELECT_CATEGORY.text

        if (arguments.first() == "buy") {
            absSender.execute(
                createBuyCategoryMessage(chatId, callback)
            )
        } else {
            absSender.execute(
                createSellCategoryMessage(chatId, callback)
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