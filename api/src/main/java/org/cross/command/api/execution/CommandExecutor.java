package org.cross.command.api.execution;

import org.cross.command.api.execution.exception.CommandException;

public interface CommandExecutor<CommandSrc, Permissible> {

    void execute(CommandContextImmutable<CommandSrc, Permissible> context) throws CommandException, Throwable;
}
