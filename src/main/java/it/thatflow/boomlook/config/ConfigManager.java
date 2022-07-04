package it.thatflow.boomlook.config;

import it.thatflow.boomlook.BoomLookPlugin;
import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager implements IConfigManager {

    private final BoomLookPlugin plugin;

    private final File configFile;
    private FileConfiguration config;

    public ConfigManager(BoomLookPlugin plugin) {
        this.plugin = plugin;

        configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    @Override
    public void loadConfig() {
        plugin.getLogger().info("Loading config.yml...");

        if(!configFile.exists()) plugin.saveResource("config.yml", false);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    @Override
    public FileConfiguration getConfig() {
        return config;
    }
}
