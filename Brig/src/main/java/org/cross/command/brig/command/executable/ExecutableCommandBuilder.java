package org.cross.command.brig.command.executable;

import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExecutableCommandBuilder implements CrossCommandBuilder.Executable {

    private CommandExecutor executor;

    @Override
    public @NotNull CrossCommand build() {
        return new ExecutableCommand<>(this);
    }

    @Override
    public @NotNull CrossCommandBuilder setExecutor(@NotNull CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    @Override
    public CommandExecutor executor() {
        return this.executor;
    }

    @Override
    public @NotNull List<Map.Entry<List<String>, CommandArgumentBuilder>> arguments() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull CrossCommandBuilder addArgument(@NotNull CommandArgumentBuilder argument, @NotNull String name, @NotNull Collection<String> alias) {
        throw new RuntimeException("Not implemented yet");
    }
}
