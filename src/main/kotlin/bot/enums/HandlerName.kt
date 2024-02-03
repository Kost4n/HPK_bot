package bot.enums

enum class HandlerName(val text: String) {
    QUIZ_ANSWER("quiz_answer"),

    /** for Handlers */
    SELECT_BUY_OR_SELL("select_but_or_sell"),
    SELECT_CATEGORY("select_category"),

    BUY_PROGRAMMER_START_PAY("buy_programmer_start_pay"),
    BUY_MECHANIC_START_PAY("buy_mechanic_start_pay"),
    BUY_WOODWORKER_START_PAY("buy_woodworker_start_pay"),
    BUY_BUILDER_START_PAY("buy_builder_start_pay"),
    BUY_LAWYER_START_PAY("buy_lawyer_start_pay"),
    BUY_ACCOUNTANT_START_PAY("buy_accountant_start_pay"),
    BUY_SCHOOL_START_PAY("buy_school_start_pay"),
    BUY_FIRSTYEAR_START_PAY("buy_firstyear_start_pay"),

//    BUY_PROGRAMMER_END_DIALOG("buy_programmer_end_dialog"),
//    BUY_MECHANIC_END_DIALOG("buy_mechanic_end_dialog"),
//    BUY_WOODWORKER_END_DIALOG("buy_woodworker_end_dialog"),
//    BUY_BUILDER_END_DIALOG("buy_builder_end_dialog"),
//    BUY_LAWYER_END_DIALOG("buy_lawyer_end_dialog"),
//    BUY_ACCOUNTANT_END_DIALOG("buy_accountant_end_dialog"),
//    BUY_SCHOOL_END_DIALOG("buy_school_end_dialog"),
//    BUY_FIRSTYEAR_END_DIALOG("buy_firstyear_end_dialog"),

    /** for get WORKS */
    PROGRAMMER_WORKS("programmer_works"),
    MECHANIC_WORKS("mechanic_works"),
    WOODWORKER_WORKS("woodworker_works"),
    BUILDER_WORKS("builder_works"),
    LAWYER_WORKS("lawyer_works"),
    ACCOUNTANT_WORKS("accountant_works"),
    SCHOOL_WORKS("school_works"),
    FIRSTYEAR_WORKS("firsyear_works"),
}