package xyz.mlserver.autosneak.autosneak;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.autosneak.autosneak.Commands.autosneak;
import xyz.mlserver.autosneak.autosneak.Listeners.onSneak;

public final class AutoSneak extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new onSneak(), this);
        getCommand("autosneak").setExecutor(new autosneak());
    }

    public void onDisable() {
    }
}
