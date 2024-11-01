package org.cross.command.api.transform.exception;

import org.jetbrains.annotations.NotNull;

public class TransformException extends Exception {

    private final @NotNull Object from;
    private final @NotNull Class<?> to;

    public TransformException(@NotNull Object from, @NotNull Class<?> to) {
        super("Failed to transform '" + from.getClass().getName() + "' to '" + to.getName() + "'");
        this.from = from;
        this.to = to;
    }

    public TransformException(@NotNull Object from, @NotNull Class<?> to, @NotNull String message) {
        super(message);
        this.from = from;
        this.to = to;
    }

    public TransformException(@NotNull Object from, @NotNull Class<?> to, @NotNull Throwable throwable) {
        super(throwable);
        this.from = from;
        this.to = to;
    }

    public TransformException(@NotNull Object from, @NotNull Class<?> to, @NotNull String message, @NotNull Throwable throwable) {
        super(message, throwable);
        this.from = from;
        this.to = to;
    }

    public Object from() {
        return this.from;
    }

    public Class<?> to() {
        return this.to;
    }
}
