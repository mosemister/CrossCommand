package org.cross.command.brig.command.executable;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandExecutor;
import org.cross.command.api.execution.exception.CommandException;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.argument.BrigadierCommandArgument;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.stream.Stream;

public class ExecutableCommand<CommandSrc, Permissible> implements BrigadierCrossCommand<CommandSrc, Permissible> {

    private final BrigadierCrossCommandManager<CommandSrc, Permissible, ?, ?> commandManager;
    private final CommandExecutor<CommandSrc, Permissible> executor;
    private final List<Map.Entry<List<String>, CommandArgument<?, CommandSrc, Permissible>>> arguments;

    public ExecutableCommand(ExecutableCommandBuilder<CommandSrc, Permissible> builder) {
        this.commandManager = builder.manager;
        this.executor = builder.executor();
        this.arguments = builder
                .arguments()
                .stream()
                .map(entry -> Map.<List<String>, CommandArgument<?, CommandSrc, Permissible>>entry(entry.getKey(), entry.getValue()))
                .toList();
    }

    @Override
    public boolean canRegister(@NotNull CommandSrc source) {
        return true;
    }

    @Override
    public @UnmodifiableView @NotNull List<Map.Entry<List<String>, CommandArgument<?, CommandSrc, Permissible>>> arguments() {
        return this.arguments;
    }

    @Override
    public void execute(@NotNull CommandContextImmutable<CommandSrc, Permissible> context) throws CommandException, Throwable {
        this.executor.execute(context);
    }

    @Override
    public Collection<LiteralArgumentBuilder<CommandSrc>> apply(LiteralArgumentBuilder<CommandSrc> builder) {
        var arguments = this.arguments();
        List<ArgumentBuilder<CommandSrc, ?>> previous = new ArrayList<>();
        for (int i = arguments.size() - 1; i >= 0; i--) {
            Map.Entry<List<String>, CommandArgument<?, CommandSrc, Permissible>> entry = arguments.get(i);
            var argument = (BrigadierCommandArgument<?, CommandSrc, Permissible>) entry.getValue();
            var newArguments = entry
                    .getKey()
                    .stream()
                    .map(argument::buildBrigadier)
                    .toList();

            var appliedNewArguments = newArguments
                    .stream()
                    .flatMap(argumentBuilder -> {
                        if (previous.isEmpty()) {
                            return Stream.of(argumentBuilder);
                        }
                        return previous
                                .stream()
                                .map(argumentBuilder::then);
                    })
                    .toList();
            previous.clear();
            previous.addAll(appliedNewArguments);
        }
        if (previous.isEmpty()) {
            return Collections.singletonList(builder.executes(buildCommand()));
        }
        final var finalBuilder = builder;
        return previous.stream().map(t -> finalBuilder.then(t).executes(buildCommand())).toList();
    }

    private Command<CommandSrc> buildCommand() {
        return commandContext -> {

            var immutableContext = commandManager.toCommandContext().toContext(commandContext, ExecutableCommand.this);
            try {
                ExecutableCommand.this.executor.execute(immutableContext);
            } catch (CommandException e) {
                System.err.println("Command Exception: " + e.getMessage());
            } catch (Throwable e) {
                e.printStackTrace();
                return 0;
            }

            return Command.SINGLE_SUCCESS;
        };
    }
}
