package net.candlemc.logger

import dev.nelmin.discord.Bruno
import dev.nelmin.discord.builder.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import java.awt.Color
import java.time.Instant
import java.util.concurrent.ExecutorService

class DiscordLoggingStrategy(
    executor: ExecutorService,
    private val name: String,
    private val debug: Boolean,
    private val formats: Pair<String, String>
) : CandleLoggingStrategy(
    "info",
    "DISCORD",
    executor,
    ANSIColors.BOLD_BLUE
) {
    fun log(embed: MessageEmbed) {
        val channel: TextChannel? = Bruno.get().getTextChannelById(1)

        if (channel == null) {
            Logger.stacktrace(IllegalStateException("Log channel is null"))
            return
        }

        channel.sendMessageEmbeds(embed).queue()

        val timestamp = embed.timestamp?.toInstant()?.toEpochMilli() ?: System.currentTimeMillis()

        super.log(
            name,
            if (debug) formats.first else formats.second,
            timestamp,
            embed.description ?: "No description provided"
        )
    }

    fun log(
        title: String,
        description: String,
        url: String,
        timestamp: Instant,
        color: Int
    ) = log(
        EmbedBuilder().apply {
            setTitle(title, url)
            setDescription(description)
            setTimestamp(timestamp)
            setColor(Color(color))
        }.build()
    )
}