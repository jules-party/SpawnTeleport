package zoink.jule.spawnteleport.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zoink.jule.spawnteleport.SpawnTeleport;


public class Spawn implements CommandExecutor {
    private final SpawnTeleport plugin;

    public Spawn(SpawnTeleport plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = Bukkit.getWorld(plugin.getConfig().getString("spawn.world"));
            if (args.length == 0) {
                double[] spawnCords = {
                        plugin.getConfig().getDouble("spawn.x"), // The X Coordinate of Spawn
                        plugin.getConfig().getDouble("spawn.y"), // The Y Coordinate of Spawn
                        plugin.getConfig().getDouble("spawn.z")  // The Z Coordinate of Spawn
                };

                Location spawnLocation = new Location(world,
                        spawnCords[0], // X coordinate
                        spawnCords[1], // Y coordinate
                        spawnCords[2]  // Z coordinate
                );
                player.teleport(spawnLocation);
                player.sendMessage(ChatColor.YELLOW+"Teleported to Spawn!");
            } else if (args.length > 0) {
                player.sendMessage(ChatColor.RED+"This command doesn't take arguments!");
            }

        }
        return true;
    }
}
