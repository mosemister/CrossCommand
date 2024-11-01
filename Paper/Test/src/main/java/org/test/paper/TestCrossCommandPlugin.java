package org.test.paper;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.cross.command.paper.PaperCrossCommandManager;

public class TestCrossCommandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            var commands = event.registrar();
            PaperCrossCommandManager crossCommand = new PaperCrossCommandManager(commands);

            registerPingCommand(crossCommand);
        });
    }

    private void registerPingCommand(PaperCrossCommandManager crossCommandManager) {
        crossCommandManager.register((builder) -> builder.executable().setExecutor(context -> context.audience().sendMessage(Component.text("Pong"))), "ping");
    }
}
