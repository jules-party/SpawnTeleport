package zoink.jule.spawnteleport.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zoink.jule.spawnteleport.SpawnTeleport;

public class Home implements CommandExecutor {
    private final SpawnTeleport plugin;

    public Home(SpawnTeleport plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            Location playerSpawn;

            if(args.length == 0) {
                if (player.getBedSpawnLocation() == null) {
                    player.sendMessage(ChatColor.RED+"You do not have a spawnpoint set!");
                    return true;
                } else {
                    playerSpawn = player.getBedSpawnLocation();
                }
                player.teleport(playerSpawn);
                player.sendMessage(ChatColor.YELLOW+"Teleported to Home!");
            } else if (args.length > 0) {
                player.sendMessage(ChatColor.RED+"This command doesn't take arguments!");
            }
        }

        return true;
    }
}
