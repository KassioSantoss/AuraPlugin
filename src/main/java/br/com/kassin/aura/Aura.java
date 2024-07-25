package br.com.kassin.aura;

import br.com.kassin.Main;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@Getter
public final class Aura {

    private final Map<AuraType, KillCounter> map;
    private final Player player;

    public Aura(final Player player) {
        this.player = player;
        this.map = new HashMap<>();
    }

    public void addAura(final AuraType auraType) {
        if (!map.isEmpty()) {
            map.clear();
        }

        map.putIfAbsent(auraType, new KillCounter(player));
        Main.getInstance().getConfig().set("Players." + player.getName() + ".AuraType", auraType);
        Main.getInstance().getConfig().save();
    }

}
