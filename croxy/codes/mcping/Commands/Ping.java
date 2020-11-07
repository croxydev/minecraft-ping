package croxy.codes.mcping.Commands;

import croxy.codes.mcping.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                int ping = Main.getPing(player);
                String status = null;
                if(ping < 99) {
                    status = "§a"+ping+"ms (Very good)";
                } else if(ping > 100 && ping < 149) {
                    status = "§6"+ping+"ms (Good)";
                } else if(ping > 150) {
                    status = "§c"+ping+"ms (Bad)";
                }
                player.sendMessage(Main.prefix+"§eYour ping§8: " + status);
            } else {
                String pName = args[0];
                Player p = Bukkit.getPlayer(pName);
                if (p != null) {
                    int ping = Main.getPing(p);
                    String status = null;
                    if(ping < 99) {
                        status = "§a"+ping+"ms (Very good)";
                    } else if(ping > 100 && ping < 149) {
                        status = "§6"+ping+"ms (Good)";
                    } else if(ping > 150) {
                        status = "§c"+ping+"ms (Bad)";
                    }
                    player.sendMessage(Main.prefix+"§e" + p.getDisplayName() + "'s §6ping§8: " + status);
                } else {
                    player.sendMessage(Main.prefix+"§cCannot find player.");
                }
            }
        } else {
            System.out.println("This command only can be executable in-game.");
        }

        return true;
    }
}
