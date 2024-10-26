package org.cross.command.paper;

import com.mojang.brigadier.CommandDispatcher;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.api.source.CommandSource;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.paper.argument.PaperArgumentBuilder;
import org.cross.command.paper.source.GenericCommandSource;
import org.jetbrains.annotations.NotNull;

public class PaperCrossCommandManager extends BrigadierCrossCommandManager<CommandSourceStack> {

    private Commands paperCommands;

    public PaperCrossCommandManager(Commands paperCommands) {
        this.paperCommands = paperCommands;
    }

    @Override
    protected CommandDispatcher<CommandSourceStack> dispatcher() {
        return paperCommands.getDispatcher();
    }

    @Override
    protected CommandSource toSource(CommandSourceStack source) {
        return new GenericCommandSource(this::transformManager, source.getSender());
    }

    @Override
    public @NotNull CrossCommandBuilder.Base commandBuilder() {
        return null;
    }

    @Override
    @NotNull
    public PaperArgumentBuilder argumentBuilder() {
        return new PaperArgumentBuilder();
    }
}
