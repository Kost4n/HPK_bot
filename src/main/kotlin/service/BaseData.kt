package service

import dto.TestDto

class BaseData {
    fun getListProgrammerWorks(): List<TestDto> {
        return listOf(
            TestDto(
                0,
                "Пр1 вп31",
                "Краткое содержание Пр1 вп31"
            ),
            TestDto(
                1,
                "Пр1 тд31",
                "Краткое содержание Пр1 тд31"
            ),
            TestDto(
                2,
                "Пр1 про31",
                "Краткое содержание Пр1 про31"
            ),
            TestDto(
                3,
                "Пр1 прс31",
                "Краткое содержание Пр1 прс31"
            ),
        )
    }
}