package br.com.kassin.aura;

import br.com.kassin.Main;
import lombok.Getter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@Getter
public final class MurdersCounter {

    private final Map<EntityType, Integer> map;
    private int kill = 0;
    private final Player player;

    public MurdersCounter(Player player) {
        this.player = player;
        this.map = new HashMap<>();
    }

    public Integer getKill(EntityType entityType) {
        return map.get(entityType);
    }

    public void incrementKill(EntityType entityType) {
        map.putIfAbsent(entityType, kill++);
        map.put(entityType, map.get(entityType) + kill++);

        Main.getInstance().getConfig().set("Players." + player.getName() +
                ".kills." + entityType.name(), getKill(entityType));
        Main.getInstance().getConfig().save();
    }

    public void clearKill() {
        map.clear();
        Main.getInstance().getConfig().set("Players." + player.getName() + ".kills.", null);
        Main.getInstance().getConfig().save();
    }

}
