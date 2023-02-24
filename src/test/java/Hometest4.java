import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class Hometest4 {
    @Test
    public void wikiTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".f6.Link--muted").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(Condition.text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }

}
