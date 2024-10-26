package org.cross.command.api.argument;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface CommandArgumentBuilder {

    @NotNull
    @CheckReturnValue
    CommandArgument<?> build();

    boolean isOptional();

    @NotNull
    @CheckReturnValue
    CommandArgumentBuilder setOptional(boolean optional);



    interface Integer extends CommandArgumentBuilder {

        Integer max(int max);

        Integer min(int min);

        @Override
        @NotNull
        CommandArgument<java.lang.Integer> build();
    }


    interface Double extends CommandArgumentBuilder {

        Integer max(double max);

        Integer min(double min);

        @Override
        @NotNull
        CommandArgument<java.lang.Double> build();
    }

    interface Custom extends CommandArgumentBuilder {


    }

    interface Base {

        @CheckReturnValue
        @NotNull
        Integer integerType();

        @CheckReturnValue
        @NotNull
        Double doubleType();

        Custom customType();
    }
}
