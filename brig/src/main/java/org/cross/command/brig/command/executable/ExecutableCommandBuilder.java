package org.cross.command.brig.command.executable;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.command.BrigadierCrossCommand;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExecutableCommandBuilder<CommandSrc, Permissible> implements CrossCommandBuilder.Executable<CommandSrc, Permissible> {

    private CommandExecutor<CommandSrc, Permissible> executor;
    final BrigadierCrossCommandManager<CommandSrc, Permissible, ?, ?> manager;

    public ExecutableCommandBuilder(BrigadierCrossCommandManager<CommandSrc, Permissible, ?, ?> manager) {
        this.manager = manager;
    }

    @Override
    public @NotNull CrossCommand<CommandSrc, Permissible> build() {
        return new ExecutableCommand<>(this);
    }

    @Override
    public @NotNull ExecutableCommandBuilder<CommandSrc, Permissible> setExecutor(@NotNull CommandExecutor<CommandSrc, Permissible> executor) {
        this.executor = executor;
        return this;
    }

    @Override
    public CommandExecutor<CommandSrc, Permissible> executor() {
        return this.executor;
    }

    @Override
    public @NotNull List<Map.Entry<List<String>, CommandArgumentBuilder<CommandSrc, Permissible>>> arguments() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull CrossCommandBuilder<CommandSrc, Permissible> addArgument(@NotNull CommandArgumentBuilder<CommandSrc, Permissible> argument, @NotNull String name, @NotNull Collection<String> alias) {
        throw new RuntimeException("Not implemented yet");
    }
}
