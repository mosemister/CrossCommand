package org.cross.command.paper;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
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
    public @NotNull PaperBaseCommandBuilder commandBuilder() {
        return new PaperBaseCommandBuilder(this);
    }

    @Override
    @NotNull
    public PaperArgumentBuilder argumentBuilder() {
        return new PaperArgumentBuilder();
    }

    @Override
    protected void register(@NotNull String alias, @NotNull LiteralArgumentBuilder<CommandSourceStack> cmd) {
        paperCommands.register(cmd.build(), alias);
    }
}
