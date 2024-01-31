package bot.api

import bot.enums.HandlerName
import service.BaseData

fun getProgrammerWorks(): MutableList<List<Pair<String, String>>> {
    val callback = HandlerName.PROGRAMMER_WORKS.text
    val data = BaseData().getListProgrammerWorks()
    val list = mutableListOf<List<Pair<String, String>>>()
    var gap = mutableListOf<Pair<String, String>>()
    for (record in data) {
        gap.add("$callback|${record.id}" to record.name)

        println("${record.id} $gap")

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
        println("list: $list")

//        list.add(listOf("$callback|${record.id}" to record.name))
    }
    return list
}