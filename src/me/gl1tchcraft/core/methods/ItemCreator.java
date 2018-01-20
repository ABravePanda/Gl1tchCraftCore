package me.gl1tchcraft.core.methods;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack createItem(Material material, String name, String description, int amount, ItemFlag flag) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(flag);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(description);
		meta.setLore(lore);
		item.setItemMeta(meta);

		return item;
	}
	
	public static ItemStack createSelectedWoolItem(Material material, int dataValue, String name, int amount, Enchantment enchant) {
		ItemStack item = new ItemStack(material, amount, (byte)dataValue);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(enchant, 1);

		return item;
	}
	
	public static ItemStack createWoolItem(Material material, int dataValue, String name, int amount) {
		ItemStack item = new ItemStack(material, amount, (byte)dataValue);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);

		return item;
	}
	
}
