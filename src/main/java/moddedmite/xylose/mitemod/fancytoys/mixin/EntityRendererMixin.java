package moddedmite.xylose.mitemod.fancytoys.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Shadow private Minecraft mc;
    @WrapOperation(method = "addRainParticles", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldClient;playSound(DDDLjava/lang/String;FFZ)V"))
    private void modifyRainSound(WorldClient instance, double v, double par1, double par3, String par5, float par7Str, float par8, boolean par9, Operation<Void> original) {
        this.mc.theWorld.playSound(v, par1, par3, par5, (float) (FTConfigs.WeatherSound.getDoubleValue() * par7Str), par8, par9);
    }
}
