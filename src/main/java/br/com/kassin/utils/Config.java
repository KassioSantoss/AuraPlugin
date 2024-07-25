package br.com.kassin.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class Config extends YamlConfiguration {
    private String name;
    private File file;
    private Plugin plugin;

    public Config(Plugin plugin, String name) {
        file = new File((this.plugin = plugin).getDataFolder(), this.name = name);
    }

    public void save() {
        try {
            save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reload() {
        try {
            load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDefaultConfig() {
        plugin.saveResource(name, false);
        reload();
    }

}
