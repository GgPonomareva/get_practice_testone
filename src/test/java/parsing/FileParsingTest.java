package parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileParsingTest {
    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    @Test
    void zipTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample-zip-file");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                Assertions.assertTrue(entry.getName().contains("sample-zip-file"));
            }
        }
    }
}

