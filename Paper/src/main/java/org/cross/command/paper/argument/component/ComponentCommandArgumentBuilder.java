package org.cross.command.paper.argument.component;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public class ComponentCommandArgumentBuilder implements CommandArgumentBuilder<CommandSourceStack, CommandSender> {

    private boolean isOptional;

    @Override
    public @NotNull ComponentCommandArgument build() {
        return new ComponentCommandArgument(this);
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }

    @Override
    public @NotNull ComponentCommandArgumentBuilder setOptional(boolean optional) {
        this.isOptional = optional;
        return this;
    }
}
