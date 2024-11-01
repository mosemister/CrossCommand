package org.cross.command.brig.command.executable;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandExecutor;
import org.cross.command.api.execution.exception.CommandException;
import org.cross.command.api.source.CommandSource;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.argument.BrigadierCommandArgument;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExecutableCommand<Src> implements BrigadierCrossCommand<Src> {

    private BrigadierCrossCommandManager<Src, ?, ?> commandManager;
    private CommandExecutor executor;
    private final List<Map.Entry<List<String>, CommandArgument<?>>> arguments;

    public ExecutableCommand(ExecutableCommandBuilder builder) {
        this.executor = builder.executor();
        this.arguments = builder
                .arguments()
                .stream()
                .map(entry -> Map.<List<String>, CommandArgument<?>>entry(entry.getKey(), entry.getValue().build()))
                .toList();
    }

    @Override
    public boolean canRegister(@NotNull CommandSource source) {
        return true;
    }

    @Override
    public @UnmodifiableView @NotNull List<Map.Entry<List<String>, CommandArgument<?>>> arguments() {
        return this.arguments;
    }

    @Override
    public void execute(@NotNull CommandContextImmutable context) throws CommandException, Throwable {
        this.executor.execute(context);
    }

    @Override
    public LiteralArgumentBuilder<Src> apply(LiteralArgumentBuilder<Src> builder) {
        var arguments = this.arguments();
        List<ArgumentBuilder<Src, ?>> previous = new ArrayList<>();
        for(int i = arguments.size() - 1; i > 0; i--){
            var entry = arguments.get(i);
            var argument = (BrigadierCommandArgument<Src, ?>) entry.getValue();
            var newArguments = entry
                    .getKey()
                    .stream()
                    .map(argument::buildBrigadier)
                    .peek(newBuilder -> previous.forEach(newBuilder::then))
                    .toList();
            previous.clear();
            previous.addAll(newArguments);
        }
        return builder;




        for (var entry : arguments()) {
            var alias = entry.getKey().get(0);
            BrigadierCommandArgument<Src, ?> argument = (BrigadierCommandArgument<Src, ?>) entry.getValue();
            builder = builder.then(argument.buildBrigadier(alias));
        }

        return builder;
    }
}
