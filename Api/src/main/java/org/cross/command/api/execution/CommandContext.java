package org.cross.command.api.execution;

import net.kyori.adventure.audience.Audience;
import org.cross.command.api.source.CommandSource;
import org.cross.command.api.source.Permissible;
import org.jetbrains.annotations.CheckReturnValue;

public interface CommandContext {

    @CheckReturnValue
    Permissible permissionHolder();

    @CheckReturnValue
    Audience audience();

    @CheckReturnValue
    CommandSource target();
}
