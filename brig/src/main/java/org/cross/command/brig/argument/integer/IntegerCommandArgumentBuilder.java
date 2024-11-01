package org.cross.command.brig.argument.integer;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class IntegerCommandArgumentBuilder<CommandSrc, Permissible> implements CommandArgumentBuilder.Integer<CommandSrc, Permissible> {

    private boolean isOptional;
    private int max = java.lang.Integer.MAX_VALUE;
    private int min = java.lang.Integer.MIN_VALUE;

    @Override
    public Integer<CommandSrc, Permissible> setMax(@Nullable java.lang.Integer max) {
        this.max = Objects.requireNonNullElse(max, java.lang.Integer.MAX_VALUE);
        return this;
    }

    @Override
    public java.lang.Integer max() {
        return this.max;
    }

    @Override
    public Integer<CommandSrc, Permissible> setMin(java.lang.Integer min) {
        this.min = Objects.requireNonNullElse(min, java.lang.Integer.MIN_VALUE);
        return this;
    }

    @Override
    public java.lang.Integer min() {
        return this.min;
    }

    @Override
    public @NotNull IntegerCommandArgument<CommandSrc, Permissible> build() {
        return new IntegerCommandArgument<>(this);
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }

    @Override
    public @NotNull CommandArgumentBuilder<CommandSrc, Permissible> setOptional(boolean optional) {
        this.isOptional = optional;
        return this;
    }
}
