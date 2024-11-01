package org.cross.command.api.argument;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CommandArgumentBuilder<CommandSrc, Permissible> {

    @NotNull
    @CheckReturnValue
    CommandArgument<?, CommandSrc, Permissible> build();

    @CheckReturnValue
    boolean isOptional();

    @NotNull
    @CheckReturnValue
    CommandArgumentBuilder<CommandSrc, Permissible> setOptional(boolean optional);

    interface Number<This extends Number<This, N, CommandSrc, Permissible>, N extends java.lang.Number, CommandSrc, Permissible> extends CommandArgumentBuilder<CommandSrc, Permissible> {

        This setMax(@Nullable N max);

        N max();

        This setMin(@Nullable N min);

        N min();

        @Override
        @NotNull
        CommandArgument<N, CommandSrc, Permissible> build();

    }

    interface Integer<CommandSrc, Permissible> extends Number<Integer<CommandSrc, Permissible>, java.lang.Integer, CommandSrc, Permissible> {
    }

    interface Long<CommandSrc, Permissible> extends Number<Long<CommandSrc, Permissible>, java.lang.Long, CommandSrc, Permissible> {

    }

    interface Float<CommandSrc, Permissible> extends Number<Float<CommandSrc, Permissible>, java.lang.Float, CommandSrc, Permissible> {

    }

    interface Double<CommandSrc, Permissible> extends Number<Double<CommandSrc, Permissible>, java.lang.Double, CommandSrc, Permissible> {
    }

    interface Boolean<CommandSrc, Permissible> extends CommandArgumentBuilder<CommandSrc, Permissible> {

        @Override
        @NotNull
        CommandArgument<java.lang.Boolean, CommandSrc, Permissible> build();

    }

    interface String<CommandSrc, Permissible> extends CommandArgumentBuilder<CommandSrc, Permissible> {
        @CheckReturnValue
        @NotNull
        String<CommandSrc, Permissible> setConsumer(@NotNull StringConsumer consumer);

        @CheckReturnValue
        @NotNull
        StringConsumer consumer();

        @Override
        @NotNull
        CommandArgument<java.lang.String, CommandSrc, Permissible> build();

        enum StringConsumer {
            WORD,
            QUOTE,
            REMAINING
        }
    }

    interface Custom<CommandSrc, Permissible> extends CommandArgumentBuilder<CommandSrc, Permissible> {


    }

    interface Base<CommandSrc, Permissible> {

        @CheckReturnValue
        @NotNull
        Integer<CommandSrc, Permissible> integerType();

        @CheckReturnValue
        @NotNull
        Long<CommandSrc, Permissible> longType();

        @CheckReturnValue
        @NotNull
        Float<CommandSrc, Permissible> floatType();

        @CheckReturnValue
        @NotNull
        Double<CommandSrc, Permissible> doubleType();

        @CheckReturnValue
        @NotNull
        Boolean<CommandSrc, Permissible> booleanType();

        @CheckReturnValue
        @NotNull
        Custom<CommandSrc, Permissible> customType();

        @NotNull
        @CheckReturnValue
        String<CommandSrc, Permissible> stringType();
    }
}
