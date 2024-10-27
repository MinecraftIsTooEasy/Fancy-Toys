package moddedmite.xylose.mitemod.fancytoys.mixin;

import net.minecraft.GameSettings;
import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;getVersionDescriptor(Z)Ljava/lang/String;"))
    private void customGameTile(CallbackInfo ci) {
//        if (!FTConfigs.GameTitleSwitch.getBooleanValue()) {
//            Display.setTitle("Minecraft " + getVersionDescriptor(false));
//        } else {
//            FTConfigs.GameTitle.onValueChanged();
//            Display.setTitle(FTConfigs.GameTitle.getDefaultStringValue());
//        }
    }

}
