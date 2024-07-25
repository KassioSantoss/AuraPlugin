package br.com.kassin.listeners;

import br.com.kassin.aura.AuraType;
import br.com.kassin.entity.EntityKillsManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.checkerframework.checker.units.qual.A;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        Entity entity = event.getEntity();

        EntityKillsManager entityKillsManager = EntityKillsManager.getInstance(player);

        if (entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.SKELETON) {
            entityKillsManager.updateAura(AuraType.DEFAULT);
        }
    }

}
