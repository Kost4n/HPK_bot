package bot.api.handler.proffesion.programmer

import bot.api.*
import bot.api.handler.CallbackHandler
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender
import service.WorksServiceImpl

@Component
class BuyProgrammerHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.PROGRAMMER_WORKS

    override fun processCallbackData(
        absSender: AbsSender,
        callbackQuery: CallbackQuery,
        arguments: List<String>
    ) {

        val chatId = callbackQuery.message.chatId.toString()
        if (arguments.first() == "back") {
            val callback = HandlerName.SELECT_CATEGORY.text
            absSender.execute(
                createBuyCategoryMessage(chatId, callback)
            )
        } else {
            val data = WorksServiceImpl().getProgrammerNameWorks()
            val callback = HandlerName.BUY_PROGRAMMER_START_PAY.text
            for (record in data) {
                if (record.id.toString() == arguments.first()) {
                    absSender.execute(
                        createMessageWithInlineButtons(
                            chatId,
                            record.summary,
                            listOf(
                                listOf(
                                    "$callback|back" to "Назад",
                                    "$callback|buy_this_work|${record.id}|${name.text}" to "Купить"
                                )
                            )
                        )
                    )
                }
            }
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