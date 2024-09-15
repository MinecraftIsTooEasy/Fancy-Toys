package moddedmite.xylose.mitemod.fancytoys;

import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;

import java.util.ArrayList;
import java.util.List;

public class FTConfigs extends SimpleConfigs {
    public static final ConfigBoolean PlayerModel = new ConfigBoolean("玩家模型渲染", false);
    public static final ConfigInteger PlayerModelX = new ConfigInteger("玩家模型渲染横向偏移", 98, 1, 100);
    public static final ConfigInteger PlayerModelY = new ConfigInteger("玩家模型渲染纵向偏移", 14, 14, 150);
    public static final ConfigInteger PlayerModelSize = new ConfigInteger("玩家模型渲染大小", 18, 1, 100);
    public static final ConfigInteger MusicRandomDelay = new ConfigInteger("音乐随机间隔", 12000, 1, Integer.MAX_VALUE, false, "");
    public static final ConfigInteger MusicDelay = new ConfigInteger("音乐固定间隔", 12000, 1, Integer.MAX_VALUE, false, "");
    public static final ConfigInteger Ooze = new ConfigInteger("灰色史莱姆概率", 100, 1, Integer.MAX_VALUE - 1, false, "");

    private static final FTConfigs Instance;
    public static final List<ConfigBase<?>> general;
    public FTConfigs(String name, List<ConfigHotkey> hotkeys, List<?> values) {
        super(name, hotkeys, values);
    }

    static {
        general = List.of(PlayerModel, PlayerModelX, PlayerModelY, PlayerModelSize, MusicRandomDelay, MusicDelay, Ooze);
        List<ConfigBase<?>> configValues = new ArrayList<>();
        configValues.addAll(general);
        Instance = new FTConfigs("Fancy Toys", null, configValues);
    }

    public static FTConfigs getInstance() {
        return Instance;
    }
}
