package it.thatflow.boomlook.config;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfigManager {

    void loadConfig();
    FileConfiguration getConfig();
}
