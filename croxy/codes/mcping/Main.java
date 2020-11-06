package croxy.codes.mcping;

import croxy.codes.mcping.Commands.Ping;
import net.minecraft.server.v1_16_R1.EntityPlayer;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("ping").setExecutor(new Ping());
        getLogger().info("minecraft-ping activated!");
    }

    @Override
    public void onDisable() {
        getLogger().info("minecraft-ping deactivated!");
    }

    public static int getPing(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        return entityPlayer.ping;
    }

    public static String prefix = "§8[§eminecraft-ping§8] ";
}
