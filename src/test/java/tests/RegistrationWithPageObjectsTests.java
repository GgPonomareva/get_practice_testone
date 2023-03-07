package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;
import static utils.RandomUtils.getRandomItemFromArray;

public class RegistrationWithPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void toolsQaForm() {
        Faker faker = new Faker();
        String userName = faker.name().firstName();

        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = faker.demographic().sex();
        String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
        String userBirthDay_day = String.format("%02d", faker.number().numberBetween(1, 28));
        String userBirthDay_month = getRandomItemFromArray(months);
        String userBirthDay_year = String.valueOf(faker.number().numberBetween(1950, 2005));
        String userSubjects = getRandomItemFromArray(subjects);
        String userHobbies = getRandomItemFromArray(hobbies);
        String userPictureLocation = "pictures/3.png";
        String userAddress = faker.address().fullAddress();
        String userState = "NCR";
        String userCity = getRandomItemFromArray(cities);

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGender(userGender);
        registrationPage.setNumber(userNumber);
        registrationPage.setBirthDay(userBirthDay_day, userBirthDay_month, userBirthDay_year);
        registrationPage.setSubjects(userSubjects);
        registrationPage.setHobbies(userHobbies);
        registrationPage.setPictures(userPictureLocation);
        registrationPage.setAddress(userAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);

        registrationPage.clickSubmit();
        registrationPage.verifyResultsModal();
        registrationPage.verifyResults("Student Name", userName + " " + lastName);
        registrationPage.verifyResults("Student Email", userEmail);
        registrationPage.verifyResults("Gender", userGender);
        registrationPage.verifyResults("Mobile", userNumber);
        registrationPage.verifyResults("Date of Birth", userBirthDay_day + " " + userBirthDay_month + "," + userBirthDay_year);
        registrationPage.verifyResults("Subjects", userSubjects);
        registrationPage.verifyResults("Hobbies", userHobbies);
        registrationPage.verifyResults("Address", userAddress);
        registrationPage.verifyResults("State and City", userState + " " + userCity);

        registrationPage.clickClose();

    }
}

