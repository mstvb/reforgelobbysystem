package net.reforge.manager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {

    private ItemStack itemStack;
    private ItemMeta itemMeta;


    public ItemManager(final Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }


    public ItemManager setAmount(final int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }


    public ItemManager setDisplayName(final String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }


    public ItemManager setLore(final String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }


    public ItemManager setUnbreakable(final boolean unbreakable) {
        itemMeta.setUnbreakable(unbreakable);
        return this;
    }


    public ItemManager addEnchantment(final Enchantment ench, final int lvl, final boolean active) {
        itemMeta.addEnchant(ench, lvl, active);
        return this;
    }


    public ItemManager setFlag(final ItemFlag flag) {
        itemMeta.addItemFlags(flag);
        return this;
    }


    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
