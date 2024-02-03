package service

import dto.Work

class BaseData {
    fun getListProgrammerWorks(): List<Work> {
        return listOf(
            Work(
                0,
                "Пр1 вп31",
                "Краткое содержание Пр1 вп31"
            ),
            Work(
                1,
                "Пр1 тд31",
                "Краткое содержание Пр1 тд31"
            ),
            Work(
                2,
                "Пр1 про31",
                "Краткое содержание Пр1 про31"
            ),
            Work(
                3,
                "Пр1 прс31",
                "Краткое содержание Пр1 прс31"
            ),
        )
    }
}