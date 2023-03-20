package parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileParsingTest {
    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    @Test
    void zipTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample-zip-file.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            boolean isFilePresent = false;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains("sample-zip-file")) isFilePresent =true;
            }

            Assertions.assertTrue(isFilePresent);
        }

    }

    @Test
    void jsonTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("jackson.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            ParserLibrary parserLibrary = mapper.readValue(isr, ParserLibrary.class);

            Assertions.assertEquals("2.13.1", parserLibrary.version);
            Assertions.assertEquals("Vasya Pupkin", parserLibrary.students.get(0).name);
        }
    }
}




