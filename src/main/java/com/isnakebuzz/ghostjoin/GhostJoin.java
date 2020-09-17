package com.isnakebuzz.ghostjoin;

import com.isnakebuzz.ghostjoin.Listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GhostJoin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getConsoleSender().sendMessage(String.format("Has been loaded %s with version v%s", this.getDescription().getName(), this.getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(String.format("Unloading %s with version v%s", this.getDescription().getName(), this.getDescription().getVersion()));
    }
}
