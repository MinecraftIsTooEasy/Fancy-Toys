package moddedmite.xylose.mitemod.fancytoys.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRock.class)
public class ItemRockMixin {

    @Inject(method = "onItemRightClick(Lnet/minecraft/EntityPlayer;Lnet/minecraft/ItemStack;FZ)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityPlayer;addExperience(I)V"))
    private static void fastUse(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down, CallbackInfoReturnable<Boolean> cir) {
        int xp_value = ItemRock.getExperienceValueWhenSacrificed(item_stack);
        Item item = item_stack.getItem();
        InventoryPlayer inventory = player.inventory;
        if (ctrl_is_down && player.hasHeldItem() && player.getHeldItemStack().stackSize > 1) {
            int amount = player.getHeldItemStack().stackSize;
            player.causeBreakingItemEffect(item, inventory.currentItem);
            player.getHeldItemStack().setStackSize(0);
            player.addExperience(xp_value * amount);
        }
    }

}
