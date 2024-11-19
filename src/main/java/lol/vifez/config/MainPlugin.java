package lol.vifez.config;

import lol.vifez.config.config.ConfigAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

    private ConfigAPI configAPI;

    @Override
    public void onEnable() {
        configAPI = new ConfigAPI(this);
    }
}