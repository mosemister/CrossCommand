package org.cross.command.api.transform;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractTransform<From, To> implements Transform<From, To> {

    private final Class<From> from;
    private final Class<To> to;

    public AbstractTransform(@NotNull Class<From> from, @NotNull Class<To> to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public @NotNull Class<From> from() {
        return this.from;
    }

    @Override
    public @NotNull Class<To> to() {
        return this.to;
    }
}
