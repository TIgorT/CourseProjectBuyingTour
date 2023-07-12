package ru.netology.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentGatePage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentGateTest {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера APPROVED карты")
    //Почему то  прогружает информацию об успехе через раз
    public void paymentForTheTripOfTheDayTourUsingASpecialAPPROVEDCardNumber() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.getValidApprovedCard();
        paymentGatePage.introductionOfValidDataApprovedCar(cardInfo, "Успешно", "Операция одобрена Банком.");
        var paymentStatus = SQLHelper.getStatusPayments();
        Assertions.assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера DECLINED карты")
    public void paymentForTheTourTravelOfTheDayUsingASpecialDECLINEDCardNumber() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var cardInfo = DataHelper.getValidDeclinedCard();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.introductionOfValidDataDeclinedCar(cardInfo);
        var paymentStatus = SQLHelper.getStatusPayments();
        Assertions.assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием шестнадцати рандомных цифровых символов в поле 'Номер карты'")
    //Почему то  прогружает информацию об успехе через раз
    public void paymentForTheTripOfTheDayTourWithTheGenerationOfASixteenDigitRandomCardNumber() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomSixteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButtonWithTheErrorInformation("Ошибка", "Ошибка! Банк отказал в проведении операции.");

    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием тринадцати цифровых символов в поле 'Номер карты'")
    // Баг № 2
    public void paymentForTheTripOfTheDayTourUsingThirteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomThirteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButton("Ошибка", "Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пятнадцати цифровых символов в поле 'Номер карты'")
    // Баг № 3
    public void paymentForTheTripOfTheDayTourUsingFifteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomFifteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButton("Ошибка", "Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием восемнадцати цифровых символов в поле 'Номер карты'")
    // Баг № 4 - не принимает 18 цифр
    public void paymentForTheTripOfTheDayTourUsingEighteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.randomEighteenNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCardNumberField();
        Assertions.assertEquals(DataHelper.randomEighteenNumericCharacters(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием девятнадцати цифровых символов в поле 'Номер карты'")
    // Баг № 5 - не принимает 19 цифр
    public void paymentForTheTripOfTheDayTourUsingNineteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.randomNineteenNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCardNumberField();
        Assertions.assertEquals(DataHelper.randomNineteenNumericCharacters(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием двадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingTwentyNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.randomTwentyNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCardNumberField();
        Assertions.assertEquals(DataHelper.randomTwentyNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного цифрового символа в поле 'Номер карты'")
    public  void paymentForTheTripOfTheDayTourUsingOneDigitalSymbolInTheCardNumberField(){
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomOneNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheCardNumberField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Номер карты'")
    public  void  paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheCardNumberField(){
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomAlphabeticCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCardNumberField();
        Assertions.assertEquals("", quantity);
    }
    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Номер карты'")
    public  void  paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheCardNumberField(){
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomSpecialCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCardNumberField();
        Assertions.assertEquals("", quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пустого поля 'Номер карты'")
    //Баг - неверное название ошибки
    public  void paymentForTheTourTravelOfTheDayUsingAnEmptyCardNumberField(){
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheCardNumberField("Поле обязательно для заполнения");
    }




}
