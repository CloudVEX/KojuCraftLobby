package de.cloudvex.kojulobby.events

import gg.flyte.twilight.event.event
import org.bukkit.event.entity.EntityDamageEvent

object DamageListener {
    init {
        event<EntityDamageEvent> {
            isCancelled = true
        }
    }
}