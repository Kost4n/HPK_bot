package bot.api.commands

import bot.api.*
import bot.enums.CommandName
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class StartCommand : BotCommand(CommandName.START.text, "") {
    override fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        val chatId = chat.id.toString()
        absSender.execute(createMessage(chatId, "Добро пожаловать!"))
//        absSender.execute(
//            createMessage(chatId, "Бот создан, чтобы добавлять и получать всякие готовые работы" +
//                "\nПо типу ВСР, курсовых, проектов и т.д.")
//        )
        absSender.execute(
            createMessageWithButtons(
                chatId,
                "Бот создан, чтобы добавлять и получать всякие готовые работы\n" +
                        "По типу ВСР, курсовых, проектов и т.д.",
                listOf(
                    "Разрешите обратиться товарищ"
                )
            )
        )
    }
}