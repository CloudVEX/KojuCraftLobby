package de.cloudvex.kojulobby

import net.laturia.sysa.extensions.bukkit.server
import org.bukkit.Location

object Config {
    val spawnLocation = Location(
        server.getWorld("world"),
        0.0,
        -30.0,
        0.0,
        0F,
        0F,
    )
}
