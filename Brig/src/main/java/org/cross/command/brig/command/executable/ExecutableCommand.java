package org.cross.command.brig.command.executable;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandManager;
import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.execution.CommandContext;
import org.cross.command.api.execution.exception.CommandException;
import org.cross.command.api.source.CommandSource;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.argument.BrigadierCommandArgument;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;

public class ExecutableCommand<Src> implements BrigadierCrossCommand<Src> {

    private BrigadierCrossCommandManager<Src> commandManager;

    @Override
    public boolean canRegister(@NotNull CommandSource source) {
        return false;
    }

    @Override
    public @UnmodifiableView @NotNull List<Map.Entry<List<String>, CommandArgument<?>>> arguments() {
        return List.of();
    }


    @Override
    public void execute(@NotNull CommandContext context) throws CommandException, Throwable {

    }

    @Override
    public LiteralArgumentBuilder<Src> apply(LiteralArgumentBuilder<Src> builder) {
        for (var entry : arguments()) {
            var alias = entry.getKey().get(0);
            BrigadierCommandArgument<Src, ?> argument = (BrigadierCommandArgument<Src, ?>) entry.getValue();
            builder = builder.then(argument.buildBrigadier(alias));
        }

        return builder;
    }
}
