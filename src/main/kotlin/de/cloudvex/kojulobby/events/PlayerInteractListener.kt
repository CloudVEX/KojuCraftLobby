package de.cloudvex.kojulobby.events

import gg.flyte.twilight.event.event
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent

object PlayerInteractListener {
    init {
        event<PlayerInteractEvent> {
            if (player.gameMode == GameMode.CREATIVE) return@event
            if (clickedBlock == null && item?.type == Material.BOW) return@event
            isCancelled = true
        }
    }
}