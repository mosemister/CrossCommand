package org.cross.command.brig.command.executable;

import org.cross.command.api.CrossCommand;
import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.NotNull;

public class ExecutableCommandBuilder implements CrossCommandBuilder.Executable {

    @Override
    public @NotNull CrossCommand build() {
        return null;
    }

    @Override
    public @NotNull CrossCommandBuilder setExecutor(@NotNull CommandExecutor executor) {
        return null;
    }
}
