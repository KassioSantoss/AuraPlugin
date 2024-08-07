package br.com.kassin.listeners;

import br.com.kassin.aura.AuraType;
import br.com.kassin.entity.PlayerKillTracker;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.checkerframework.checker.units.qual.A;

public final class EntityDeathListener implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Entity entity = event.getEntity();

        PlayerKillTracker entityKillsManager = PlayerKillTracker.getInstance(player);

        if (entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.SKELETON) {
            entityKillsManager.applyAura(AuraType.DEFAULT);
        }
    }

}
