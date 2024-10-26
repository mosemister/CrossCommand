package org.cross.command.api;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CrossCommandBuilder {

    @NotNull
    @CheckReturnValue
    CrossCommand build();

    interface Executable extends CrossCommandBuilder {

        @NotNull
        @CheckReturnValue
        CrossCommandBuilder setExecutor(@NotNull CommandExecutor executor);

        @NotNull
        @CheckReturnValue
        List<Map.Entry<List<String>, CommandArgumentBuilder>> arguments();

        @NotNull
        @CheckReturnValue
        CrossCommandBuilder addArgument(@NotNull CommandArgumentBuilder argument, @NotNull String name, @NotNull Collection<String> alias);

        @NotNull
        @CheckReturnValue
        default CrossCommandBuilder addArgument(@NotNull CommandArgumentBuilder argument, @NotNull String name, @NotNull String... alias) {
            return addArgument(argument, name, List.of(alias));
        }
    }


    interface Base {

        @NotNull
        @CheckReturnValue
        Executable executable();
    }
}
