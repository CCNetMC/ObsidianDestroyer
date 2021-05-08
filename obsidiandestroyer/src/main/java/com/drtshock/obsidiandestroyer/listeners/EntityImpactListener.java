package com.drtshock.obsidiandestroyer.listeners;

import at.pavlov.cannons.event.ProjectileImpactEvent;
import at.pavlov.cannons.event.ProjectilePiercingEvent;
import com.drtshock.obsidiandestroyer.managers.ChunkManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class EntityImpactListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onProjectilePiercing(ProjectilePiercingEvent event) {
        if (event == null || ChunkManager.getInstance().getDisabledWorlds().contains(event.getImpactLocation().getWorld().getName())) {
            return; // do not do anything in case explosions get cancelled
        }

        ChunkManager.getInstance().handleCannonPiercing(event);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onProjectileImpact(ProjectileImpactEvent event) {
        if (event == null || ChunkManager.getInstance().getDisabledWorlds().contains(event.getImpactLocation().getWorld().getName())) {
            return; // do not do anything in case explosions get cancelled
        }

        ChunkManager.getInstance().handleCannonImpact(event);
    }
}
