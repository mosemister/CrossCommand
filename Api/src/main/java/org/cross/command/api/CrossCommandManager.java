package org.cross.command.api;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.transform.TransformManager;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface CrossCommandManager<CommandBuilder extends CrossCommandBuilder.Base, ArgumentBuilder extends CommandArgumentBuilder.Base> {

    @NotNull
    @CheckReturnValue
    TransformManager transformManager();

    @NotNull
    @CheckReturnValue
    CommandBuilder commandBuilder();

    @NotNull
    @CheckReturnValue
    ArgumentBuilder argumentBuilder();

    void register(@NotNull CrossCommand command, @NotNull String name, String... alias);

    default void register(Function<CommandBuilder, CrossCommandBuilder> commandBuilder, @NotNull String name, String... alias) {
        register(commandBuilder.apply(commandBuilder()).build(), name, alias);
    }
}
