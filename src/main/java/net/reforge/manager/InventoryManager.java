package net.reforge.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<InventoryType, Inventory> inventoryMap = new HashMap<>();


    public InventoryManager() {
        loadInventorys();
    }


    public Inventory getInventory(final InventoryType inventoryType) {
        return inventoryMap.get(inventoryType);
    }


    public void loadInventorys() {


        { // LOBBY INVENTORY


            final Inventory lobby = Bukkit.createInventory(null, 36);
            lobby.setItem(4, new ItemManager(Material.CHEST).setDisplayName("§aMenu").setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
            lobby.setItem(8, new ItemManager(Material.IRON_PICKAXE).setDisplayName("§aProfil").setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
            inventoryMap.put(InventoryType.PLAYER, lobby);


        }


    }

}
