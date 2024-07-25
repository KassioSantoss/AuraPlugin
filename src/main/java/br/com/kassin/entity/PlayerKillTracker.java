package br.com.kassin.entity;

import br.com.kassin.Main;
import br.com.kassin.aura.Aura;
import br.com.kassin.aura.AuraType;
import br.com.kassin.aura.KillCounter;
import br.com.kassin.utils.MessageUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public final class PlayerKillTracker implements KillManagementService {

    private final Aura aura;
    private final KillCounter killCounter;
    private static PlayerKillTracker entityKillsManager;
    private final Player player;

    private PlayerKillTracker(Player player) {
        this.player = player;
        this.aura = new Aura(player);
        this.killCounter = new KillCounter(player);
    }

    @Override
    public void add(EntityType entityType) {
        killCounter.incrementKill(entityType);
        MessageUtils.send(player, "&aEntidade morta: &f" + entityType + " &afoi adicionada a config");
    }

    @Override
    public void remove(EntityType entityType, int amount) {

    }

    @Override
    public void clear(EntityType entityType) {

    }

    @Override
    public void applyAura(AuraType auraType) {
        aura.addAura(auraType);
        MessageUtils.send(player, "&aNova Aura desbloqueada: &6" + auraType);
    }

    @Override
    public boolean enteredForTheFirstTime() {
        return !Main.getInstance().getConfig().contains("Players." + player.getName() + ".AuraType");
    }

    public static PlayerKillTracker getInstance(Player player) {
        if (entityKillsManager == null) {
            entityKillsManager = new PlayerKillTracker(player);
        }
        return entityKillsManager;
    }

}
