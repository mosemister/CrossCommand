package org.cross.command.api.execution.exception;

import org.cross.command.api.execution.CommandExecutor;
import org.jetbrains.annotations.NotNull;

public class CommandException extends Exception {

    public CommandException(@NotNull String userMessage) {
        super(userMessage);
    }

    public CommandException(@NotNull Throwable throwable) {
        super(throwable);
    }

    public CommandException(@NotNull String message, @NotNull Throwable throwable) {
        super(message, throwable);
    }
}
