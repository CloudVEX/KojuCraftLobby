package de.cloudvex.kojulobby.events

import gg.flyte.twilight.event.event
import org.bukkit.event.entity.PlayerDeathEvent

object DeathListener {
    init {
        event<PlayerDeathEvent> {
            isCancelled = true
        }
    }
}