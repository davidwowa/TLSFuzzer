package tech.cybersword.tls.fuzzer.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader(String path) throws IOException {
        properties = new Properties();
        try (InputStream input = new FileInputStream(path)) {
            properties.load(input);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}