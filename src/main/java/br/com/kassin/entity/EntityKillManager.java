package br.com.kassin.entity;

import br.com.kassin.aura.AuraType;
import org.bukkit.entity.EntityType;

public interface EntityKillManager {

    void add(EntityType entityType);

    void remove(EntityType entityType, int amount);

    void clear(EntityType entityType);

    void updateAura(AuraType auraType);

    boolean enteredForTheFirstTime();

}
