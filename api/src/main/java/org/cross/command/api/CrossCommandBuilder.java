package org.cross.command.api;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CrossCommandBuilder<CommandSrc, Permissible> {

    @NotNull
    @CheckReturnValue
    CrossCommand<CommandSrc, Permissible> build();

    interface Executable<CommandSrc, Permissible> extends CrossCommandBuilder<CommandSrc, Permissible> {

        @NotNull
        @CheckReturnValue
        Executable<CommandSrc, Permissible> setExecutor(@NotNull CommandExecutor<CommandSrc, Permissible> executor);

        @CheckReturnValue
        CommandExecutor<CommandSrc, Permissible> executor();

        @NotNull
        @CheckReturnValue
        List<Map.Entry<List<String>, CommandArgumentBuilder<CommandSrc, Permissible>>> arguments();

        @NotNull
        @CheckReturnValue
        CrossCommandBuilder<CommandSrc, Permissible> addArgument(@NotNull CommandArgumentBuilder<CommandSrc, Permissible> argument, @NotNull String name, @NotNull Collection<String> alias);

        @NotNull
        @CheckReturnValue
        default CrossCommandBuilder<CommandSrc, Permissible> addArgument(@NotNull CommandArgumentBuilder<CommandSrc, Permissible> argument, @NotNull String name, @NotNull String... alias) {
            return addArgument(argument, name, List.of(alias));
        }
    }


    interface Base<CommandSrc, Permissible> {

        @NotNull
        @CheckReturnValue
        Executable<CommandSrc, Permissible> executable();
    }
}
