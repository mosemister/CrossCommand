package org.cross.command.paper.argument.component;

import net.kyori.adventure.text.Component;
import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.argument.CommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class ComponentCommandArgumentBuilder implements CommandArgumentBuilder {

    private boolean isOptional;

    @Override
    public @NotNull ComponentCommandArgument build() {
        return new ComponentCommandArgument();
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }

    @Override
    public @NotNull CommandArgumentBuilder setOptional(boolean optional) {
        this.isOptional = optional;
        return this;
    }
}
