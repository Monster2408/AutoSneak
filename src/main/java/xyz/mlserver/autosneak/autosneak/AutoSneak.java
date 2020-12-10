package xyz.mlserver.autosneak.autosneak;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class AutoSneak extends JavaPlugin implements CommandExecutor, Listener {

    private List<Player> sneakers = new ArrayList();
    private List<Player> naturalSneakers = new ArrayList();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("autosneak")) {
            if (args.length < 2) {
                return false;
            } else {
                Player player = Bukkit.getPlayer(args[1]);
                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "指定されたプレイヤーは存在しません。");
                    return true;
                } else {
                    if (args[0].equals("off")) {
                        this.setSneakStatus(player, false);
                    } else {
                        if (!args[0].equals("on")) {
                            return false;
                        }
                        this.setSneakStatus(player, true);
                    }
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public void setSneakStatus(Player player, boolean isSneaking) {
        if (isSneaking) {
            if (!this.sneakers.contains(player)) {
                this.sneakers.add(player);
            }
        } else if (this.sneakers.contains(player)) {
            this.sneakers.remove(player);
        }

        if (!this.naturalSneakers.contains(player)) {
            player.setSneaking(isSneaking);
        }

    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if (event.isSneaking()) {
            this.naturalSneakers.add(event.getPlayer());
        } else {
            this.naturalSneakers.remove(event.getPlayer());
        }

        if (this.sneakers.contains(event.getPlayer()) && !event.isSneaking()) {
            event.setCancelled(true);
        }
    }

    public AutoSneak() {
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {
    }
}
