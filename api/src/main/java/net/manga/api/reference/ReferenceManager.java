package net.manga.api.reference;

import java.util.function.Consumer;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public interface ReferenceManager<T> {
    ValueReference<T> createReference(@NonNull T value);

    void releaseReference(@NonNull ValueReference<T> reference);

    // Create a fetching reference
    // No matter if it's weak or not, it will return strong either hashable or not
    // This is used just for fetching by keys, to not create a real java ref
    ValueReference<T> createFetchingReference(@NotNull T value);

    Runnable onReferenceRemove(Consumer<ValueReference<T>> referenceConsumer);
}