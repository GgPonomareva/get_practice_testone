package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void toolsQaForm () {
        String userName = "Galina";
        String lastName = "Ponomareva";
        String userEmail = "li.c@mail.ru";
        String userGender = "Female";
        String userNumber = "9096201240";
        String userBirthDay_day = "30";
        String userBirthDay_month = "January";
        String userBirthDay_year = "1990";
        String userSubjects = "Physics";
        String userHobbies = "Reading";
        String userPictureLocation = "pictures/3.png";
        String userAddress = "Lesoparkovaya str 4";
        String userState = "NCR";
        String userCity = "Delhi";

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

