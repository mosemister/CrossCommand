package org.cross.command.api.execution;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.ComponentLike;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.argument.CommandArgument;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;

public interface CommandContextImmutable<CommandSrc, Permissible> extends CommandContext<CommandSrc, Permissible> {

    @NotNull
    @CheckReturnValue
    Permissible permissionHolder();

    @NotNull
    @CheckReturnValue
    Audience audience();

    @NotNull
    @CheckReturnValue
    CommandSrc target();

    default void sendMessage(@NotNull ComponentLike componentLike) {
        audience().sendMessage(componentLike);
    }

    @NotNull
    @CheckReturnValue
    CrossCommand<CommandSrc, Permissible> command();

    @NotNull
    @CheckReturnValue
    @UnmodifiableView
    List<Map.Entry<String, Object>> argumentResults();

    @SuppressWarnings("unchecked")
    @UnknownNullability
    default <T> T argumentResult(@NotNull String argumentId) {
        return (T) argumentResults()
                .stream()
                .filter(entry -> entry.getKey().equals(argumentId))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No argument with id of '" + argumentId + "' found"));
    }

    @UnknownNullability
    default <T> T argumentResult(@NotNull CommandArgument<T, CommandSrc, Permissible> argument) {
        return argumentResult(command().argumentKeys(argument).getFirst());
    }
}
