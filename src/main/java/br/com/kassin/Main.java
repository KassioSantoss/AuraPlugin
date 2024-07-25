package br.com.kassin;

import br.com.kassin.utils.Config;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Getter
    private Config config;
    @Getter
    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        config = new Config(this, "config.yml");
        config.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        config.save();
    }

}
