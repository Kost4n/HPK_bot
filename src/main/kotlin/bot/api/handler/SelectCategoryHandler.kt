package bot.api.handler

import bot.api.*
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class SelectCategoryHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.SELECT_CATEGORY

    override fun processCallbackData(
        absSender: AbsSender,
        callbackQuery: CallbackQuery,
        arguments: List<String>
    ) {

        val chatId = callbackQuery.message.chatId.toString()
        val buyOrSell = arguments.last()
        if (arguments.first() == "back") {
            val callback = HandlerName.SELECT_BUY_OR_SELL.text
            absSender.execute(
                createSelectCategoryMessage(chatId, callback)
            )
        } else if (buyOrSell == "buy") {
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
                    "Тут надо придумать как user продаёт работу"
                )
            )
//            val callback = ""
//            absSender.execute(
//                createMessageWithInlineButtons(
//                    chatId,
//                    getTextMessageForSell(arguments.first()),
//                    listOf(
//                        listOf(
//                            "$callback|" to "Да", "$callback|back" to "Назад"
//                        )
//                    )
//                )
//            )
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