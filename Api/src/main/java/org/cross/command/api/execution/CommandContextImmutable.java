package org.cross.command.api.execution;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface CommandContextImmutable<CommandSrc, Permissible> extends CommandContext<CommandSrc, Permissible> {

    @NotNull
    @CheckReturnValue
    Permissible permissionHolder();

    @NotNull
    @CheckReturnValue
    Audience audience();

    @NotNull
    @CheckReturnValue
    CommandSrc target();

    default void sendMessage(@NotNull ComponentLike componentLike) {
        audience().sendMessage(componentLike);
    }
}
