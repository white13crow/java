package ua.util;

@FunctionalInterface
public interface IdentityExtractor<T> {
    String getId(T object);
}
