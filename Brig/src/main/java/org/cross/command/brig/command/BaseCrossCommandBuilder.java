package org.cross.command.brig.command;

import org.cross.command.api.CrossCommandBuilder;
import org.cross.command.brig.command.executable.ExecutableCommandBuilder;
import org.jetbrains.annotations.NotNull;

public interface BaseCrossCommandBuilder extends CrossCommandBuilder.Base {

    @Override
    default @NotNull ExecutableCommandBuilder executable(){
        return new ExecutableCommandBuilder();
    }
}
