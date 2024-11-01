package org.cross.command.api.transform;

import org.cross.command.api.transform.exception.TransformException;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface Transform<From, To> {

    @NotNull
    @CheckReturnValue
    To transform(@NotNull From from) throws TransformException;

    @CheckReturnValue
    @NotNull
    Class<From> from();

    @CheckReturnValue
    @NotNull
    Class<To> to();

    @CheckReturnValue
    @NotNull
    default TransformException createException() {
        return new TransformException(from(), to());
    }

    @CheckReturnValue
    @NotNull
    default TransformException createException(@NotNull String message) {
        return new TransformException(from(), to(), message);
    }

    @CheckReturnValue
    @NotNull
    default TransformException createException(@NotNull Throwable throwable) {
        return new TransformException(from(), to(), throwable);
    }

    @CheckReturnValue
    @NotNull
    default TransformException createException(@NotNull String message, @NotNull Throwable throwable) {
        return new TransformException(from(), to(), message, throwable);
    }

}
