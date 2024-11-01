package org.cross.command.api;

import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.exception.CommandException;
import org.cross.command.api.source.CommandSource;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;

public interface CrossCommand {

    @CheckReturnValue
    boolean canRegister(@NotNull CommandSource source);

    @UnmodifiableView
    @CheckReturnValue
    @NotNull
    List<Map.Entry<List<String>, CommandArgument<?>>> arguments();

    void execute(@NotNull CommandContextImmutable context) throws CommandException, Throwable;

    default CommandArgument<?> argument(int index) {
        return this.arguments().get(index).getValue();
    }

    default CommandArgument<?> argument(@NotNull String key) {
        return this
                .arguments()
                .stream()
                .filter(entry -> entry.getKey().stream().anyMatch(entryKey -> entryKey.equals(key)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown key of '" + key + "'"))
                .getValue();
    }

}
