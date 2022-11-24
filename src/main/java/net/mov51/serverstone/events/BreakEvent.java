package net.mov51.serverstone.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static net.mov51.serverstone.ServerStone.targets;

public class BreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.LEVER) {
            if (targets.contains(event.getBlock().getLocation())) {
                event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.NETHER_STAR));
                targets.remove(event.getBlock().getLocation());
                System.out.println("Removed target: " + event.getBlock().getLocation());
            }
        }
    }
}