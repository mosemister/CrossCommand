package org.cross.command.paper.argument;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.cross.command.brig.argument.BaseCommandArgumentBuilder;
import org.cross.command.paper.argument.component.ComponentCommandArgumentBuilder;

public class PaperArgumentBuilder implements BaseCommandArgumentBuilder<CommandSourceStack> {

    public ComponentCommandArgumentBuilder component() {
        return new ComponentCommandArgumentBuilder();
    }
}