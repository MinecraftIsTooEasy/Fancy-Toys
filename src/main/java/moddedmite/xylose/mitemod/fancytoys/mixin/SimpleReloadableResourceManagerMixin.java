package moddedmite.xylose.mitemod.fancytoys.mixin;

import moddedmite.xylose.mitemod.fancytoys.SimpleReloadableResourceManagerINNER1;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import net.minecraft.Minecraft;
import net.minecraft.ResourcePack;
import net.minecraft.SimpleReloadableResourceManager;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.List;

@Mixin(SimpleReloadableResourceManager.class)
public class SimpleReloadableResourceManagerMixin {
    @Shadow
    private static final Joiner joinerResourcePacks = Joiner.on(", ");

    @Overwrite
    public void reloadResources(List par1List) {
        this.clearResources();
        Minecraft.getMinecraft().getLogAgent().logInfo("Reloading ResourceManager: " + joinerResourcePacks.join(Iterables.transform(par1List, new SimpleReloadableResourceManagerINNER1(ReflectHelper.dyCast(this)))));
        Iterator var2 = par1List.iterator();

        while (var2.hasNext()) {
            ResourcePack var3 = (ResourcePack) var2.next();
            this.reloadResourcePack(var3);
        }

        this.notifyReloadListeners();
    }

    @Shadow
    public void reloadResourcePack(ResourcePack par1ResourcePack) {}
    @Shadow
    private void clearResources() {}
    @Shadow
    private void notifyReloadListeners() {}
}
