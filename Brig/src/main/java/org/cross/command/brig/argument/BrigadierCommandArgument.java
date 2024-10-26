package org.cross.command.brig.argument;

import com.mojang.brigadier.builder.ArgumentBuilder;
import org.cross.command.api.argument.CommandArgument;

public interface BrigadierCommandArgument<Src, Result> extends CommandArgument<Result> {

    ArgumentBuilder<Src, ? extends ArgumentBuilder<Src, ?>> buildBrigadier(String key);

}
