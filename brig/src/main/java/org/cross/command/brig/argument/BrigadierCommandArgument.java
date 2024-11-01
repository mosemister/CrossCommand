package org.cross.command.brig.argument;

import com.mojang.brigadier.builder.ArgumentBuilder;
import org.cross.command.api.argument.CommandArgument;

public interface BrigadierCommandArgument<Result, CommandSrc, Permissible> extends CommandArgument<Result, CommandSrc, Permissible> {

    ArgumentBuilder<CommandSrc, ? extends ArgumentBuilder<CommandSrc, ?>> buildBrigadier(String key);

}
