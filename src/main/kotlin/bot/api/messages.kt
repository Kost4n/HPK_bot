package bot.api

import bot.api.*
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

/** MESSAGE */
fun createMessage(chatId: String, text: String) =
    SendMessage(chatId, text)
        .apply { enableMarkdown(true) }
        .apply { disableWebPagePreview() }

/** MESSAGE WITH KEYBOARD */
fun createMessageWithButtons(chatId: String, text: String, buttons: List<String>) =
    createMessage(chatId, text)
        .apply {
            replyMarkup = getSimpleKeyboard(buttons)
        }

fun getSimpleKeyboard(allButtons: List<String>): ReplyKeyboard =
    ReplyKeyboardMarkup().apply {
        keyboard = allButtons.map { rowButton ->
            val row = KeyboardRow()
            row.add(rowButton)
            row
        }
        resizeKeyboard = true
        oneTimeKeyboard = true
    }

/** MESSAGE WITH INLINE KEYBOARD*/
fun createMessageWithInlineButtons(chatId: String, text: String, inlineButtons: List<List<Pair<String, String>>>) =
    createMessage(chatId, text)
        .apply {
            replyMarkup = getInlineKeyboard(inlineButtons)
        }

//fun getInlineKeyboard(allButtons: List<List<Pair<String, String>>>): InlineKeyboardMarkup =
//    InlineKeyboardMarkup().apply {
//        keyboard = allButtons.map { rowButtons ->
//            rowButtons.map { (data, buttonText) ->
//                InlineKeyboardButton().apply {
//                    text = buttonText
//                    callbackData = data
//                }
//            }
//        }
//    }


//fun createMessageWithInlineButtons(chatId: Long, text: String, inlineButtons: List<Pair<String, String>>) =
//    createMessage(chatId, text)
//        .apply {
//            replyMarkup = getInlineKeyboard(inlineButtons)
//        }
//
//fun getInlineKeyboard(allButtons: List<Pair<String, String>>): InlineKeyboardMarkup =
//    InlineKeyboardMarkup().apply {
//        keyboard = allButtons.map { pair ->
//                InlineKeyboardButton().apply {
//                    text = pair.second
//                    callbackData = pair.first
//                }
//            }
//        }

