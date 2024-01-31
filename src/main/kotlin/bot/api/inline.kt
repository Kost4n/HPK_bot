package bot.api



fun createSelectCategoryMessage(chatId: String, callback: String) =
    createMessageWithInlineButtons(
        chatId,
        "Чего ты желаешь?",
        listOf(
            listOf(
                "$callback|buy" to "Купить работу", "$callback|sell" to "Продать работу"
            )
        )
    )

fun createBuyCategoryMessage(chatId: String, callback: String) =
    createMessageWithInlineButtons(
        chatId,
        "Выбери из какого раздела ты хочешь купить",
        listOf(
            listOf(
                "$callback|programmer|buy" to "Программист",
                "$callback|mechanic|buy" to "Механик",
            ),
            listOf(
                "$callback|woodworker|buy" to "Деревообработчик",
                "$callback|builder|buy" to "Строитель",
            ),
            listOf(
                "$callback|lawyer|buy" to "Юрист",
                "$callback|accountant|buy" to "Бухгалтер",
            ),
            listOf(
                "$callback|school|buy" to "Школа",
                "$callback|firstyear|buy" to "Первый курс",
            ),
            listOf(
                "$callback|cook|buy" to "повар",
                "$callback|hz|buy" to "Потом ещё добавим",
                ),
            listOf(
                "$callback|back" to "Назад"
            )
        )
    )

fun createSellCategoryMessage(chatId: String, callback: String) =
    createMessageWithInlineButtons(
        chatId,
        "Выбери в какой раздел ты хочешь продать",
        listOf(
            listOf(
                "$callback|programmer|sell" to "Программист",
                "$callback|mechanic|sell" to "Механик",
            ),
            listOf(
                "$callback|woodworker|sell" to "Деревообработчик",
                "$callback|builder|sell" to "Строитель",
            ),
            listOf(
                "$callback|lawyer|sell" to "Юрист",
                "$callback|accountant|sell" to "Бухгалтер",
            ),
            listOf(
                "$callback|school|sell" to "Школа",
                "$callback|firstyear|sell" to "Первый курс",
            ),
            listOf(
                "$callback|cook|sell" to "Повак",
                "$callback|hz|sell" to "Потом ещё добавим",
            ),
            listOf(
                "$callback|back" to "Назад"
            )
        )
    )