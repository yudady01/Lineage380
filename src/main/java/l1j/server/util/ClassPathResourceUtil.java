package l1j.server.util;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class ClassPathResourceUtil {
    public static InputStream getInputStreamFromClasspath(@NonNull String path) {
        return ClassPathResourceUtil.class.getClassLoader().getResourceAsStream(path);
    }

    @SneakyThrows
    public static String getPathFromClasspath(@NonNull String path) {
        return ClassPathResourceUtil.class.getClassLoader().getResource(path).toURI().toString();
    }

    @SneakyThrows
    public static File getFileFromClasspath(@NonNull String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);
        if (classPathResource.exists()) {
            URL url = classPathResource.getURL();
            URI uri = url.toURI();

            String absPath = uri.getPath();
            return new File(absPath);
        }
        log.error("path not found :{}", path);
        return new File("");

    }
}
