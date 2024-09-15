package moddedmite.xylose.mitemod.fancytoys;

import fi.dy.masa.malilib.config.ConfigManager;
import net.fabricmc.api.ModInitializer;

public class FancyToys implements ModInitializer {
    @Override
    public void onInitialize() {
        FTConfigs.getInstance().load();
        ConfigManager.getInstance().registerConfig(FTConfigs.getInstance());
    }
}
