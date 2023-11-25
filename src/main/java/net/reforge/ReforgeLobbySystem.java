package net.reforge;

import net.reforge.manager.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.logging.Handler;

public final class ReforgeLobbySystem extends JavaPlugin {

    public static final String PREFIX = "§8[§a•●§fReforge§8] ";
    public static PluginManager pm = Bukkit.getPluginManager();
    public static InventoryManager inventoryManager = new InventoryManager();
    public static ReforgeLobbySystem instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;


        this.getConfig().addDefault("maintenance", false);
        this.getConfig().addDefault("maintenance_message", "§a•● §fReforge Network §a●•" + "\n\n §a•● In Wartung ●•" + "\n\n§fWir arbeiten gerade an unserem Netzwerk" + "\n\n§aNeue Features | Bugfixes | Neue Welten" + "\n\n\n§fDein §a•● §fReforge Network §a●• §fTeam");
        this.getConfig().options().copyDefaults(true);
        saveConfig();


        pm.registerEvents(new LobbyListener(), getInstance());
        getCommand("maintenance").setExecutor(new Maintenance());

        for (Handler handler : Bukkit.getLogger().getHandlers()) {
            Bukkit.getServer().getLogger().removeHandler(handler);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ReforgeLobbySystem getInstance() {
        return instance;
    }

    public static InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}
