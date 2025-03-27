package dev.nelmin.discord

import io.github.cdimascio.dotenv.dotenv
import net.candlemc.logger.Logger
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

class Bruno {
    companion object {
        private val token = dotenv()["TOKEN"]
        private lateinit var jda: JDA

        @JvmStatic
        fun main(args: Array<String>) {
            Logger.info("Starting...")
            jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.entries)
                .build()

            // Wait for JDA to be ready before registering commands
            jda.isAutoReconnect = true
            jda.awaitReady()
            Logger.info("Successfully started! (${jda.selfUser.asTag} — ${jda.selfUser.id})")
        }

        fun get(): JDA = jda
    }
}