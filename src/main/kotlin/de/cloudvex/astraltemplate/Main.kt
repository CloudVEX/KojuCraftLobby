package de.cloudvex.astraltemplate

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.CommandExecutor
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

        CommandAPICommand("ping")
            .executes(CommandExecutor { sender, _ ->
                sender.sendMessage("pong!")
            }).register()
    }

    override fun onEnable() {
        twilight = twilight(this)
        CommandAPI.onEnable()
    }

    override fun onDisable() {
        CommandAPI.onDisable()
    }
}
val PluginManager by lazy { Main.INSTANCE }