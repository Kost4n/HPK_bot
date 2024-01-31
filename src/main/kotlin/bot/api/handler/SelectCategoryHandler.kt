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

        if (arguments.first() == "programmer") {
            if (buyOrSell == "buy") {
                absSender.execute(
                    createMessageWithInlineButtons(
                        chatId,
                        "Вот работы по категории 'Программист'",
                        getProgrammerWorks()
                    )
                )
            } else {
                absSender.execute(
                    createMessage(
                        chatId,
                        "$buyOrSell programmer"
                    )
                )
            }
        } else if (arguments.first() == "mechanic") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell mechanic"
                )
            )
        } else if (arguments.first() == "woodworker") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell woodworker"
                )
            )
        } else if (arguments.first() == "builder") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell builder"
                )
            )
        } else if (arguments.first() == "lawyer") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell lawyer"
                )
            )
        } else if (arguments.first() == "accountant") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell accountant"
                )
            )
        } else if (arguments.first() == "school") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell school"
                )
            )
        } else if (arguments.first() == "firstyear") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell firstyear"
                )
            )
        } else if (arguments.first() == "hz") {
            absSender.execute(
                createMessage(
                    chatId,
                    "$buyOrSell hz"
                )
            )
        } else if (arguments.first() == "back") {
            val callback = HandlerName.SELECT_BUY_OR_SELL.text
            absSender.execute(
              createSelectCategoryMessage(chatId, callback)
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