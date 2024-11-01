package org.cross.command.api.argument.suggestion;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleArgumentSuggestion implements ArgumentSuggestion {

    private final @Nullable Component tooltip;
    private final @NotNull String suggestion;

    public SimpleArgumentSuggestion(@NotNull String suggestion) {
        this(suggestion, null);
    }

    public SimpleArgumentSuggestion(@NotNull String suggestion, @Nullable Component tooltip) {
        this.tooltip = tooltip;
        this.suggestion = suggestion;
    }


    @Override
    public @Nullable Component tooltip() {
        return this.tooltip;
    }

    @Override
    public @NotNull String suggestion() {
        return this.suggestion;
    }

    @Override
    public int hashCode() {
        return this.suggestion.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArgumentSuggestion suggestion)) {
            return false;
        }
        return suggestion.suggestion().equals(this.suggestion);
    }
}
