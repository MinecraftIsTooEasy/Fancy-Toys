package moddedmite.xylose.mitemod.fancytoys.mixin;

import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.ItemInWorldManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ItemInWorldManager.class)
public class ItemInWorldManagerMixin {

    @ModifyConstant(method = "removeBlock", constant = @Constant(intValue = 100))
    private int modifyOoze(int val) {
        return FTConfigs.Ooze.getIntegerValue();
    }
}
