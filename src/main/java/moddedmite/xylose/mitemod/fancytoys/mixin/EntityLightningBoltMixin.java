package moddedmite.xylose.mitemod.fancytoys.mixin;

import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.EntityLightningBolt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityLightningBolt.class)
public class EntityLightningBoltMixin {
    @ModifyConstant(method = "onUpdate", constant = @Constant(floatValue = 10000.0f))
    private float modifyLightningBoltSound(float constant) {
        return (float) (FTConfigs.WeatherSound.getDoubleValue() * constant);
    }
    @ModifyConstant(method = "onUpdate", constant = @Constant(floatValue = 2.0f))
    private float modifyLightningBoltSound1(float constant) {
        return (float) (FTConfigs.WeatherSound.getDoubleValue() * constant);
    }
}
