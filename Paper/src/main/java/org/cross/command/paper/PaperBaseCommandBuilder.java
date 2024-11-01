package org.cross.command.paper;

import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.command.BaseCrossCommandBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public class PaperBaseCommandBuilder implements BaseCrossCommandBuilder<CommandSourceStack, CommandSender> {

    private final PaperCrossCommandManager manager;

    public PaperBaseCommandBuilder(PaperCrossCommandManager manager) {
        this.manager = manager;
    }

    @Override
    public BrigadierCrossCommandManager<CommandSourceStack, CommandSender, ?, ?> manager() {
        return this.manager;
    }
}
