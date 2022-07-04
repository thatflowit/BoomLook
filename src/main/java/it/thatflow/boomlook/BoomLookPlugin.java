package it.thatflow.boomlook;

import it.thatflow.boomlook.config.ConfigManager;
import it.thatflow.boomlook.config.IConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BoomLookPlugin extends JavaPlugin {

    private final IConfigManager configManager = new ConfigManager(this);

    @Override
    public void onEnable() {
        configManager.loadConfig();
        getCommand("boomlook").setExecutor(new BoomCommand(configManager));
    }
}
