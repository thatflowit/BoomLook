package it.thatflow.boomlook;

import it.thatflow.boomlook.config.IConfigManager;
import it.thatflow.boomlook.utils.Utilities;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

@RequiredArgsConstructor
public class BoomCommand implements CommandExecutor {

    private final IConfigManager configManager;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("bl.boom")) {
            sender.sendMessage(Utilities.format(configManager.getConfig().getString("dontHavePermission")));
            return true;
        }
        if(!(sender instanceof Player)) {
            sender.sendMessage(Utilities.format(configManager.getConfig().getString("onlyPlayers")));
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0) {
            Location explosionLocation = player.getTargetBlock((Set<Material>) null, 10).getLocation();
            explosionLocation.getWorld().createExplosion(explosionLocation, 10);

            player.sendMessage(Utilities.format(configManager.getConfig().getString("explosionDone")));
            return true;
        }
        player.sendMessage(Utilities.format(configManager.getConfig().getString("cmdUsage")));
        return true;
    }
}
