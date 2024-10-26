package org.cross.command.brig.argument;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.brig.argument.integer.IntegerCommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public interface BaseCommandArgumentBuilder<Src> extends CommandArgumentBuilder.Base {

    @Override
    @NotNull
    default IntegerCommandArgumentBuilder<Src> integerType() {
        return new IntegerCommandArgumentBuilder<>();
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Double doubleType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Boolean booleanType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Custom customType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Long longType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Float floatType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.String stringType() {
        throw new RuntimeException("Not implemented yet");

    }
}
