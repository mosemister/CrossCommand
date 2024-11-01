package org.cross.command.brig.command;

import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.brig.BrigadierCrossCommandManager;
import org.cross.command.brig.command.executable.ExecutableCommandBuilder;
import org.jetbrains.annotations.NotNull;

public interface BaseCrossCommandBuilder<CommandSrc, Permissible> extends CrossCommandBuilder.Base<CommandSrc, Permissible> {

    BrigadierCrossCommandManager<CommandSrc, Permissible, ?, ?> manager();

    @Override
    default @NotNull ExecutableCommandBuilder<CommandSrc, Permissible> executable() {
        return new ExecutableCommandBuilder<>(manager());
    }
}
