package net.reforge;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class Maintenance implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        
        FileConfiguration config = ReforgeLobbySystem.getPlugin(ReforgeLobbySystem.class).getConfig();
        boolean maintenance = (boolean) config.get("maintenance");
        String maintenance_message = (String) config.get("maintenance_message");


        if(!maintenance) {
            config.set("maintenance", true);
            ReforgeLobbySystem.getPlugin(ReforgeLobbySystem.class).saveDefaultConfig();
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§f[§aLobbysystem§f]","§aMaintenance wurde aktiviert §c!!!");
                if(!all.hasPermission("reforge.maintenance"))
                    all.kickPlayer(maintenance_message);
            }


        } else {
            config.set("maintenance", false);
            ReforgeLobbySystem.getPlugin(ReforgeLobbySystem.class).saveDefaultConfig();
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§f[§aLobbysystem§f]","§aMaintenance wurde deaktiviert §c!!!");
            }
        }


        return true;
    }
}
