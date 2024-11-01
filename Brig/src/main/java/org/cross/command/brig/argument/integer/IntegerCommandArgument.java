package org.cross.command.brig.argument.integer;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import org.cross.command.api.argument.ArgumentContext;
import org.cross.command.api.argument.exception.ArgumentException;
import org.cross.command.api.argument.suggestion.ArgumentSuggestion;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandContextMutable;
import org.cross.command.brig.argument.BrigadierCommandArgument;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class IntegerCommandArgument<CommandSrc, Permissible> implements BrigadierCommandArgument<Integer, CommandSrc, Permissible> {

    private final int min;
    private final int max;
    private final boolean isOptional;

    IntegerCommandArgument(IntegerCommandArgumentBuilder<CommandSrc, Permissible> builder) {
        this.isOptional = builder.isOptional();
        this.min = builder.min();
        this.max = builder.max();
    }

    @Override
    public @NotNull Integer process(@NotNull CommandContextMutable<CommandSrc, Permissible> commandContext, @NotNull ArgumentContext context) throws ArgumentException {
        int parsed;
        try {
            parsed = context.parseInteger();
        } catch (NumberFormatException ex) {
            throw new ArgumentException(this, ex);
        }
        if (parsed > max) {
            throw new ArgumentException(this, "Cannot be above " + max);
        }
        if (parsed < min) {
            throw new ArgumentException(this, "Cannot be below " + min);
        }
        return parsed;
    }

    @Override
    public @NotNull Collection<ArgumentSuggestion> suggest(@NotNull CommandContextImmutable<CommandSrc, Permissible> commandContext, @NotNull ArgumentContext context) {
        return List.of();
    }

    @Override
    public @NotNull Collection<String> examples() {
        int diff = max - min;
        if (diff < 3) {
            return IntStream.range(this.min, this.max).boxed().map(Object::toString).toList();
        }
        int end = Integer.max(3, this.max);
        return IntStream.range(end - 3, end).boxed().map(Object::toString).toList();
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }

    @Override
    public ArgumentBuilder<CommandSrc, ? extends ArgumentBuilder<CommandSrc, ?>> buildBrigadier(String key) {
        return RequiredArgumentBuilder.argument(key, IntegerArgumentType.integer(this.min, this.max));
    }
}
