package org.cross.command.brig.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;

public interface BrigadierCrossCommand<CommandSrc, Permissible> extends CrossCommand<CommandSrc, Permissible> {

    LiteralArgumentBuilder<CommandSrc> apply(LiteralArgumentBuilder<CommandSrc> builder);
}
