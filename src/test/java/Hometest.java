import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class Hometest{
    @Test
    public void toolsQaForm () {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Galina");
        $("#lastName").setValue("Ponomareva");
        $("#userEmail").setValue("li.c@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9096201240");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/3.png");
        $("#currentAddress").setValue("Lesoparkovaya str 4");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Galina Ponomareva"));
        $(".modal-body").shouldHave(text("li.c@mail.ru"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9096201240"));
        $(".modal-body").shouldHave(text("13 March,1980"));
        $(".modal-body").shouldHave(text("Physics"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("3.png"));
        $(".modal-body").shouldHave(text("Lesoparkovaya str 4"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();

    }
}

