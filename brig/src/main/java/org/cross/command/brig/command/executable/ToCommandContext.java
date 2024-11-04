package org.cross.command.brig.command.executable;

import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandContextMutable;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface ToCommandContext<CommandSrc, Permissible> {

    @NotNull
    @CheckReturnValue
    CommandContextImmutable<CommandSrc, Permissible> toContext(@NotNull com.mojang.brigadier.context.CommandContext<CommandSrc> context, @NotNull ExecutableCommand<CommandSrc, Permissible> cmd);
}
