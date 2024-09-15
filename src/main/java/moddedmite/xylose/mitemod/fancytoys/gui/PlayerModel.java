package moddedmite.xylose.mitemod.fancytoys.gui;

import moddedmite.xylose.mitemod.fancytoys.FTConfigs;
import net.minecraft.Gui;
import net.minecraft.GuiInventory;
import net.minecraft.Minecraft;
import net.minecraft.ScaledResolution;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class PlayerModel {

    public void renderPlayerModel(Gui gui, Minecraft mc) {
        Point pos = new Point(FTConfigs.PlayerModelX.getIntegerValue(), FTConfigs.PlayerModelY.getIntegerValue());
        Dimension size = this.displaySize();
        int x = (int) (size.width) * pos.x / 100;
        int y = (int) (size.height) * pos.y / 100;
        if (FTConfigs.PlayerModel.getBooleanValue()) {
            GuiInventory.func_110423_a(x, y, FTConfigs.PlayerModelSize.getIntegerValue(), 0, 0, mc.thePlayer);
            GL11.glEnable(GL11.GL_LIGHTING);
        }
    }
    private static Dimension displaySize() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        return new Dimension(res.getScaledWidth(), res.getScaledHeight());
    }
}
