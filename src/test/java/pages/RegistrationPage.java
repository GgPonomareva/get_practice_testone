package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput =  $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmail = $("#userEmail"),
            userGenter =  $("#genterWrapper"),
            userNumber = $("#userNumber"),
            userSubjects = $("#subjectsInput"),
            userHobbies =  $("#hobbiesWrapper"),
            userPicture = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userState = $("#state"),
            userStateCityWrapper = $("#stateCity-wrapper"),
            userCity = $("#city"),
            submitButton = $("#submit"),
            closeButton = $("#closeLargeModal");


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

    }

    public void setFirstName(String value){

        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {

        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {

        userEmail.setValue(value);
    }
    public void setGenter(String value) {

        userGenter.$(byText(value)).click();
    }

    public void setNumber(String value) {
        userNumber.setValue(value);
    }

    public void setSubjects(String value) {
        userSubjects.setValue(value).pressEnter();
    }

    public void setHobbies(String hobbies) {
        userHobbies.$(byText(hobbies)).click();;
    }

    public void setPictures(String location) {
        userPicture.uploadFromClasspath(location);
    }

    public void setAddress(String value) {
        userCurrentAddress.setValue(value);
    }

    public void setState(String value) {
        userState.click();
        userStateCityWrapper.$(byText(value)).click();
    }

    public void setCity(String value) {
        userCity.click();
        userStateCityWrapper.$(byText(value)).click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void verifyResoultsModal () {
        registrationResultsModal.submittingForm();
    }

    public void verifyResoults (String key, String value) {
        registrationResultsModal.formResoults(key, value);
    }

    public void clickClose () {
        closeButton.click();
    }

    public void setBirthDay (String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
    }
}

