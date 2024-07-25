package br.com.kassin.entity;

import br.com.kassin.Main;
import br.com.kassin.aura.Aura;
import br.com.kassin.aura.AuraType;
import br.com.kassin.aura.MurdersCounter;
import br.com.kassin.utils.MessageUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public final class EntityKillsManager implements EntityKillManager {

    private final Aura aura;
    private final MurdersCounter murdersCounter;
    private static EntityKillsManager entityKillsManager;
    private final Player player;

    private EntityKillsManager(Player player) {
        this.player = player;
        this.aura = new Aura(player);
        this.murdersCounter = new MurdersCounter(player);
    }

    public static EntityKillsManager getInstance(Player player) {
        if (entityKillsManager == null) {
            entityKillsManager = new EntityKillsManager(player);
        }
        return entityKillsManager;
    }

    @Override
    public void add(EntityType entityType) {
        murdersCounter.incrementKill(entityType);
        MessageUtils.send(player, "&aEntidade morta: &f" + entityType + " &afoi adicionada a config");
    }

    @Override
    public void remove(EntityType entityType, int amount) {

    }

    @Override
    public void clear(EntityType entityType) {

    }

    @Override
    public void updateAura(AuraType auraType) {
        aura.addAura(auraType);
        MessageUtils.send(player, "&aNova Aura desbloqueada: &6" + auraType);
    }

    @Override
    public boolean enteredForTheFirstTime() {
        return !Main.getInstance().getConfig().contains("Players." + player.getName() + ".AuraType");
    }

}
