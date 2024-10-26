package org.cross.command.brig;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandManager;
import org.cross.command.api.source.CommandSource;
import org.cross.command.api.transform.TransformManager;
import org.cross.command.brig.argument.BaseCommandArgumentBuilder;
import org.cross.command.brig.command.BaseCrossCommandBuilder;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BrigadierCrossCommandManager<CommandSrc> implements CrossCommandManager {

    private final TransformManager transformManager = new TransformManager();

    protected abstract CommandDispatcher<CommandSrc> dispatcher();

    protected abstract CommandSource toSource(CommandSrc source);

    @Override
    @NotNull
    public abstract BaseCommandArgumentBuilder<CommandSrc> argumentBuilder();

    @Override
    @NotNull
    public abstract BaseCrossCommandBuilder commandBuilder();

    @Override
    public @NotNull TransformManager transformManager() {
        return this.transformManager;
    }

    @Override
    public void register(@NotNull CrossCommand command, @NotNull String name, String... alias) {
        if (!(command instanceof BrigadierCrossCommand brigCommand)) {
            throw new IllegalArgumentException("Brigadier register requires a Brigadier command");
        }
        var dispatcher = dispatcher();
        List<String> aliasList = new ArrayList<>(Arrays.asList(alias));
        aliasList.add(name);
        for (String singleAlias : aliasList) {
            var cmd = brigCommand.apply(LiteralArgumentBuilder.<CommandSrc>literal(singleAlias));
            dispatcher.register(cmd);

        }
    }

}
