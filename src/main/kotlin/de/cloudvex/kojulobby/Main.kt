package de.cloudvex.kojulobby

import de.cloudvex.kojulobby.commands.LobbyCommand
import de.cloudvex.kojulobby.events.*
import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import gg.flyte.twilight.Twilight
import gg.flyte.twilight.twilight
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    companion object {
        lateinit var INSTANCE: JavaPlugin
        lateinit var twilight: Twilight
    }

    override fun onLoad() {
        INSTANCE = this
        CommandAPI.onLoad(CommandAPIBukkitConfig(this).verboseOutput(true))

        LobbyCommand
    }

    override fun onEnable() {
        twilight = twilight(this)
        CommandAPI.onEnable()

        PlayerInteractListener
        JoinListener
        DamageListener
        DeathListener
        ProjectileListener
    }

    override fun onDisable() {
        CommandAPI.onDisable()
    }
}
val PluginManager by lazy { Main.INSTANCE }