package org.cross.command.paper.argument;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.cross.command.api.argument.ArgumentContext;
import org.cross.command.paper.PaperCommandContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class PaperRunningArgumentContext implements ArgumentContext {

    private final PaperCommandContext context;
    private @Nullable Map<String, ParsedArgument<CommandSourceStack, ?>> extracted;
    private int index;

    private Map<String, ParsedArgument<CommandSourceStack, ?>> extractResults() throws NoSuchFieldException, IllegalAccessException {
        var field = CommandContext.class.getField("arguments");
        field.setAccessible(true);
        var result = field.get(commandContext());
        field.setAccessible(false);
        return (Map<String, ParsedArgument<CommandSourceStack, ?>>) result;
    }

    @Override
    public @NotNull Map<String, Object> results() {
        var map = Objects.requireNonNullElseGet(extracted, () -> {
            try {
                return extractResults();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error extracting arguments from CommandContext", e);
            }
        });
        this.extracted = map;
        return this.extracted
                .entrySet()
                .stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().getResult()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    protected abstract CommandContext<CommandSourceStack> commandContext();
    protected void nextIndex(){
        index++;
    }

    @Override
    public int index() {
        return this.index;
    }

    @Override
    public @NotNull String raw() {
        var raw =  commandContext().getInput();
        var map = Objects.requireNonNullElseGet(extracted, () -> {
            try {
                return extractResults();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error extracting arguments from CommandContext", e);
            }
        });

    }

    @Override
    public @NotNull String parseString() {
        return "";
    }

    @Override
    public int parseInteger() {
        return 0;
    }

    @Override
    public @NotNull String singleString() {
        return "";
    }

    @Override
    public @NotNull String quotedString() {
        return "";
    }

    @Override
    public @NotNull String remainingStrings() {
        return "";
    }
}
