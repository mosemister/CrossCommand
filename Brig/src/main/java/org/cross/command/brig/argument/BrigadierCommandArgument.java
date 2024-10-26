package org.cross.command.brig.argument;

import com.mojang.brigadier.builder.ArgumentBuilder;
import org.cross.command.api.argument.CommandArgument;

public interface BrigadierCommandArgument<Src, Result> extends CommandArgument<Result> {

    <Builder extends ArgumentBuilder<Src, Builder>> ArgumentBuilder<Src, Builder> buildBrigadier(String key);

}
