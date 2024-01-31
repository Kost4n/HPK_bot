package bot.api.commands

import bot.api.createMessage
import bot.api.createMessageWithInlineButtons
import bot.enums.CommandName
import bot.enums.HandlerName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class QuizCommand: BotCommand(CommandName.QUIZ_ANSWER.text, "") {
    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        val callback = HandlerName.QUIZ_ANSWER.text
        absSender.execute(
            createMessageWithInlineButtons(
                chat.id.toString(),
                "Как называется ближайшая к Солнцу планета?",
                listOf(
                    listOf("$callback|a" to "Земля", "$callback|b" to "Меркурий"),
                    listOf("$callback|c" to "Хз")
                )
            )

        )
    }
}