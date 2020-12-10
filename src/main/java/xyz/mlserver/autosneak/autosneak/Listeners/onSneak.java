package xyz.mlserver.autosneak.autosneak.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import xyz.mlserver.autosneak.autosneak.Utils.Var;

public class onSneak implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        if (event.isSneaking()) {
            Var.naturalSneakers.add(event.getPlayer());
        } else {
            Var.naturalSneakers.remove(event.getPlayer());
        }

        if (Var.sneakers.contains(event.getPlayer()) && !event.isSneaking()) {
            event.setCancelled(true);
        }
    }

}
