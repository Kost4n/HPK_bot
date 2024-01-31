package bot

import bot.api.HPKBot
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.logging.Logger

@SpringBootApplication
open class HpkBotApplication  {

    companion object {
            val LOG = Logger.getLogger(HPKBot::class.java.name)

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(HpkBotApplication::class.java, *args)
        }
    }

}

fun main(args: Array<String>) {
//    SpringApplication.run(HpkBotApplication::class.java, *args)
    runApplication<HpkBotApplication>(*args)
}