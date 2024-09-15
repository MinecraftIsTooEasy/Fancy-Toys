package moddedmite.xylose.mitemod.fancytoys.mixin;

import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.GameSettings;
import net.minecraft.SoundManager;
import net.minecraft.SoundPool;
import net.minecraft.SoundPoolEntry;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.*;
import paulscode.sound.SoundSystem;

import java.util.*;

@Mixin(SoundManager.class)
public class SoundManagerMixin {

    @Shadow
    private static final String[] field_130084_a = new String[]{"ogg"};
    @Shadow
    private SoundSystem sndSystem;
    @Shadow
    private boolean loaded;
    @Mutable
    @Final
    @Shadow
    private final SoundPool soundPoolMusic;
    @Mutable
    @Final
    @Shadow
    private final GameSettings options;
    @Shadow
    private Random rand = new Random();
    @Shadow
    private int ticksBeforeMusic;
    @Shadow
    public static boolean muted;

    public SoundManagerMixin(SoundPool soundPoolMusic, GameSettings options) {
        this.soundPoolMusic = soundPoolMusic;
        this.options = options;
    }

    @Overwrite
    public void playRandomMusicIfReady() {
        if (!Main.is_MITE_DS && !muted) {
            if (this.loaded && this.options.musicVolume != 0.0F && !this.sndSystem.playing("BgMusic") && !this.sndSystem.playing("streaming")) {
                if (this.ticksBeforeMusic > 0) {
                    --this.ticksBeforeMusic;
                } else {
                    SoundPoolEntry var1 = this.soundPoolMusic.getRandomSound();

                    if (var1 != null) {
                        this.ticksBeforeMusic = this.rand.nextInt(FTConfigs.MusicRandomDelay.getIntegerValue()) + (FTConfigs.MusicDelay.getIntegerValue());
                        this.sndSystem.backgroundMusic("BgMusic", var1.getSoundUrl(), var1.getSoundName(), false);
                        this.sndSystem.setVolume("BgMusic", this.options.musicVolume);
                        this.sndSystem.play("BgMusic");
                    }

                }
            }
        }
    }
}
