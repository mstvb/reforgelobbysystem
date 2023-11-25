package net.reforge;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;

public class LobbyListener implements Listener {


    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(!e.getPlayer().hasPermission("reforge.place"))
            e.setCancelled(true);
        e.getPlayer().sendMessage(ReforgeLobbySystem.PREFIX + "§aDu kannst hier keine Blöcke platzieren §c!!!");
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(!e.getPlayer().hasPermission("reforge.break"))
            e.setCancelled(true);
        e.getPlayer().sendMessage(ReforgeLobbySystem.PREFIX + "§aDu kannst hier keine Blöcke abbauen §c!!!");
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {


        e.setJoinMessage(null);
        FileConfiguration config = ReforgeLobbySystem.getPlugin(ReforgeLobbySystem.class).getConfig();
        boolean maintenance = (boolean) config.get("maintenance");
        String maintenance_message = (String) config.get("maintenance_message");


        if(maintenance) {
            if(!e.getPlayer().hasPermission("reforge.maintenance"))
                e.getPlayer().kickPlayer(maintenance_message);
        }


        // MESSAGE + TITLE
        e.getPlayer().sendTitle("§a•●§fReforge", "§aWillkommen, §c" + e.getPlayer().getName());
        e.getPlayer().sendMessage(ReforgeLobbySystem.PREFIX + "§aWillkommen, §c" + e.getPlayer().getName());


        // INV
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setContents(ReforgeLobbySystem.getInventoryManager().getInventory(InventoryType.PLAYER).getContents());

    }
}
