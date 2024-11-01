package org.test.plugin.paper;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.cross.command.paper.PaperCrossCommandManager;

public class CrossCommandPaperPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            var commands = event.registrar();
            var commandManager = new PaperCrossCommandManager(commands);

            //test basic execution
            commandManager.register(builder -> builder.executable().setExecutor(context -> context.audience().sendMessage(Component.text("world"))), "hello");

            //test argument
            var oneToHundredArgument = commandManager.argumentBuilder().integerType().setMin(0).setMax(5).build();
            commandManager.register(builder -> builder
                    .executable()
                    .addArgument(oneToHundredArgument, "number")
                    .setExecutor(context -> {
                        var number = context.argumentResult(oneToHundredArgument);
                        context.audience().sendMessage(Component.text("Found: " + number));
                    }), "showNumber");
        });
    }
}
