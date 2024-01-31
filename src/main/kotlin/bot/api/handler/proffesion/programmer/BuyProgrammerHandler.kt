package bot.api.handler.proffesion.programmer

import bot.api.*
import bot.api.handler.CallbackHandler
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender
import service.BaseData

@Component
class BuyProgrammerHandler : CallbackHandler {
    override val name: HandlerName = HandlerName.PROGRAMMER_WORKS

    override fun processCallbackData(
        absSender: AbsSender,
        callbackQuery: CallbackQuery,
        arguments: List<String>
    ) {

        val chatId = callbackQuery.message.chatId.toString()
        val data = BaseData().getListProgrammerWorks()

        for (record in data)  {
            if (record.id.toString() == arguments.first()) {
                absSender.execute(
                    createMessage(
                        chatId,
                        record.summary
                    )
                )
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