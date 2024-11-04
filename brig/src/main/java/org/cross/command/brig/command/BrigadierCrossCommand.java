package org.cross.command.brig.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;

import java.util.Collection;

public interface BrigadierCrossCommand<CommandSrc, Permissible> extends CrossCommand<CommandSrc, Permissible> {

    Collection<LiteralArgumentBuilder<CommandSrc>> apply(LiteralArgumentBuilder<CommandSrc> builder);
}
