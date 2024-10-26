package org.cross.command.api.argument;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CommandArgumentBuilder {

    @NotNull
    @CheckReturnValue
    CommandArgument<?> build();

    @CheckReturnValue
    boolean isOptional();

    @NotNull
    @CheckReturnValue
    CommandArgumentBuilder setOptional(boolean optional);

    interface Number<This extends Number<This, N>, N extends java.lang.Number> extends CommandArgumentBuilder {

        This setMax(@Nullable N max);

        N max();

        This setMin(@Nullable N min);

        N min();

        @Override
        @NotNull
        CommandArgument<N> build();

    }

    interface Integer extends Number<Integer, java.lang.Integer> {
    }

    interface Long extends Number<Long, java.lang.Long> {

    }

    interface Float extends Number<Float, java.lang.Float> {

    }

    interface Double extends Number<Double, java.lang.Double> {
    }

    interface Boolean extends CommandArgumentBuilder {

        @Override
        @NotNull
        CommandArgument<java.lang.Boolean> build();

    }

    interface String extends CommandArgumentBuilder {
        @CheckReturnValue
        @NotNull
        String setConsumer(@NotNull StringConsumer consumer);

        @CheckReturnValue
        @NotNull
        StringConsumer consumer();

        @Override
        @NotNull CommandArgument<java.lang.String> build();

        enum StringConsumer {
            WORD,
            QUOTE,
            REMAINING
        }
    }

    interface Custom extends CommandArgumentBuilder {


    }

    interface Base {

        @CheckReturnValue
        @NotNull
        Integer integerType();

        @CheckReturnValue
        @NotNull
        Long longType();

        @CheckReturnValue
        @NotNull
        Float floatType();

        @CheckReturnValue
        @NotNull
        Double doubleType();

        @CheckReturnValue
        @NotNull
        Boolean booleanType();

        @CheckReturnValue
        @NotNull
        Custom customType();

        @NotNull
        @CheckReturnValue
        String stringType();
    }
}
