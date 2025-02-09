package de.cloudvex.kojulobby.events

import de.cloudvex.kojulobby.Config
import gg.flyte.twilight.event.event
import gg.flyte.twilight.gui.GUI.Companion.openInventory
import gg.flyte.twilight.gui.gui
import net.kyori.adventure.text.Component
import net.laturia.sysa.components.cmp
import net.laturia.sysa.extensions.bukkit.clickEvent
import net.laturia.sysa.extensions.kotlin.deserialize
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack

object JoinListener {
    init {
        event<PlayerJoinEvent> {
            player.health = 20.0
            player.foodLevel = 20
            player.inventory.clear()
            run {
                player.teleport(Config.spawnLocation)
            }

            player.inventory.apply {
                setItem(3, ItemStack(Material.COMPASS).apply {
                    editMeta { meta ->
                        meta.displayName("<!italic><gray>Compass".deserialize())
                    }
                }.clickEvent {
                    player.openInventory(gui("".deserialize()) {
                        pattern(
                            "#########",
                            "##C#S#K##",
                            "#########"
                        )

                        set('#', ItemStack(Material.GRAY_STAINED_GLASS_PANE).apply {
                            editMeta { meta ->
                                meta.displayName(Component.empty())
                            }
                        }) {
                            isCancelled = true
                        }
                        set('C', ItemStack(Material.BRICK).apply {
                            editMeta { meta ->
                                meta.displayName("<!italic>CityBuild".deserialize())
                            }
                        }) {
                            isCancelled = true
                        }
                        set('S', ItemStack(Material.GRASS_BLOCK).apply {
                            editMeta { meta ->
                                meta.displayName("<!italic>SMP".deserialize())
                            }
                        }) {
                            isCancelled = true
                        }
                        set('K', ItemStack(Material.DIAMOND_SWORD).apply {
                            editMeta { meta ->
                                meta.displayName("<!italic>KitPvP".deserialize())
                            }
                        }) {
                            isCancelled = true
                        }
                    })
                })

                setItem(5, ItemStack(Material.ENCHANTED_BOOK).apply {
                    editMeta { meta ->
                        meta.displayName("<!italic><gray>Infos".deserialize())
                    }
                }.clickEvent {
                    isCancelled = true
                    player.sendMessage(cmp("Infos :D"))
                })

                setItem(8, ItemStack(Material.BOW).apply {
                    editMeta { meta ->
                        meta.displayName("<!italic>Teleport Bow".deserialize())
                        meta.isUnbreakable = true
                        meta.addEnchant(Enchantment.INFINITY, 1, true)
                    }
                })
                setItem(35, ItemStack(Material.ARROW).clickEvent {
                    isCancelled = true
                })
            }
        }
    }
}