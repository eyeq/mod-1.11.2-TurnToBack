package eyeq.turntoback;

import eyeq.turntoback.event.TurnToBackEventHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import static eyeq.turntoback.TurnToBack.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class TurnToBack {
    public static final String MOD_ID = "eyeq_turntoback";

    @Mod.Instance(MOD_ID)
    public static TurnToBack instance;

    public static KeyBinding turnKey = new KeyBinding("key.turn", Keyboard.KEY_B, "TurnToBack");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TurnToBackEventHandler());
        load(new Configuration(event.getSuggestedConfigurationFile()));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(turnKey);
    }
	
    public static void load(Configuration config) {
        config.load();

        String category = "Int";
        int key = config.get(category, "key", turnKey.getKeyCode()).getInt();
        turnKey.setKeyCode(key);

        if(config.hasChanged()) {
            config.save();
        }
    }
}
