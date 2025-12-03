package ua.util;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {

    protected final List<T> data = new ArrayList<>();
    protected final Logger logger = Logger.getLogger(getClass().getName());

    public void add(T item) {
        data.add(item);
        logger.info("Added: " + item);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(data);
    }
}
