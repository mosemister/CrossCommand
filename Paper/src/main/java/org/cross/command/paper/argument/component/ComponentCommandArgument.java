package org.cross.command.paper.argument.component;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import net.kyori.adventure.text.Component;
import org.cross.command.api.argument.ArgumentContext;
import org.cross.command.api.argument.CommandArgument;
import org.cross.command.api.argument.exception.ArgumentException;
import org.cross.command.api.argument.suggestion.ArgumentSuggestion;
import org.cross.command.api.execution.CommandContextImmutable;
import org.cross.command.api.execution.CommandContextMutable;
import org.cross.command.brig.argument.BrigadierCommandArgument;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class ComponentCommandArgument implements BrigadierCommandArgument<Component, CommandSourceStack, CommandSender> {

    private final boolean isOptional;

    public ComponentCommandArgument(ComponentCommandArgumentBuilder builder) {
        isOptional = builder.isOptional();
    }

    @Override
    public ArgumentBuilder<CommandSourceStack, ? extends ArgumentBuilder<CommandSourceStack, ?>> buildBrigadier(String key) {
        return RequiredArgumentBuilder.argument(key, ArgumentTypes.component());
    }

    @Override
    public @NotNull Component process(@NotNull CommandContextMutable<CommandSourceStack, CommandSender> commandContext, @NotNull ArgumentContext context) throws ArgumentException {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Collection<ArgumentSuggestion> suggest(@NotNull CommandContextImmutable<CommandSourceStack, CommandSender> commandContext, @NotNull ArgumentContext context) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Collection<String> examples() {
        return ArgumentTypes.component().getExamples();
    }

    @Override
    public boolean isOptional() {
        return this.isOptional;
    }
}
