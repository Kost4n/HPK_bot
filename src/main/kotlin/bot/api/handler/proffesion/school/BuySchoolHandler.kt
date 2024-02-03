package bot.api.handler.proffesion.school

import bot.api.createBuyCategoryMessage
import bot.api.createMessageWithInlineButtons
import bot.api.getInlineKeyboard
import bot.api.handler.CallbackHandler
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender
import service.WorksServiceImpl

@Component
class BuySchoolHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.SCHOOL_WORKS

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
            val data = WorksServiceImpl().getSchoolNameWorks()
            val callback = HandlerName.BUY_SCHOOL_START_PAY.text
            for (record in data) {
                if (record.id.toString() == arguments.first()) {
                    absSender.execute(
                        createMessageWithInlineButtons(
                            chatId,
                            record.summary,
                            listOf(
                                listOf(
                                    "$callback|back" to "Назад",
                                    "$callback|buy_this_work|${record.id}|$name" to "Купить"
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