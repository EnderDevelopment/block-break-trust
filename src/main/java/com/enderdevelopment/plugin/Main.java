package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("BlockBreaker plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BlockBreaker plugin has been disabled!");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material blockType = event.getBlock().getType();

        if (!player.hasPermission("blockbreaker.breaktrust")) {
            if (blockType != Material.COBWEB && blockType != Material.OBSIDIAN && blockType != Material.STONE) {
                event.setCancelled(true);
                player.sendMessage("You can only break Cobwebs, Obsidian, and Stone!");
            }
        }
    }
}