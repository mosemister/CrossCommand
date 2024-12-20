package org.cross.command.brig;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandManager;
import org.cross.command.api.transform.TransformManager;
import org.cross.command.brig.argument.BaseCommandArgumentBuilder;
import org.cross.command.brig.command.BaseCrossCommandBuilder;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.cross.command.brig.command.executable.ToCommandContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BrigadierCrossCommandManager<CommandSrc, Permissible, CommandBuilder extends BaseCrossCommandBuilder<CommandSrc, Permissible>, ArgumentBuilder extends BaseCommandArgumentBuilder<CommandSrc, Permissible>> implements CrossCommandManager<CommandSrc, Permissible, CommandBuilder, ArgumentBuilder> {

    private final TransformManager transformManager = new TransformManager();

    protected abstract void register(@NotNull String alias, @NotNull LiteralArgumentBuilder<CommandSrc> cmd);

    public abstract ToCommandContext<CommandSrc, Permissible> toCommandContext();

    @Override
    public @NotNull TransformManager transformManager() {
        return this.transformManager;
    }

    @Override
    public void register(@NotNull CrossCommand<CommandSrc, Permissible> command, @NotNull String name, String... alias) {
        if (!(command instanceof BrigadierCrossCommand<CommandSrc, Permissible> brigCommand)) {
            throw new IllegalArgumentException("Brigadier register requires a Brigadier command");
        }
        List<String> aliasList = new ArrayList<>(Arrays.asList(alias));
        aliasList.add(name);
        for (String singleAlias : aliasList) {
            var cmds = brigCommand.apply(LiteralArgumentBuilder.<CommandSrc>literal(singleAlias));
            for (var cmd : cmds) {
                register(singleAlias, cmd);
            }
        }
    }

}
