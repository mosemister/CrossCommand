package org.cross.command.api.execution;

import org.cross.command.api.execution.exception.CommandException;

public interface CommandExecutor {

    void execute(CommandContextImmutable context) throws CommandException, Throwable;
}
