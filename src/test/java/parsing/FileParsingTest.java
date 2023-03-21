package parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.InvalidArgumentException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileParsingTest {
    private final ClassLoader cl = FileParsingTest.class.getClassLoader();

    private ZipEntry getFileEntryFromArchive(String archiveName, String filename) throws IOException {
        ZipEntry entry;

        try (InputStream is = cl.getResourceAsStream(archiveName);

             ZipInputStream zis = new ZipInputStream(is)) {

            while ((entry = zis.getNextEntry()) != null) {

                if (entry.getName().endsWith(filename)) return entry;

            }

            throw new InvalidArgumentException("File "+ filename + " not found in the archive" + archiveName);
        }
    }

    @Test
    void zipWithPdfTest() throws IOException {
        ZipEntry pdfEntry = getFileEntryFromArchive("sample-zip-file.zip", "sample.pdf");

        assert pdfEntry.getSize() > 0;

        System.out.println(pdfEntry.getSize());
    }

    @Test
    void zipWithXlsTest() throws IOException {
        ZipEntry xlsxEntry = getFileEntryFromArchive("sample-zip-file.zip", "sample3.xlsx");

        assert xlsxEntry.getSize() > 0;

        System.out.println(xlsxEntry.getSize());
    }

    @Test
    void zipWithCsvTest() throws IOException {
        ZipEntry csvEntry = getFileEntryFromArchive("sample-zip-file.zip", "sample2.csv");

        assert csvEntry.getSize() > 0;

        System.out.println(csvEntry.getSize());
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




