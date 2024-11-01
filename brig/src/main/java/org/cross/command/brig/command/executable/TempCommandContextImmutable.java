package org.cross.command.brig.command.executable;

import com.mojang.brigadier.context.CommandContext;
import net.kyori.adventure.audience.Audience;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.execution.CommandContextImmutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TempCommandContextImmutable<CommandSrc, Permissible> implements CommandContextImmutable<CommandSrc, Permissible> {

    private final @NotNull CommandContext<CommandSrc> context;
    private final CrossCommand<CommandSrc, Permissible> command;
    private @Nullable CommandSrc target;
    private @Nullable Audience audience;
    private @Nullable Permissible permissionTarget;

    public TempCommandContextImmutable(@NotNull CommandContext<CommandSrc> context, @NotNull CrossCommand<CommandSrc, Permissible> crossCommand) {
        this.context = context;
        this.command = crossCommand;
    }

    @Override
    public @NotNull Permissible permissionHolder() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Audience audience() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull CommandSrc target() {
        return Objects.requireNonNullElseGet(this.target, context::getSource);
    }

    @Override
    public CrossCommand<CommandSrc, Permissible> command() {
        return this.command;
    }

    @Override
    public @NotNull @UnmodifiableView List<Map.Entry<String, Object>> argumentResults() {
        throw new RuntimeException("Not implemented yet");
    }
}
