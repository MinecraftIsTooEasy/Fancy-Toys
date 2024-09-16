package moddedmite.xylose.mitemod.fancytoys.mixin;

import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.Random;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Shadow private Minecraft mc;
    @Shadow private int rendererUpdateCount;
    private Random random = new Random();
    private int rainSoundCounter;
    @Overwrite
    private void addRainParticles() {
        float var1 = this.mc.theWorld.getRainStrength(1.0f);
        boolean is_blood_moon = this.mc.theWorld.isBloodMoon24HourPeriod();
        if (!this.mc.gameSettings.isFancyGraphicsEnabled()) {
            var1 /= 2.0f;
        }
        if (var1 != 0.0f) {
            this.random.setSeed((long)this.rendererUpdateCount * 312987231L);
            EntityLivingBase var2 = this.mc.renderViewEntity;
            WorldClient var3 = this.mc.theWorld;
            int var4 = MathHelper.floor_double(var2.posX);
            int var5 = MathHelper.floor_double(var2.posY);
            int var6 = MathHelper.floor_double(var2.posZ);
            int var7 = 10;
            double var8 = 0.0;
            double var10 = 0.0;
            double var12 = 0.0;
            int var14 = 0;
            int var15 = (int)(100.0f * var1 * var1);
            if (this.mc.gameSettings.particleSetting == 1) {
                var15 >>= 1;
            } else if (this.mc.gameSettings.particleSetting == 2) {
                var15 = 0;
            }
            int index = Minecraft.getThreadIndex();
            for (int var16 = 0; var16 < var15; ++var16) {
                double pos_y;
                int var17 = var4 + this.random.nextInt(var7) - this.random.nextInt(var7);
                int var18 = var6 + this.random.nextInt(var7) - this.random.nextInt(var7);
                int var19 = var3.getPrecipitationHeight(var17, var18);
                int var20 = var3.getBlockId(var17, var19 - 1, var18);
                BiomeGenBase var21 = var3.getBiomeGenForCoords(var17, var18);
                if (var19 > var5 + var7 || var19 < var5 - var7 || !var21.canSpawnLightningBolt(is_blood_moon) || !(var21.getFloatTemperature() >= 0.2f) || var20 <= 0) continue;
                float var22 = this.random.nextFloat();
                float var23 = this.random.nextFloat();
                Block block = Block.getBlock(var20);
                if (block.blockMaterial == Material.lava) {
                    pos_y = (float)var19 - BlockFluid.getFluidHeightPercent(this.mc.theWorld.getBlockMetadata(var17, var19 - 1, var18)) + 0.1f + 0.125f;
                    this.mc.effectRenderer.addEffect(new EntitySmokeFX(var3, (float)var17 + var22, pos_y, (float)var18 + var23, 0.0, 0.0, 0.0));
                    continue;
                }
                if (block.blockMaterial.isLiquid()) {
                    pos_y = (float)var19 - BlockFluid.getFluidHeightPercent(this.mc.theWorld.getBlockMetadata(var17, var19 - 1, var18)) + 0.1f + 0.125f;
                } else if (block.isAlwaysStandardFormCube()) {
                    pos_y = (float)var19 + 0.1f;
                } else {
                    if (block instanceof BlockTrapDoor && BlockTrapDoor.isTrapdoorOpen(this.mc.theWorld.getBlockMetadata(var17, var19 - 1, var18))) continue;
                    block.setBlockBoundsBasedOnStateAndNeighbors(this.mc.theWorld, var17, var19 - 1, var18);
                    pos_y = (double)(var19 - 1) + block.getBlockBoundsMaxY(index) + (double)0.1f;
                }
                if (this.random.nextInt(++var14) == 0) {
                    var8 = (float)var17 + var22;
                    var10 = (double)((float)var19 + 0.1f) - Block.blocksList[var20].getBlockBoundsMinY(index);
                    var12 = (float)var18 + var23;
                }
                this.mc.effectRenderer.addEffect(new EntityRainFX(var3, (float)var17 + var22, pos_y, (float)var18 + var23));
            }
            boolean player_is_outdoors = this.mc.thePlayer.isOutdoors();
            float sleep_factor = 1.0f - (float)this.mc.thePlayer.falling_asleep_counter / 50.0f;
            float distance_from_rain_factor = (float)Math.pow(this.mc.raining_strength_for_render_view_entity, 4.0);
            if (sleep_factor < 0.0f) {
                sleep_factor = 0.0f;
            }
            if (var14 > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (var10 > var2.posY + 1.0 && var3.getPrecipitationHeight(MathHelper.floor_double(var2.posX), MathHelper.floor_double(var2.posZ)) > MathHelper.floor_double(var2.posY)) {
                    if (player_is_outdoors) {
                        this.mc.theWorld.playSound(var8, var10, var12, "ambient.weather.rain", (float) (FTConfigs.WeatherSound.getDoubleValue() * (0.1f * sleep_factor * distance_from_rain_factor)), 0.5f, false);
                    } else {
                        this.mc.theWorld.playSound(var8, var10, var12, "ambient.weather.rain", (float) (FTConfigs.WeatherSound.getDoubleValue() * (0.025f * sleep_factor * distance_from_rain_factor)), 0.125f, false);
                    }
                } else if (player_is_outdoors) {
                    this.mc.theWorld.playSound(var8, var10, var12, "ambient.weather.rain", (float) (FTConfigs.WeatherSound.getDoubleValue() * (0.2f * sleep_factor * distance_from_rain_factor)), 1.0f, false);
                } else {
                    this.mc.theWorld.playSound(var8, var10, var12, "ambient.weather.rain", (float) (FTConfigs.WeatherSound.getDoubleValue() * (0.05f * sleep_factor * distance_from_rain_factor)), 0.25f, false);
                }
            }
        }
    }
}
