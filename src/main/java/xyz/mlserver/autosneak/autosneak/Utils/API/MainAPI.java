package xyz.mlserver.autosneak.autosneak.Utils.API;

import org.bukkit.entity.Player;
import xyz.mlserver.autosneak.autosneak.Utils.Var;

import java.util.ArrayList;

public class MainAPI {

    public static void setSneakStatus(Player player, boolean isSneaking) {
        if (Var.sneakers == null) Var.sneakers = new ArrayList<>();
        if (Var.naturalSneakers == null) Var.naturalSneakers = new ArrayList<>();
        if (isSneaking) {
            if (!Var.sneakers.contains(player)) {
                Var.sneakers.add(player);
            }
        } else Var.sneakers.remove(player);

        if (!Var.naturalSneakers.contains(player)) {
            player.setSneaking(isSneaking);
        }

    }

}
