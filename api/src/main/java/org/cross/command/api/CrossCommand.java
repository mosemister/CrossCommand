package org.cross.command.api;

import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.exception.CommandException;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;

public interface CrossCommand<CommandSrc, Permissible> {

    @CheckReturnValue
    boolean canRegister(@NotNull CommandSrc source);

    @UnmodifiableView
    @CheckReturnValue
    @NotNull
    List<Map.Entry<List<String>, CommandArgument<?, CommandSrc, Permissible>>> arguments();

    void execute(@NotNull CommandContextImmutable<CommandSrc, Permissible> context) throws CommandException, Throwable;

    default CommandArgument<?, CommandSrc, Permissible> argument(int index) {
        return this.arguments().get(index).getValue();
    }

    default CommandArgument<?, CommandSrc, Permissible> argument(@NotNull String key) {
        return this
                .arguments()
                .stream()
                .filter(entry -> entry.getKey().stream().anyMatch(entryKey -> entryKey.equals(key)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown key of '" + key + "'"))
                .getValue();
    }

    @NotNull
    @UnmodifiableView
    default List<String> argumentKeys(@NotNull CommandArgument<?, CommandSrc, Permissible> argument) {
        return this
                .arguments()
                .stream()
                .filter(entry -> entry.getValue().equals(argument))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown argument")).getKey();
    }

}
