package uk.gov.cambsfire.lang;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

public final class Collectors {
    private Collectors() {

    }

    /**
     * Collect to a LinkedHashMaps
     */
    public static <T, K, U> Collector<T, ?, Map<K, U>> toOrderedMap(
            final Function<? super T, ? extends K> keyMapper,
            final Function<? super T, ? extends U> valueMapper) {
        return java.util.stream.Collectors.toMap(keyMapper,
                valueMapper,
                (u, v) -> {
                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                },
                LinkedHashMap::new);
    }

}
