package org.cross.command.api;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface CrossCommandBuilder {

    interface Executable extends CrossCommandBuilder {

        @NotNull
        @CheckReturnValue
        CrossCommandBuilder setExecutor(@NotNull CommandExecutor executor);

        @NotNull
        @CheckReturnValue
        List<Map.Entry<List<String>, CommandArgumentBuilder>> arguments();

        @NotNull
        @CheckReturnValue
        CrossCommandBuilder addArgument();
    }

    interface Base extends CrossCommandBuilder {

        @NotNull
        @CheckReturnValue
        Executable executable();
    }



    @NotNull
    @CheckReturnValue
    CrossCommand build();
}
