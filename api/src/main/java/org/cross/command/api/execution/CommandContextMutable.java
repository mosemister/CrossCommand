package org.cross.command.api.execution;

import org.jetbrains.annotations.NotNull;

public interface CommandContextMutable<CommandSrc, Permissible> extends CommandContext<CommandSrc, Permissible> {

    void setTarget(@NotNull CommandSrc source);
}
