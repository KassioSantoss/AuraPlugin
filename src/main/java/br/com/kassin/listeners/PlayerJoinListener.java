package br.com.kassin.listeners;

import br.com.kassin.aura.AuraType;
import br.com.kassin.entity.PlayerKillTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        PlayerKillTracker playerKillTracker = PlayerKillTracker.getInstance(player);

        if (playerKillTracker.enteredForTheFirstTime()) {
            playerKillTracker.applyAura(AuraType.DEFAULT);
        }
    }

}
