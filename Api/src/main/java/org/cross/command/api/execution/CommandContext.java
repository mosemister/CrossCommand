package org.cross.command.api.execution;

import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.CheckReturnValue;

public interface CommandContext<CommandSrc, Permissible> {

    @CheckReturnValue
    Permissible permissionHolder();

    @CheckReturnValue
    Audience audience();

    @CheckReturnValue
    CommandSrc target();
}
