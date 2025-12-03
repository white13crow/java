package ua.util;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {

    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());
    private final List<T> storage = new ArrayList<>();
    private final IdentityExtractor<T> extractor;

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.extractor = extractor;
    }

    public void add(T item) {
        storage.add(item);
        logger.info("Added: " + item);
    }

    public void remove(T item) {
        storage.remove(item);
        logger.info("Removed: " + item);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(storage);
    }

    public Optional<T> findByIdentity(String id) {
        return storage.stream()
                .filter(o -> extractor.getId(o).equals(id))
                .findFirst();
    }
}

