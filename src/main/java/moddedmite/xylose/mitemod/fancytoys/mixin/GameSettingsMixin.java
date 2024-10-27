package moddedmite.xylose.mitemod.fancytoys.mixin;

import net.minecraft.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GameSettings.class, priority = 20000)
public class GameSettingsMixin {
//    @Shadow
//    public String skin;
//
//    @Inject(method = "<init>()V", at = @At("RETURN"))
//    private void DefaultMITEResourcePack_0(CallbackInfo ci) {
//        skin = "MITE Resource Pack 1.6.4";
//    }
//    @Inject(method = "<init>(Lnet/minecraft/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
//    private void DefaultMITEResourcePack_1(CallbackInfo ci) {
//        skin = "MITE Resource Pack 1.6.4";
//    }
}
