package org.cross.command.api.transform;

import org.cross.command.api.transform.exception.TransformException;
import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

public interface Transformable {

    @NotNull
    @CheckReturnValue
    <To> To transform(@NotNull Class<To> to) throws TransformException;


}
