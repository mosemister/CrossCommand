package org.cross.command.paper;

import com.mojang.brigadier.CommandDispatcher;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.paper.argument.PaperArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class PaperCrossCommandManager extends BrigadierCrossCommandManager<CommandSourceStack, CommandSender, PaperBaseCommandBuilder, PaperArgumentBuilder> {

    private final @NotNull Commands paperCommands;

    public PaperCrossCommandManager(@NotNull Commands paperCommands) {
        this.paperCommands = paperCommands;
    }

    @Override
    protected CommandDispatcher<CommandSourceStack> dispatcher() {
        return paperCommands.getDispatcher();
    }

    @Override
    public @NotNull PaperBaseCommandBuilder commandBuilder() {
        return new PaperBaseCommandBuilder(this);
    }

    @Override
    @NotNull
    public PaperArgumentBuilder argumentBuilder() {
        return new PaperArgumentBuilder();
    }
}
