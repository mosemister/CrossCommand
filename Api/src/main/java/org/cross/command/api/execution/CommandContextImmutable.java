package org.cross.command.api.execution;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.ComponentLike;
import org.cross.command.api.source.CommandSource;
import org.cross.command.api.source.Permissible;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface CommandContextImmutable extends CommandContext{

    @NotNull
    @CheckReturnValue
    Permissible permissionHolder();

    @NotNull
    @CheckReturnValue
    Audience audience();

    @NotNull
    @CheckReturnValue
    CommandSource target();

    default void sendMessage(@NotNull ComponentLike componentLike) {
        audience().sendMessage(componentLike);
    }

    default boolean hasPermission(@NotNull String permission) {
        return permissionHolder().hasPermission(permission);
    }
}
