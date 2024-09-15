package moddedmite.xylose.mitemod.fancytoys;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class FTModMenu implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return s -> FTConfigs.getInstance().getConfigScreen(s);
    }
}
