package parsing;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ParserLibrary {
    public String library;
    public String version;

    public String license;
    public List<String> tags;
    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date date;
    public List<Students> students;

    public static class Students {
        public String name;
        public String email;
        public String devId;
        public List<String> subjects;
        public String course;
    }

}