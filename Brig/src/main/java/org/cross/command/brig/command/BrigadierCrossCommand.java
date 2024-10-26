package org.cross.command.brig.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.cross.command.api.CrossCommand;

public interface BrigadierCrossCommand<Src> extends CrossCommand {

    LiteralArgumentBuilder<Src> apply(LiteralArgumentBuilder<Src> builder);
}
