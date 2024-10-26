package org.cross.command.paper.source;

import org.bukkit.command.CommandSender;
import org.cross.command.api.source.CommandSource;
import org.cross.command.api.transform.TransformManager;
import org.cross.command.api.transform.exception.TransformException;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class GenericCommandSource implements CommandSource {

    private final @NotNull CommandSender sender;
    private final @NotNull Supplier<TransformManager> transformManagerGetter;

    public GenericCommandSource(@NotNull Supplier<TransformManager> transformManagerGetter, @NotNull CommandSender sender) {
        this.sender = sender;
        this.transformManagerGetter = transformManagerGetter;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public <To> @NotNull To transform(@NotNull Class<To> to) throws TransformException {
        return transformManagerGetter.get().get(this, to);
    }
}
