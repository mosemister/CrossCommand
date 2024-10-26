package org.cross.command.api.execution;

import org.cross.command.api.source.CommandSource;
import org.jetbrains.annotations.NotNull;

public interface CommandContextMutable extends CommandContext {

    void setTarget(@NotNull CommandSource source);
}
