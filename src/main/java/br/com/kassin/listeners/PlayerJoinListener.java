package br.com.kassin.listeners;

import br.com.kassin.aura.AuraType;
import br.com.kassin.entity.EntityKillsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        EntityKillsManager entityKillsManager = EntityKillsManager.getInstance(player);

        if (entityKillsManager.enteredForTheFirstTime()) {
            entityKillsManager.updateAura(AuraType.DEFAULT);
        }
    }

}
