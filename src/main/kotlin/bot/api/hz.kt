package bot.api

import bot.enums.HandlerName
import dto.Work
import service.BaseData
import service.WorksServiceImpl


fun getWorks(category: String) {
    TODO("Реализовать получение списков Работ полностью")
}
fun getWorksName(category: String): MutableList<List<Pair<String, String>>> {
    val callback = getCategoryCallback(category)
    var data = getListNameWorks(category)
    val list = mutableListOf<List<Pair<String, String>>>()
    var gap = mutableListOf<Pair<String, String>>()

    for (record in data) {
        gap.add("$callback|${record.id}" to record.name)

        if (gap.size == 2) {
            list.add(
                listOf(
                    gap[0],
                    gap[gap.size - 1]
                )
            )
            gap.removeAt(0)
            gap.removeAt(gap.size - 1)
        }
    }
    list.add(
        listOf(
            "$callback|back" to "Назад"
        )
    )
    return list
}

fun getCategoryCallback(category: String): String = when (category) {
    "programmer" -> HandlerName.PROGRAMMER_WORKS.text
    "mechanic" -> HandlerName.MECHANIC_WORKS.text
    "woodworker" -> HandlerName.WOODWORKER_WORKS.text
    "builder" -> HandlerName.BUILDER_WORKS.text
    "lawyer" -> HandlerName.LAWYER_WORKS.text
    "accountant" -> HandlerName.ACCOUNTANT_WORKS.text
    "school" -> HandlerName.SCHOOL_WORKS.text
    "firsyear" -> HandlerName.FIRSTYEAR_WORKS.text
    else -> HandlerName.PROGRAMMER_WORKS.text
}

fun getListNameWorks(category: String): List<Work> = when (category) {
    "programmer" -> WorksServiceImpl().getProgrammerNameWorks()
    "mechanic" -> WorksServiceImpl().getProgrammerNameWorks()
    "woodworker" -> WorksServiceImpl().getProgrammerNameWorks()
    "builder" -> WorksServiceImpl().getProgrammerNameWorks()
    "lawyer" -> WorksServiceImpl().getProgrammerNameWorks()
    "accountant" -> WorksServiceImpl().getProgrammerNameWorks()
    "school" -> WorksServiceImpl().getProgrammerNameWorks()
    "firsyear" -> WorksServiceImpl().getProgrammerNameWorks()
    else -> WorksServiceImpl().getProgrammerNameWorks()
}