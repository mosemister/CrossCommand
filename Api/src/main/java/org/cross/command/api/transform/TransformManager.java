package org.cross.command.api.transform;

import org.cross.command.api.transform.exception.TransformException;
import org.cross.command.api.utils.CachedClassMap;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TransformManager {

    private CachedClassMap<Map<String, Transform>> transform = new CachedClassMap<>();

    public <From extends Transformable, To> void register(@NotNull Transform<From, To> transform) {
        if (!this.transform.hasKey(transform.from())) {
            var result = new HashMap<>(Map.of(transform.to().getName(), (Transform) transform));
            this.transform.register(transform.from(), result);
            return;
        }
        var transformMap = this.transform.get(transform.from());
        if (transformMap.containsKey(transform.to().getName())) {
            throw new IllegalStateException("Transform from (" + transform.from().getName() + ") -> to (" + transform.to().getName() + ") already registered");
        }
        transformMap.put(transform.to().getName(), transform);
    }

    public <From extends Transformable, To> To get(From from, Class<To> to) throws TransformException {
        try {
            var map = this.transform.get(from);
            Transform<From, To> transform = (Transform<From, To>) map.get(to.getName());
            return transform.transform(from);
        } catch (IllegalArgumentException ex) {
            throw new TransformException(from.getClass(), to);
        }
    }


}
