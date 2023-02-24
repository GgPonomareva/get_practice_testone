import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Hometest4 {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1980";
    }
    @Test
    public void wikiTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".f6.Link--muted").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(Condition.text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
        $(".highlight.highlight-source-java.notranslate.position-relative.overflow-auto").shouldHave(Condition.text("public class Tests {\n" +
                "  @Test\n" +
                "  public void test() {\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        sleep(2000);
    }

}
