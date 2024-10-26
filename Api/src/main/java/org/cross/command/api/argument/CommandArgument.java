package org.cross.command.api.argument;

import org.cross.command.api.argument.exception.ArgumentException;
import org.cross.command.api.argument.suggestion.ArgumentSuggestion;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandContextMutable;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface CommandArgument<Result> {

    @NotNull
    @CheckReturnValue
    Result process(@NotNull CommandContextMutable commandContext, @NotNull ArgumentContext context) throws ArgumentException;

    @NotNull
    @CheckReturnValue
    Collection<ArgumentSuggestion> suggest(@NotNull CommandContextImmutable commandContext, @NotNull ArgumentContext context);

    @NotNull
    @CheckReturnValue
    Collection<String> examples();

    boolean isOptional();

}