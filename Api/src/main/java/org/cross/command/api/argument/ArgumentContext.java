package org.cross.command.api.argument;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface ArgumentContext {

    @NotNull
    @CheckReturnValue
    Map<String, Object> results();


}
