package br.com.kassin.entity;

import br.com.kassin.aura.AuraType;
import org.bukkit.entity.EntityType;

public interface KillManagementService {

    void add(final EntityType entityType);

    void remove(final EntityType entityType,final int amount);

    void clear(final EntityType entityType);

    void applyAura(final AuraType auraType);

    boolean enteredForTheFirstTime();

}
