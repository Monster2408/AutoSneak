package xyz.mlserver.autosneak.autosneak.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.mlserver.autosneak.autosneak.Utils.API.MainAPI;
import xyz.mlserver.autosneak.autosneak.Utils.Var;

import java.util.ArrayList;

public class autosneak implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (Var.sneakers == null) Var.sneakers = new ArrayList<>();
        if (Var.naturalSneakers == null) Var.naturalSneakers = new ArrayList<>();
        if (args.length < 2) {
            return false;
        } else {
            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage(ChatColor.RED + "指定されたプレイヤーは存在しません。");
                return true;
            } else {
                if (args[0].equals("off")) {
                    MainAPI.setSneakStatus(player, false);
                } else {
                    if (!args[0].equals("on")) {
                        return false;
                    }
                    MainAPI.setSneakStatus(player, true);
                }
                return true;
            }
        }
    }
}
