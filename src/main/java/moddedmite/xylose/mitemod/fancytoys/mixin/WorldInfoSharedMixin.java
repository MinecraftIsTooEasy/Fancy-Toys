package moddedmite.xylose.mitemod.fancytoys.mixin;

import net.minecraft.NBTTagCompound;
import net.minecraft.WorldInfoShared;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldInfoShared.class)
public class WorldInfoSharedMixin {
    @Shadow
    public boolean is_valid_MITE_world = true;

    @Inject(method = "<init>(Lnet/minecraft/NBTTagCompound;)V", at = @At("RETURN"))
    private void init(NBTTagCompound par1NBTTagCompound, CallbackInfo ci) {
        this.is_valid_MITE_world = true;
    }
}
