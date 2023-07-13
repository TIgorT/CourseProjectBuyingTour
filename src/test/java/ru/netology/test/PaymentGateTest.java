package ru.netology.test;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentGatePage;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

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
    public void paymentForTheTripOfTheDayTourUsingOneDigitalSymbolInTheCardNumberField() {
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
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheCardNumberField() {
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
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheCardNumberField() {
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
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCardNumberField() {
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

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного цифрового символа в поле 'Месяц'")

    public void paymentForTheJourneyOfTheDayTourUsingOneDigitalSymbolInTheMonthField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingASingleNumericCharacter());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием трёх цифровых символов в поле 'Месяц'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheMonthField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingThreeNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheMonthField();
        Assertions.assertEquals(DataHelper.generateAMonthUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура Путешествие дня с введением в поле Месяц значения 13")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheValueThirteenInTheMonthField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingTheValueThirteen());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Месяц'")
    public void paymentForTheJourneyOfTheDayTourUsingAlphabeticCharactersInTheMonthField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingAlphabeticCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheMonthField();
        Assertions.assertEquals("", quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Месяц'")
    public void paymentForTheTourTripOfTheDayUsingSpecialSymbolsInTheMonthField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingSpecialSymbols());
        String quantity = paymentGatePage.theNumberOfDigitsInTheMonthField();
        Assertions.assertEquals("", quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Месяц'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldMonth() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня'с использованием одного цифрового символа в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingOneDigitalSymbolInTheYearField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheYearUsingNumericCharacter());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием трёх цифровых символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheYearField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheYearUsingThreeNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheYearField();
        Assertions.assertEquals(DataHelper.generateTheYearUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Год' прошлогодней даты ")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfLastYearsDateInTheYearField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateLastYears());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Истёк срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Год' даты (плюс шесть лет к текущему году)")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheDatInTheYearFieldPlusSixYearsToTheCurrentYear() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearPlusSixYears());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheYearField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingAlphabeticCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheYearField();
        Assertions.assertEquals("", quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Год'")
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheYearField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingSpecialSymbols());
        String quantity = paymentGatePage.theNumberOfDigitsInTheYearField();
        Assertions.assertEquals("", quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Год'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldYear() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии латиницей через символ '-'")
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInLatinLettersSeparatedByAHyphen() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidHolderWithDoubleLastName());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButton("Успешно", "Операция одобрена Банком.");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного буквенного символа в поле 'Владелец'")
    // Баг нет сообщения об ошибке
    public void paymentForTheTourTravelOfTheDayUsingOneLetterCharacterInTheOwnerField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateOneLetterCharacter());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием двадцати двух буквенных символов в поле 'Владелец'")
    // Баг нет сообщения об ошибке 22 символа с пробелом
    public void paymentForTheTourTravelOfTheDayUsingTwentyTwoLetterCharactersInTheOwnerField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateTwentyTwoLetterCharactersIncludingSpaces());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Владелец' только имени на латинице")
    // Баг нет сообщения об ошибке на имя
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfOnlyTheNameInLatinInTheOwnerField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateOnlyNamesInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии кириллицей")
    // Баг нет сообщения об ошибке на ФИО кирил
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInCyrillic() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInCyrillic());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя спецсимволы")
    // Баг нет сообщения об ошибке Спец символы
    public void paymentForTheTripOfTheDayTourWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingSpecialCharacters() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameSpecialCharacters());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя цифровые символы")
    // Баг нет сообщения об ошибке цифр
    public void paymentForTheTripOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingNumericCharacters() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameNumbersCharacters());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Владелец'")
    // Баг нет сообщения об ошибке цифр
    public void paymentForTheTourTravelOfTheDayWithAnEmptyOwnerField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одно цифрового символа в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingASingleDigitSymbolInTheCVCCVVField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingNumericCharacter());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием четырёх цифровых символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingFourNumericCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingFourNumericCharacters());
        String quantity = paymentGatePage.theNumberOfDigitsInTheCVCCVVField();
        Assertions.assertEquals(DataHelper.generateTheCVCCVVUsingFourNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingAlphabeticCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingAlphabeticCharacters());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спецсимволов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingSpecialCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingSpecialCharacters());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пустого поля 'CVC/CVV'")
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCVCCVVField() {
        var mainPage = new MainPage();
        mainPage.clickButtonPay();
        var paymentGatePage = new PaymentGatePage();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

                                           //API сценарии
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными APPROVED карты ")
    // Почему 500? через постман 200!!!
   public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndAPPROVEDCardData(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(DataHelper.getValidApprovedCard())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными DECLINED карты ")
    // Почему 500? через постман 200!!!
    public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndDECLINEDCardData(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(DataHelper.getValidDeclinedCard())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым body ")
    // возможно баг
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyBody(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body("")
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута cardNumber в body, остальные данные заполнены валидно")
    // возможно баг
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheNumberAttributeInTheBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(DataHelper.bodyWithAnEmptyCardNumberField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }



}
