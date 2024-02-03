package service

import dto.Work

class WorksServiceImpl: WorksService {
    val list = listOf(
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
    override fun getProgrammerWorks(): List<Work> {
        return list
    }

    override fun getMechanicWorks(): List<Work> {
        return list
    }

    override fun getWoodworkerWorks(): List<Work> {
        return list
    }

    override fun getBuilderWorks(): List<Work> {
        return list
    }

    override fun getLawyerWorks(): List<Work> {
        return list
    }

    override fun getAccountantWorks(): List<Work> {
        return list
    }

    override fun getSchoolWorks(): List<Work> {
        return list
    }

    override fun getFirstyearWorks(): List<Work> {
        return list
    }

    override fun getProgrammerNameWorks(): List<Work> {
        return list
    }

    override fun getMechanicNameWorks(): List<Work> {
        return list
    }

    override fun getWoodworkerNameWorks(): List<Work> {
        return list
    }

    override fun getBuilderNameWorks(): List<Work> {
        return list
    }

    override fun getLawyerNameWorks(): List<Work> {
        return list
    }

    override fun getAccountantNameWorks(): List<Work> {
        return list
    }

    override fun getSchoolNameWorks(): List<Work> {
        return list
    }

    override fun getFirstyearNameWorks(): List<Work> {
        return list
    }
}