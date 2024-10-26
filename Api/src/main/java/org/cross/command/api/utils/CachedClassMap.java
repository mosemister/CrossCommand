package org.cross.command.api.utils;

import org.jetbrains.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CachedClassMap<To> {

    private final @NotNull Map<Class<?>, To> originalMapping;
    private final @NotNull Map<String, To> classMapping = new HashMap<>();

    public CachedClassMap() {
        this(Collections.emptyMap());
    }

    public CachedClassMap(Map<Class<?>, To> mappings) {
        this.originalMapping = new HashMap<>(mappings);
        this.originalMapping.forEach(this::registerCache);
    }

    private void registerCache(Class<?> cachedKey, To value) {
        classMapping.put(cachedKey.getName(), value);
    }

    public void register(@NotNull Class<?> key, @NotNull To value) {
        originalMapping.put(key, value);
        registerCache(key, value);
    }

    @CheckReturnValue
    public boolean hasKey(@NotNull Object from) {
        return hasKey(from.getClass());
    }

    @CheckReturnValue
    public boolean hasKey(@NotNull Class<?> key) {
        String fromName = key.getName();
        boolean cached = this.classMapping.containsKey(fromName);
        if (cached) {
            return true;
        }
        var opEntry = this.originalMapping.entrySet().stream().filter(entry -> entry.getKey().isAssignableFrom(key)).findAny();
        if (opEntry.isEmpty()) {
            return false;
        }
        var entry = opEntry.get();
        registerCache(entry.getKey(), entry.getValue());
        return true;
    }

    @NotNull
    @CheckReturnValue
    public To get(Object obj) {
        return get(obj.getClass());
    }

    @NotNull
    @CheckReturnValue
    public To get(@NotNull Class<?> fromClass) {
        String fromName = fromClass.getName();
        To cachedTo = this.classMapping.get(fromName);
        if (cachedTo == null) {
            var resultEntry = this.originalMapping.entrySet().stream().filter(entry -> entry.getKey().isAssignableFrom(fromClass)).findAny().orElseThrow(() -> new IllegalArgumentException("No Mapping for '" + fromClass.getName() + "'"));
            registerCache(resultEntry.getKey(), resultEntry.getValue());
            cachedTo = resultEntry.getValue();
        }
        return cachedTo;
    }


}
