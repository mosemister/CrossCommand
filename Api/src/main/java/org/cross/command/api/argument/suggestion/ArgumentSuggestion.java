package org.cross.command.api.argument.suggestion;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ArgumentSuggestion {

    @Nullable
    @CheckReturnValue
    Component tooltip();

    @NotNull
    @CheckReturnValue
    String suggestion();
}
