package org.cross.command.paper;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.cross.command.api.execution.CommandContextMutable;
import org.jetbrains.annotations.NotNull;

public class PaperMutableCommandContext implements CommandContextMutable<CommandSourceStack, CommandSender> {

    private final PaperCommandContext context;

    public PaperMutableCommandContext(PaperCommandContext context) {
        this.context = context;
    }

    @Override
    public CommandSender permissionHolder() {
        return context.permissionHolder();
    }

    @Override
    public Audience audience() {
        return this.context.audience();
    }

    @Override
    public CommandSourceStack target() {
        return this.context.target();
    }

    @Override
    public void setTarget(@NotNull CommandSourceStack source) {

    }
}
