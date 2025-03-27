package dev.nelmin.discord.builder

import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import java.time.temporal.TemporalAccessor
import net.dv8tion.jda.api.EmbedBuilder as JDAEmbedBuilder

class EmbedBuilder {
    private val builder = JDAEmbedBuilder()

    // Title methods
    fun setTitle(title: String) = apply {
        builder.setTitle(title)
    }

    fun setTitle(title: String, url: String?) = apply {
        builder.setTitle(title, url)
    }

    // Description methods
    fun setDescription(description: String) = apply {
        builder.setDescription(description)
    }

    // Author methods
    fun setAuthor(name: String, url: String? = null, iconUrl: String? = null) = apply {
        builder.setAuthor(name, url, iconUrl)
    }

    // Thumbnail
    fun setThumbnail(url: String) = apply {
        builder.setThumbnail(url)
    }

    // Image
    fun setImage(url: String) = apply {
        builder.setImage(url)
    }

    // Color
    fun setColor(color: Color) = apply {
        builder.setColor(color)
    }

    // Fields
    fun addField(name: String, value: String, inline: Boolean = false) = apply {
        builder.addField(name, value, inline)
    }

    fun addBlankField(inline: Boolean = false) = apply {
        builder.addBlankField(inline)
    }

    // Footer
    fun setFooter(text: String, iconUrl: String? = null) = apply {
        builder.setFooter(text, iconUrl)
    }

    // Timestamp
    fun setTimestamp(temporal: TemporalAccessor) = apply {
        builder.setTimestamp(temporal)
    }

    // Build method
    fun build(): MessageEmbed {
        return builder.build()
    }

    // Clear method
    fun clear() = apply {
        builder.clear()
    }
}