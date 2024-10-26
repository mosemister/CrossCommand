package org.cross.command.brig.argument.integer;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class IntegerCommandArgumentBuilder<Src> implements CommandArgumentBuilder.Integer {

    private boolean isOptional;
    private int max = java.lang.Integer.MAX_VALUE;
    private int min = java.lang.Integer.MIN_VALUE;

    @Override
    public Integer setMax(@Nullable java.lang.Integer max) {
        this.max = Objects.requireNonNullElse(max, java.lang.Integer.MAX_VALUE);
        return this;
    }

    @Override
    public java.lang.Integer max() {
        return this.max;
    }

    @Override
    public Integer setMin(java.lang.Integer min) {
        this.min = Objects.requireNonNullElse(min, java.lang.Integer.MIN_VALUE);
        return this;
    }

    @Override
    public java.lang.Integer min() {
        return this.min;
    }

    @Override
    public @NotNull IntegerCommandArgument<Src> build() {
        return new IntegerCommandArgument<>(this);
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }

    @Override
    public @NotNull CommandArgumentBuilder setOptional(boolean optional) {
        this.isOptional = optional;
        return this;
    }
}
