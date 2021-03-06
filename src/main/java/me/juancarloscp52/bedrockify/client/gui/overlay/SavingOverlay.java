package me.juancarloscp52.bedrockify.client.gui.overlay;

import me.juancarloscp52.bedrockify.client.BedrockifyClient;
import me.juancarloscp52.bedrockify.client.BedrockifySettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

public class SavingOverlay extends DrawableHelper {

    private final Identifier WIDGET_TEXTURE = new Identifier("bedrockify", "textures/gui/bedrockify_widgets.png");
    private boolean saving = false;
    private long timer=0;
    private final MinecraftClient client = MinecraftClient.getInstance();

    public void render(MatrixStack matrixStack){
        final BedrockifySettings settings = BedrockifyClient.getInstance().settings;
        if(saving || System.currentTimeMillis()-timer<3000){
            client.getTextureManager().bindTexture(WIDGET_TEXTURE);
            // Draw chest
            this.drawTexture(matrixStack, client.getWindow().getScaledWidth()-(21+settings.getScreenSafeArea()), 19 + settings.getScreenSafeArea(), 0, 99, 16, 17);
            // Draw arrow
            this.drawTexture(matrixStack, client.getWindow().getScaledWidth()-(19+settings.getScreenSafeArea()), 5 + settings.getScreenSafeArea() + MathHelper.fastFloor(MathHelper.abs(MathHelper.sin((float)(Util.getMeasuringTimeMs() % 1000L) / 1000F * 3.1415926F) * 6)), 16, 99, 12, 15);
        }
    }

    public void setSaving(boolean saving) {
        if(this.saving && !saving)
            timer=System.currentTimeMillis();
        this.saving = saving;
    }
}
