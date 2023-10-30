package me.teakivy.teakstweaks.utils.gui;

import me.teakivy.teakstweaks.utils.lang.Translatable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class GUIListener implements Listener {

    /**
     * Handles the GUI clicks
     * @param event InventoryClickEvent
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translatable.getLegacy("mechanics.gui.title"))) {
            event.setCancelled(true);
            if (event.getRawSlot() == 53) {
                // Next page button clicked
                PaginatedGUI.next((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 45) {
                // Previous page button clicked
                PaginatedGUI.previous((Player) event.getWhoClicked());
            }
        }
    }

    /**
     * Prevents players from interacting with the GUI
     * @param event InventoryInteractEvent
     */
    @EventHandler
    public void onInv(InventoryInteractEvent event) {
        if (event.getView().getTitle().equals("Paginated GUI")) {
            event.setCancelled(true);
        }
    }
}
