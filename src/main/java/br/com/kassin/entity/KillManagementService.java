package br.com.kassin.entity;

import br.com.kassin.aura.AuraType;
import org.bukkit.entity.EntityType;

public interface KillManagementService {

    void add(EntityType entityType);

    void remove(EntityType entityType, int amount);

    void clear(EntityType entityType);

    void applyAura(AuraType auraType);

    boolean enteredForTheFirstTime();

}
