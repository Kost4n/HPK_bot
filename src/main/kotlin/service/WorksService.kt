package service

import dto.Work

interface WorksService {
    /** Получение списка работ по категории */
    fun getProgrammerWorks(): List<Work>
    fun getMechanicWorks(): List<Work>
    fun getWoodworkerWorks(): List<Work>
    fun getBuilderWorks(): List<Work>
    fun getLawyerWorks(): List<Work>
    fun getAccountantWorks(): List<Work>
    fun getSchoolWorks(): List<Work>
    fun getFirstyearWorks(): List<Work>

    /** Получение списка ИМЁН работ по категории */
    fun getProgrammerNameWorks(): List<Work>
    fun getMechanicNameWorks(): List<Work>
    fun getWoodworkerNameWorks(): List<Work>
    fun getBuilderNameWorks(): List<Work>
    fun getLawyerNameWorks(): List<Work>
    fun getAccountantNameWorks(): List<Work>
    fun getSchoolNameWorks(): List<Work>
    fun getFirstyearNameWorks(): List<Work>
}