package org.cross.command.api.argument;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface ArgumentContext {

    @NotNull
    @CheckReturnValue
    Map<String, Object> results();

    @CheckReturnValue
    int index();

    @CheckReturnValue
    @NotNull
    String raw();

    @CheckReturnValue
    @NotNull
    String parseString();

    @CheckReturnValue
    int parseInteger();

    @CheckReturnValue
    @NotNull
    String singleString();

    @CheckReturnValue
    @NotNull
    String quotedString();

    @CheckReturnValue
    @NotNull
    String remainingStrings();

}
