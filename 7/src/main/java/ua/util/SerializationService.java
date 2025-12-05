package ua.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ua.exception.DataSerializationException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class SerializationService {

    private static final Logger logger = Logger.getLogger(SerializationService.class.getName());

    private final ObjectMapper jsonMapper;
    private final YAMLMapper yamlMapper;

    public SerializationService() {
        jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        yamlMapper = new YAMLMapper();
        yamlMapper.registerModule(new JavaTimeModule());
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public <T> void saveJson(String path, List<T> data) {
        try {
            File f = new File(path);
            if (f.getParentFile() != null) f.getParentFile().mkdirs();
            jsonMapper.writeValue(f, data);
            logger.info("Saved JSON to " + path);
        } catch (IOException e) {
            logger.severe("JSON save failed: " + e.getMessage());
            throw new DataSerializationException("JSON save failed: " + path, e);
        }
    }

    public <T> List<T> loadJson(String path, Class<T[]> clazz) {
        try {
            T[] arr = jsonMapper.readValue(new File(path), clazz);
            logger.info("Loaded JSON from " + path);
            return List.of(arr);
        } catch (IOException e) {
            logger.severe("JSON load failed: " + e.getMessage());
            throw new DataSerializationException("JSON load failed: " + path, e);
        }
    }

    public <T> void saveYaml(String path, List<T> data) {
        try {
            File f = new File(path);
            if (f.getParentFile() != null) f.getParentFile().mkdirs();
            yamlMapper.writeValue(f, data);
            logger.info("Saved YAML to " + path);
        } catch (IOException e) {
            logger.severe("YAML save failed: " + e.getMessage());
            throw new DataSerializationException("YAML save failed: " + path, e);
        }
    }

    public <T> List<T> loadYaml(String path, Class<T[]> clazz) {
        try {
            T[] arr = yamlMapper.readValue(new File(path), clazz);
            logger.info("Loaded YAML from " + path);
            return List.of(arr);
        } catch (IOException e) {
            logger.severe("YAML load failed: " + e.getMessage());
            throw new DataSerializationException("YAML load failed: " + path, e);
        }
    }
}
