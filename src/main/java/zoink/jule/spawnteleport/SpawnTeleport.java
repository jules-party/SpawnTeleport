package zoink.jule.spawnteleport;

import org.bukkit.plugin.java.JavaPlugin;
import zoink.jule.spawnteleport.commands.Home;
import zoink.jule.spawnteleport.commands.Spawn;

public final class SpawnTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("home").setExecutor(new Home(this));
    }
}
