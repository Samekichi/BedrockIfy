package me.juancarloscp52.bedrockify.client.mixin;

import me.juancarloscp52.bedrockify.client.gui.BedrockifyOptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {

    protected OptionsScreenMixin(Text title) {
        super(title);
    }

    /**
     * Add bedrockify settings button to the game options screen.
     */
    @Inject(method = "init", at = @At("HEAD"))
    private void addBedrockifyOption(CallbackInfo info) {
        this.addButton(new ButtonWidget(this.width / 2 - 155, this.height / 6 + 145 - 6, 310, 20, new TranslatableText("bedrockify.options.settings"), (buttonWidget) -> this.client.openScreen(new BedrockifyOptionsScreen(this))));
    }
}
