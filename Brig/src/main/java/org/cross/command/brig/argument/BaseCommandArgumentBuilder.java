package org.cross.command.brig.argument;

import org.cross.command.api.argument.CommandArgumentBuilder;
import org.cross.command.brig.argument.integer.IntegerCommandArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public interface BaseCommandArgumentBuilder<CommandSrc, Permissible> extends CommandArgumentBuilder.Base<CommandSrc, Permissible> {

    @Override
    @NotNull
    default IntegerCommandArgumentBuilder<CommandSrc, Permissible> integerType() {
        return new IntegerCommandArgumentBuilder<>();
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Double<CommandSrc, Permissible> doubleType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Boolean<CommandSrc, Permissible> booleanType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Custom<CommandSrc, Permissible> customType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Long<CommandSrc, Permissible> longType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.Float<CommandSrc, Permissible> floatType() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    @NotNull
    default CommandArgumentBuilder.String<CommandSrc, Permissible> stringType() {
        throw new RuntimeException("Not implemented yet");

    }
}
