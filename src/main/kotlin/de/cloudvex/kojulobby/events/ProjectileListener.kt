package de.cloudvex.kojulobby.events

import gg.flyte.twilight.event.event
import net.laturia.sysa.extensions.bukkit.server
import org.bukkit.event.entity.ProjectileHitEvent

object ProjectileListener {
    init {
        event<ProjectileHitEvent> {
            entity.remove()
            val shooterUUID = entity.ownerUniqueId ?: return@event
            val shooter = server.getPlayer(shooterUUID) ?: return@event

            hitBlock?.location?.let {
                it.yaw = shooter.yaw
                it.pitch = shooter.pitch
                it.y += 1
                shooter.teleport(it)
                return@event
            }
            hitBlock?.location?.let {
                it.yaw = shooter.yaw
                it.pitch = shooter.pitch
                it.y += 1
                shooter.teleport(it)
                return@event
            }
        }
    }
}