package org.cross.command.api.source;

import org.cross.command.api.transform.Transformable;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface Permissible extends Transformable {

    @CheckReturnValue
    boolean hasPermission(@NotNull String permission);
}
