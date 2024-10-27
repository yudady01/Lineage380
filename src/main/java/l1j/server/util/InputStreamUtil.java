package l1j.server.util;

import java.io.InputStream;

public class InputStreamUtil {
    public static InputStream getInputStreamFromClasspath(String path) {
        return InputStreamUtil.class.getClassLoader().getResourceAsStream(path);
    }
}
