package de.cloudvex.kojulobby.commands

import de.cloudvex.kojulobby.Config
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor

object LobbyCommand {
    init {
        commandTree("lobby") {
            playerExecutor { player, _ ->
                player.teleport(Config.spawnLocation)
            }
        }
    }
}