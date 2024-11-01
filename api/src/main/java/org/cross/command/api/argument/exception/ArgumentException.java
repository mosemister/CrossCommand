package org.cross.command.api.argument.exception;

import org.cross.command.api.argument.CommandArgument;
import org.jetbrains.annotations.NotNull;

public class ArgumentException extends Exception {

    private final @NotNull CommandArgument<?, ?, ?> argument;

    public ArgumentException(@NotNull CommandArgument<?, ?, ?> argument, @NotNull String message) {
        super(message);
        this.argument = argument;
    }

    public ArgumentException(@NotNull CommandArgument<?, ?, ?> argument, @NotNull Throwable throwable) {
        super(throwable);
        this.argument = argument;
    }

    public ArgumentException(@NotNull CommandArgument<?, ?, ?> argument, @NotNull String message, @NotNull Throwable throwable) {
        super(message, throwable);
        this.argument = argument;
    }

    public CommandArgument<?, ?, ?> argument() {
        return this.argument;
    }

}
