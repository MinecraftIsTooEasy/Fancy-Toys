package moddedmite.xylose.mitemod.fancytoys.mixin;

import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow public static boolean night_vision_override;
//    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;getVersionDescriptor(Z)Ljava/lang/String;"))
//    private void customGameTile(CallbackInfo ci) {
//        if (!FTConfigs.GameTitleSwitch.getBooleanValue()) {
//            Display.setTitle("Minecraft " + getVersionDescriptor(false));
//        } else {
//            FTConfigs.GameTitle.onValueChanged();
//            Display.setTitle(FTConfigs.GameTitle.getDefaultStringValue());
//        }
//    }
    @Inject(method={"inDevMode"}, at={@At(value="TAIL")})
    private static void configToDevMode(CallbackInfoReturnable<Boolean> cir) {
//        FTConfigs.NightVision.onValueChanged();
//        night_vision_override = FTConfigs.NightVision.getBooleanValue();
    }

}
