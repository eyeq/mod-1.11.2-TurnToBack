package eyeq.turntoback.event;

import eyeq.turntoback.TurnToBack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class TurnToBackEventHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if(minecraft.currentScreen != null) {
            return;
        }
        if(TurnToBack.turnKey.isPressed()) {
            EntityPlayerSP player = minecraft.player;
            player.rotationYaw += 180;
            player.rotationYaw %= 360;
        }
    }
}
