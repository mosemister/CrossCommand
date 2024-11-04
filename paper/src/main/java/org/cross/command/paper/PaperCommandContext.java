package org.cross.command.paper;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.cross.command.api.CrossCommand;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.brig.command.executable.ExecutableCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PaperCommandContext implements CommandContextImmutable<CommandSourceStack, CommandSender> {

    private final CommandContext<CommandSourceStack> context;
    private final ExecutableCommand<CommandSourceStack, CommandSender> command;

    @Nullable CommandSourceStack target;
    @Nullable CommandSender permissionHolder;
    @Nullable Audience audience;

    @Override
    public @NotNull CommandSender permissionHolder() {
        return Objects.requireNonNullElseGet(permissionHolder, () -> context.getSource().getSender());
    }

    @Override
    public @NotNull Audience audience() {
        return Objects.requireNonNullElseGet(audience, () -> context.getSource().getSender());
    }

    @Override
    public @NotNull CommandSourceStack target() {
        return Objects.requireNonNullElseGet(target, () -> context.getSource());
    }

    @Override
    public @NotNull CrossCommand<CommandSourceStack, CommandSender> command() {
        return this.command;
    }

    @Override
    public @NotNull @UnmodifiableView List<Map.Entry<String, Object>> argumentResults() {
        var mutableContext = new PaperMutableCommandContext(this);

        return this.command.arguments().stream().flatMap(entry -> {
            entry.getValue().process(mutableContext);
            return entry.getKey().stream().map(key -> Map.entry(key, ))
        })
        return List.of();
    }
}
